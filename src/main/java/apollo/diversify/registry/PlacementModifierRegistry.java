package apollo.diversify.registry;

import apollo.diversify.Diversify;
import apollo.diversify.worldgen.placementmodifier.NoiseSlope;
import apollo.diversify.worldgen.placementmodifier.NoiseThreshold;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.placementmodifier.PlacementModifierType;

public class PlacementModifierRegistry {
    public static final PlacementModifierType<NoiseSlope> NOISE_SLOPE = () -> {
        return NoiseSlope.MODIFIER_CODEC;
    };
    public static final PlacementModifierType<NoiseThreshold> NOISE_THRESHOLD = () -> {
        return NoiseThreshold.MODIFIER_CODEC;
    };

    public static void register() {
        Registry.register(Registries.PLACEMENT_MODIFIER_TYPE, new Identifier(Diversify.MOD_ID, "noise_slope_count"), NOISE_SLOPE);
        Registry.register(Registries.PLACEMENT_MODIFIER_TYPE, new Identifier(Diversify.MOD_ID, "noise_threshold_count"), NOISE_THRESHOLD);
    }
}
