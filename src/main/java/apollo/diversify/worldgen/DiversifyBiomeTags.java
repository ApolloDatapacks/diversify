package apollo.diversify.worldgen;

import apollo.diversify.Diversify;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;


public class DiversifyBiomeTags {
    public static final TagKey<Biome> HAS_BLOCK_PATCH = of("has_block_patch");
    public static final TagKey<Biome> HAS_COARSE_DIRT_PATCH = of("has_coarse_dirt_patch");
    public static final TagKey<Biome> HAS_ROCKS = of("has_rocks");
    public static final TagKey<Biome> HAS_FALLEN_BIRCH = of("fallen_log/has_birch");
    public static final TagKey<Biome> HAS_FALLEN_JUNGLE = of("fallen_log/has_jungle");
    public static final TagKey<Biome> HAS_FALLEN_OAK = of("fallen_log/has_oak");
    public static final TagKey<Biome> HAS_FALLEN_SPRUCE = of("fallen_log/has_spruce");


    private static TagKey<Biome> of(String id) {
        return TagKey.of(RegistryKeys.BIOME, new Identifier(Diversify.MOD_ID, id));
    }
}
