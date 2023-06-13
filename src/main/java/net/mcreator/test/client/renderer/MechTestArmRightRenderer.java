
package net.mcreator.test.client.renderer;

public class MechTestArmRightRenderer extends MobRenderer<MechTestArmRightEntity, ModelmechTest_armRight<MechTestArmRightEntity>> {

	public MechTestArmRightRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelmechTest_armRight(context.bakeLayer(ModelmechTest_armRight.LAYER_LOCATION)), 0f);

	}

	@Override
	public ResourceLocation getTextureLocation(MechTestArmRightEntity entity) {
		return new ResourceLocation("test:textures/entities/white_entity_texture.png");
	}

}
