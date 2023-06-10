
package net.mcreator.test.world.biome;

import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;

import java.util.List;

public class Noise1Biome {
	public static final List<Climate.ParameterPoint> PARAMETER_POINTS = List.of(
			new Climate.ParameterPoint(Climate.Parameter.span(-0.9999f, -0.9999f), Climate.Parameter.span(-0.9999f, -0.9999f), Climate.Parameter.span(0.9999f, 1f), Climate.Parameter.span(-1.0001f, -1.0001f), Climate.Parameter.point(0.0f),
					Climate.Parameter.span(-1f, 1f), 0),
			new Climate.ParameterPoint(Climate.Parameter.span(-0.9999f, -0.9999f), Climate.Parameter.span(-0.9999f, -0.9999f), Climate.Parameter.span(0.9999f, 1f), Climate.Parameter.span(-1.0001f, -1.0001f), Climate.Parameter.point(1.0f),
					Climate.Parameter.span(-1f, 1f), 0));

	public static Biome createBiome() {
		BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder().fogColor(12638463).waterColor(4159204).waterFogColor(329011).skyColor(7972607).foliageColorOverride(10387789).grassColorOverride(9470285).build();
		BiomeGenerationSettings.Builder biomeGenerationSettings = new BiomeGenerationSettings.Builder();
		BiomeDefaultFeatures.addDefaultCarversAndLakes(biomeGenerationSettings);
		BiomeDefaultFeatures.addDefaultOres(biomeGenerationSettings);
		BiomeDefaultFeatures.addSurfaceFreezing(biomeGenerationSettings);
		MobSpawnSettings.Builder mobSpawnInfo = new MobSpawnSettings.Builder();
		return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.NONE).temperature(2f).downfall(0f).specialEffects(effects).mobSpawnSettings(mobSpawnInfo.build()).generationSettings(biomeGenerationSettings.build()).build();
	}
}
