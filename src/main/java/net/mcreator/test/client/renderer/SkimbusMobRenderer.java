
package net.mcreator.test.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.test.entity.SkimbusMobEntity;
import net.mcreator.test.client.model.Modelmb_blockIndicatorEntity;

public class SkimbusMobRenderer extends MobRenderer<SkimbusMobEntity, Modelmb_blockIndicatorEntity<SkimbusMobEntity>> {
	public SkimbusMobRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelmb_blockIndicatorEntity(context.bakeLayer(Modelmb_blockIndicatorEntity.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(SkimbusMobEntity entity) {
		return new ResourceLocation("test:textures/entities/white_entity_texture.png");
	}
}
