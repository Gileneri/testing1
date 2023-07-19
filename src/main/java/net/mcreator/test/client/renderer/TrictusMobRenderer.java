
package net.mcreator.test.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.test.entity.TrictusMobEntity;
import net.mcreator.test.client.model.Modelmb_blockIndicatorEntity;

public class TrictusMobRenderer extends MobRenderer<TrictusMobEntity, Modelmb_blockIndicatorEntity<TrictusMobEntity>> {
	public TrictusMobRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelmb_blockIndicatorEntity(context.bakeLayer(Modelmb_blockIndicatorEntity.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(TrictusMobEntity entity) {
		return new ResourceLocation("test:textures/entities/white_entity_texture.png");
	}
}
