package apollo.diversify.worldgen.feature;

import apollo.diversify.worldgen.feature.config.RockConfig;
import com.mojang.serialization.Codec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.ForestRockFeature;
import net.minecraft.world.gen.feature.util.FeatureContext;

import java.util.function.Predicate;

public class Rock extends Feature<RockConfig> {
    public Rock(Codec<RockConfig> codec) {
        super(codec);
    }

    @Override
    public boolean generate(FeatureContext<RockConfig> context) {
        BlockState blockState;
        BlockPos blockPos = context.getOrigin();
        StructureWorldAccess world = context.getWorld();
        Random random = context.getRandom();
        RockConfig config = context.getConfig();
        while (blockPos.getY() > world.getBottomY() + 3 && (world.isAir(blockPos.down()) || !ForestRockFeature.isSoil(blockState = world.getBlockState(blockPos.down())) && !ForestRockFeature.isStone(blockState))) {
            blockPos = blockPos.down();
        }
        if (blockPos.getY() <= world.getBottomY() + 3) {
            return false;
        }
        for (int i = 0; i < config.rockPlacements.get(random); ++i) {
            for (BlockPos blockPos2 : BlockPos.iterate(blockPos.add(-config.maxRockRadius, -config.maxRockRadius, -config.maxRockRadius), blockPos.add(config.maxRockRadius, config.maxRockRadius, config.maxRockRadius))) {
                double j = (double)random.nextBetween(-2, 2)/5;
                if (!(blockPos2.getSquaredDistance(blockPos) <= (double)((config.rockSize * config.rockSize)-j))) continue;
                if (world.getBlockState(blockPos2) == Blocks.GRASS_BLOCK.getDefaultState() || world.getBlockState(blockPos2).isReplaceable()) {
                    world.setBlockState(blockPos2, config.state.get(random, blockPos), Block.NOTIFY_LISTENERS);
                }
            }
            blockPos = blockPos.add(-1 + random.nextInt(3), -random.nextInt(2), -1 + random.nextInt(3));
        }
        return true;
    }
}
