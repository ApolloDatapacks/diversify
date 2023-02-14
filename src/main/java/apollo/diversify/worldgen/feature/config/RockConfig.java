package apollo.diversify.worldgen.feature.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

public class RockConfig implements FeatureConfig {
    public static final Codec<RockConfig> CODEC = RecordCodecBuilder.create((instance) -> {
        return instance.group(
            BlockStateProvider.TYPE_CODEC.fieldOf("state_provider").forGetter((rock) -> {
                return rock.state;
            }),
            Codec.doubleRange(1, 10).fieldOf("rock_size").orElse(1.5).forGetter((rock) -> {
                return rock.rockSize;
            }),
            IntProvider.createValidatingCodec(1, 10).fieldOf("rock_placements").orElse(ConstantIntProvider.create(3)).forGetter((rock) -> {
                return rock.rockPlacements;
            }),
            Codec.intRange(1, 6).fieldOf("max_rock_radius").orElse(1).forGetter((rock) -> {
                return rock.maxRockRadius;
            })
        ).apply(instance, RockConfig::new);
    });
    public final BlockStateProvider state;
    public final Double rockSize;
    public final IntProvider rockPlacements;
    public final int maxRockRadius;

    private RockConfig(BlockStateProvider state, Double rockSize, IntProvider rockPlacements, int maxRockRadius) {
        this.state = state;
        this.rockSize = rockSize;
        this.rockPlacements = rockPlacements;
        this.maxRockRadius = maxRockRadius;
    }
}
