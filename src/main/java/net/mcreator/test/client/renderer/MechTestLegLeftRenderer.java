
package net.mcreator.test.client.renderer;

public class MechTestLegLeftRenderer extends MobRenderer<MechTestLegLeftEntity, ModelmechTest_legLeft<MechTestLegLeftEntity>> {

	public MechTestLegLeftRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelmechTest_legLeft(context.bakeLayer(ModelmechTest_legLeft.LAYER_LOCATION)), 0f);

	}

	@Override
	public ResourceLocation getTextureLocation(MechTestLegLeftEntity entity) {
		return new ResourceLocation("test:textures/entities/white_entity_texture.png");
	}

}
