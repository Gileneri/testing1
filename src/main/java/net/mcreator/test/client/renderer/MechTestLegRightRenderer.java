
package net.mcreator.test.client.renderer;

public class MechTestLegRightRenderer extends MobRenderer<MechTestLegRightEntity, ModelmechTest_legRight<MechTestLegRightEntity>> {

	public MechTestLegRightRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelmechTest_legRight(context.bakeLayer(ModelmechTest_legRight.LAYER_LOCATION)), 0f);

	}

	@Override
	public ResourceLocation getTextureLocation(MechTestLegRightEntity entity) {
		return new ResourceLocation("test:textures/entities/white_entity_texture.png");
	}

}
