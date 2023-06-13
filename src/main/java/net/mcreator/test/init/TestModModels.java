
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.test.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.test.client.model.Modelmb_blockIndicatorEntity;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class TestModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(Modelmb_blockIndicatorEntity.LAYER_LOCATION, Modelmb_blockIndicatorEntity::createBodyLayer);
	}
}
