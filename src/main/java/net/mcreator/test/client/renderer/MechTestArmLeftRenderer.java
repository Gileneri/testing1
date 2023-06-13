
package net.mcreator.test.client.renderer;

public class MechTestArmLeftRenderer extends MobRenderer<MechTestArmLeftEntity, ModelmechTest_armLeft<MechTestArmLeftEntity>> {

	public MechTestArmLeftRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelmechTest_armLeft(context.bakeLayer(ModelmechTest_armLeft.LAYER_LOCATION)), 0f);

	}

	@Override
	public ResourceLocation getTextureLocation(MechTestArmLeftEntity entity) {
		return new ResourceLocation("test:textures/entities/white_entity_texture.png");
	}

}
