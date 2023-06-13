
package net.mcreator.test.world.features;

import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

public class ToxicislandsFeature extends SimpleBlockFeature {
	private final Set<ResourceKey<Level>> generateDimensions = Set.of(ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation("test:higher")));

	public ToxicislandsFeature() {
		super(SimpleBlockConfiguration.CODEC);
	}

	public boolean place(FeaturePlaceContext<SimpleBlockConfiguration> context) {
		WorldGenLevel world = context.level();
		if (!generateDimensions.contains(world.getLevel().dimension()))
			return false;
		return super.place(context);
	}
}