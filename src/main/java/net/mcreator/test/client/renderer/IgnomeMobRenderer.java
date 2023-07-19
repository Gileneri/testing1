
package net.mcreator.test.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.test.entity.IgnomeMobEntity;
import net.mcreator.test.client.model.Modelmb_blockIndicatorEntity;

public class IgnomeMobRenderer extends MobRenderer<IgnomeMobEntity, Modelmb_blockIndicatorEntity<IgnomeMobEntity>> {
	public IgnomeMobRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelmb_blockIndicatorEntity(context.bakeLayer(Modelmb_blockIndicatorEntity.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(IgnomeMobEntity entity) {
		return new ResourceLocation("test:textures/entities/white_entity_texture.png");
	}
}
