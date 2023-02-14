package apollo.diversify.registry;

import apollo.diversify.Diversify;
import apollo.diversify.worldgen.treedecorator.BranchAndBeehive;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;

public class TreeDecoratorRegistry {
    public static final TreeDecoratorType<BranchAndBeehive> BRANCH_AND_BEEHIVE = new TreeDecoratorType<>(BranchAndBeehive.CODEC);

    public static void register() {
        Registry.register(Registries.TREE_DECORATOR_TYPE, new Identifier(Diversify.MOD_ID, "branch_and_beehive"), BRANCH_AND_BEEHIVE);
    }
}
