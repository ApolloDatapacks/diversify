package apollo.diversify.registry;

import apollo.diversify.Diversify;
import apollo.diversify.worldgen.feature.FallenLog;
import apollo.diversify.worldgen.feature.Rock;
import apollo.diversify.worldgen.feature.config.FallenLogConfig;
import apollo.diversify.worldgen.feature.config.RockConfig;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class FeatureRegistry {
    public static final Rock ROCK = new Rock(RockConfig.CODEC);
    public static final FallenLog FALLEN_LOG = new FallenLog(FallenLogConfig.CODEC);

    public static void register() {
        Registry.register(Registries.FEATURE, new Identifier(Diversify.MOD_ID, "rock"), ROCK);
        Registry.register(Registries.FEATURE, new Identifier(Diversify.MOD_ID, "fallen_log"), FALLEN_LOG);
    }
}
