package apollo.diversify.registry;

import apollo.diversify.Diversify;
import apollo.diversify.worldgen.trunk.NoiseBasedStraight;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.trunk.TrunkPlacerType;

public class TrunkPlacerRegistry {
    public static final TrunkPlacerType<NoiseBasedStraight> NOISE_BASED_STRAIGHT = new TrunkPlacerType<>(NoiseBasedStraight.CODEC);

    public static void register() {
        Registry.register(Registries.TRUNK_PLACER_TYPE, new Identifier(Diversify.MOD_ID, "noise_based_straight"), NOISE_BASED_STRAIGHT);
    }
}
