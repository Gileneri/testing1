
package net.mcreator.test.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.test.entity.SmoglinMobEntity;
import net.mcreator.test.client.model.Modelmb_blockIndicatorEntity;

public class SmoglinMobRenderer extends MobRenderer<SmoglinMobEntity, Modelmb_blockIndicatorEntity<SmoglinMobEntity>> {
	public SmoglinMobRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelmb_blockIndicatorEntity(context.bakeLayer(Modelmb_blockIndicatorEntity.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(SmoglinMobEntity entity) {
		return new ResourceLocation("test:textures/entities/white_entity_texture.png");
	}
}
