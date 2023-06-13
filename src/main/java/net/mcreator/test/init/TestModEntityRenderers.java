
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.test.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.test.client.renderer.BlockIndicatorEntity1Renderer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class TestModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(TestModEntities.BLOCK_INDICATOR_ENTITY_1.get(), BlockIndicatorEntity1Renderer::new);
	}
}
