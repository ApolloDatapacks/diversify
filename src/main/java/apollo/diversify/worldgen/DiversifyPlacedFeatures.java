package apollo.diversify.worldgen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.PlacedFeature;
import static apollo.diversify.Diversify.MOD_ID;

public class DiversifyPlacedFeatures {
    public static final RegistryKey<PlacedFeature> ROCKS = RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(MOD_ID, "rocks"));
    public static final RegistryKey<PlacedFeature> BLOCK_PATCH = RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(MOD_ID, "block_patch"));
    public static final RegistryKey<PlacedFeature> COARSE_DIRT_PATCH = RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(MOD_ID, "coarse_dirt_patch"));
    public static final RegistryKey<PlacedFeature> FALLEN_BIRCH = RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(MOD_ID, "fallen_log/birch"));
    public static final RegistryKey<PlacedFeature> FALLEN_JUNGLE = RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(MOD_ID, "fallen_log/jungle"));
    public static final RegistryKey<PlacedFeature> FALLEN_OAK = RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(MOD_ID, "fallen_log/oak"));
    public static final RegistryKey<PlacedFeature> FALLEN_SPRUCE = RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(MOD_ID, "fallen_log/spruce"));

    public static void register() {
        BiomeModifications.addFeature(BiomeSelectors.tag(DiversifyBiomeTags.HAS_ROCKS), GenerationStep.Feature.VEGETAL_DECORATION, ROCKS);
        BiomeModifications.addFeature(BiomeSelectors.tag(DiversifyBiomeTags.HAS_BLOCK_PATCH), GenerationStep.Feature.VEGETAL_DECORATION, BLOCK_PATCH);
        BiomeModifications.addFeature(BiomeSelectors.tag(DiversifyBiomeTags.HAS_COARSE_DIRT_PATCH), GenerationStep.Feature.VEGETAL_DECORATION, COARSE_DIRT_PATCH);
        BiomeModifications.addFeature(BiomeSelectors.tag(DiversifyBiomeTags.HAS_FALLEN_BIRCH), GenerationStep.Feature.VEGETAL_DECORATION, FALLEN_BIRCH);
        BiomeModifications.addFeature(BiomeSelectors.tag(DiversifyBiomeTags.HAS_FALLEN_JUNGLE), GenerationStep.Feature.VEGETAL_DECORATION, FALLEN_JUNGLE);
        BiomeModifications.addFeature(BiomeSelectors.tag(DiversifyBiomeTags.HAS_FALLEN_OAK), GenerationStep.Feature.VEGETAL_DECORATION, FALLEN_OAK);
        BiomeModifications.addFeature(BiomeSelectors.tag(DiversifyBiomeTags.HAS_FALLEN_SPRUCE), GenerationStep.Feature.VEGETAL_DECORATION, FALLEN_SPRUCE);
    }
}
