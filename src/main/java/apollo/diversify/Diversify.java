package apollo.diversify;

import apollo.diversify.registry.FeatureRegistry;
import apollo.diversify.registry.PlacementModifierRegistry;
import apollo.diversify.registry.TreeDecoratorRegistry;
import apollo.diversify.registry.TrunkPlacerRegistry;
import apollo.diversify.worldgen.DiversifyBiomeTags;
import apollo.diversify.worldgen.DiversifyPlacedFeatures;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Diversify implements ModInitializer {
	public static final String MOD_ID = "diversify";
	public static final Logger LOGGER = LoggerFactory.getLogger("diversify");

	@Override
	public void onInitialize() {
		PlacementModifierRegistry.register();
		TrunkPlacerRegistry.register();
		TreeDecoratorRegistry.register();
		FeatureRegistry.register();

		DiversifyPlacedFeatures.register();
	}
}