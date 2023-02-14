package apollo.diversify.worldgen.placementmodifier;

import apollo.diversify.util.worldgen.SeededNoiseProvider;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.noise.DoublePerlinNoiseSampler;
import net.minecraft.util.math.random.CheckedRandom;
import net.minecraft.util.math.random.ChunkRandom;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.gen.placementmodifier.AbstractCountPlacementModifier;
import net.minecraft.world.gen.placementmodifier.PlacementModifierType;
public class NoiseSlope extends AbstractCountPlacementModifier {
    public static final Codec<NoiseSlope> MODIFIER_CODEC = RecordCodecBuilder.create((instance) -> {
        return instance.group(
                SeededNoiseProvider.MODIFIER_CODEC.fieldOf("noise_provider").forGetter((noiseSlope) -> {
                    return noiseSlope.noiseProvider;
                }), Codec.DOUBLE.fieldOf("noise_threshold").forGetter((noiseSlope) -> {
                    return noiseSlope.noiseThreshold;
                }), Codec.INT.fieldOf("slope").forGetter((noiseSlope) -> {
                    return noiseSlope.noiseCountMultiplier;
                }), Codec.INT.fieldOf("count_offset").orElse(0).forGetter((noiseSlope) -> {
                    return noiseSlope.noiseCountMultiplier;
                })).apply(instance, NoiseSlope::new);
    });
    private final DoublePerlinNoiseSampler noiseSampler;
    private final SeededNoiseProvider noiseProvider;
    private final double noiseThreshold;
    private final int noiseCountMultiplier;
    private final int countOffset;

    private NoiseSlope(SeededNoiseProvider noiseProvider, double noiseThreshold, int noiseCountMultiplier, int countOffset) {
        this.noiseSampler = DoublePerlinNoiseSampler.create(new ChunkRandom(new CheckedRandom(noiseProvider.seed)), noiseProvider.noiseParameters);
        this.noiseProvider = noiseProvider;
        this.noiseThreshold = noiseThreshold;
        this.noiseCountMultiplier = noiseCountMultiplier;
        this.countOffset = countOffset;
    }

    public static NoiseSlope of(SeededNoiseProvider noiseProvider, double noiseThreshold, int noiseCountMultiplier, int countOffset) {
        return new NoiseSlope(noiseProvider, noiseThreshold, noiseCountMultiplier, countOffset);
    }

    protected int getCount(Random random, BlockPos pos) {
        double d = this.noiseSampler.sample((double)pos.getX() * noiseProvider.xz_scale, (double)pos.getY() * noiseProvider.y_scale, (double)pos.getZ() * noiseProvider.xz_scale);
        return d < this.noiseThreshold ? this.countOffset : this.countOffset+(int)Math.ceil((d - this.noiseThreshold) * (double)this.noiseCountMultiplier);
    }

    public PlacementModifierType<?> getType() {
        return PlacementModifierType.NOISE_BASED_COUNT;
    }
}
