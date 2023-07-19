
package net.mcreator.test.client.screens;

import org.checkerframework.checker.units.qual.h;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.client.event.RenderGuiEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.Minecraft;

import net.mcreator.test.procedures.EnergyBarUIOverlayDisplayChunk9Procedure;
import net.mcreator.test.procedures.EnergyBarUIOverlayDisplayChunk8Procedure;
import net.mcreator.test.procedures.EnergyBarUIOverlayDisplayChunk7Procedure;
import net.mcreator.test.procedures.EnergyBarUIOverlayDisplayChunk6Procedure;
import net.mcreator.test.procedures.EnergyBarUIOverlayDisplayChunk5Procedure;
import net.mcreator.test.procedures.EnergyBarUIOverlayDisplayChunk4Procedure;
import net.mcreator.test.procedures.EnergyBarUIOverlayDisplayChunk3Procedure;
import net.mcreator.test.procedures.EnergyBarUIOverlayDisplayChunk2Procedure;
import net.mcreator.test.procedures.EnergyBarUIOverlayDisplayChunk20Procedure;
import net.mcreator.test.procedures.EnergyBarUIOverlayDisplayChunk1Procedure;
import net.mcreator.test.procedures.EnergyBarUIOverlayDisplayChunk19Procedure;
import net.mcreator.test.procedures.EnergyBarUIOverlayDisplayChunk18Procedure;
import net.mcreator.test.procedures.EnergyBarUIOverlayDisplayChunk17Procedure;
import net.mcreator.test.procedures.EnergyBarUIOverlayDisplayChunk16Procedure;
import net.mcreator.test.procedures.EnergyBarUIOverlayDisplayChunk15Procedure;
import net.mcreator.test.procedures.EnergyBarUIOverlayDisplayChunk14Procedure;
import net.mcreator.test.procedures.EnergyBarUIOverlayDisplayChunk13Procedure;
import net.mcreator.test.procedures.EnergyBarUIOverlayDisplayChunk12Procedure;
import net.mcreator.test.procedures.EnergyBarUIOverlayDisplayChunk11Procedure;
import net.mcreator.test.procedures.EnergyBarUIOverlayDisplayChunk10Procedure;
import net.mcreator.test.procedures.AllowIfInSurvivalOrAdventureModeProcedure;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.platform.GlStateManager;

@Mod.EventBusSubscriber({Dist.CLIENT})
public class EnergyBarUIOverlayNewOverlay {
	@SubscribeEvent(priority = EventPriority.LOWEST)
	public static void eventHandler(RenderGuiEvent.Pre event) {
		int w = event.getWindow().getGuiScaledWidth();
		int h = event.getWindow().getGuiScaledHeight();
		int posX = w / 2;
		int posY = h;
		Level world = null;
		double x = 0;
		double y = 0;
		double z = 0;
		Player entity = Minecraft.getInstance().player;
		if (entity != null) {
			world = entity.level;
			x = entity.getX();
			y = entity.getY();
			z = entity.getZ();
		}
		RenderSystem.disableDepthTest();
		RenderSystem.depthMask(false);
		RenderSystem.enableBlend();
		RenderSystem.setShader(GameRenderer::getPositionTexShader);
		RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
		RenderSystem.setShaderColor(1, 1, 1, 1);
		if (AllowIfInSurvivalOrAdventureModeProcedure.execute(entity)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("test:textures/screens/energy_bar_empty.png"));
			Minecraft.getInstance().gui.blit(event.getPoseStack(), posX + -91, posY + -31, 0, 0, 81, 8, 81, 8);

			if (EnergyBarUIOverlayDisplayChunk10Procedure.execute(entity)) {
				RenderSystem.setShaderTexture(0, new ResourceLocation("test:textures/screens/energy_bar_increment.png"));
				Minecraft.getInstance().gui.blit(event.getPoseStack(), posX + -51, posY + -31, 0, 0, 5, 8, 5, 8);
			}
			if (EnergyBarUIOverlayDisplayChunk9Procedure.execute(entity)) {
				RenderSystem.setShaderTexture(0, new ResourceLocation("test:textures/screens/energy_bar_increment.png"));
				Minecraft.getInstance().gui.blit(event.getPoseStack(), posX + -47, posY + -31, 0, 0, 5, 8, 5, 8);
			}
			if (EnergyBarUIOverlayDisplayChunk8Procedure.execute(entity)) {
				RenderSystem.setShaderTexture(0, new ResourceLocation("test:textures/screens/energy_bar_increment.png"));
				Minecraft.getInstance().gui.blit(event.getPoseStack(), posX + -43, posY + -31, 0, 0, 5, 8, 5, 8);
			}
			if (EnergyBarUIOverlayDisplayChunk7Procedure.execute(entity)) {
				RenderSystem.setShaderTexture(0, new ResourceLocation("test:textures/screens/energy_bar_increment.png"));
				Minecraft.getInstance().gui.blit(event.getPoseStack(), posX + -39, posY + -31, 0, 0, 5, 8, 5, 8);
			}
			if (EnergyBarUIOverlayDisplayChunk6Procedure.execute(entity)) {
				RenderSystem.setShaderTexture(0, new ResourceLocation("test:textures/screens/energy_bar_increment.png"));
				Minecraft.getInstance().gui.blit(event.getPoseStack(), posX + -35, posY + -31, 0, 0, 5, 8, 5, 8);
			}
			if (EnergyBarUIOverlayDisplayChunk5Procedure.execute(entity)) {
				RenderSystem.setShaderTexture(0, new ResourceLocation("test:textures/screens/energy_bar_increment.png"));
				Minecraft.getInstance().gui.blit(event.getPoseStack(), posX + -31, posY + -31, 0, 0, 5, 8, 5, 8);
			}
			if (EnergyBarUIOverlayDisplayChunk4Procedure.execute(entity)) {
				RenderSystem.setShaderTexture(0, new ResourceLocation("test:textures/screens/energy_bar_increment.png"));
				Minecraft.getInstance().gui.blit(event.getPoseStack(), posX + -27, posY + -31, 0, 0, 5, 8, 5, 8);
			}
			if (EnergyBarUIOverlayDisplayChunk3Procedure.execute(entity)) {
				RenderSystem.setShaderTexture(0, new ResourceLocation("test:textures/screens/energy_bar_increment.png"));
				Minecraft.getInstance().gui.blit(event.getPoseStack(), posX + -23, posY + -31, 0, 0, 5, 8, 5, 8);
			}
			if (EnergyBarUIOverlayDisplayChunk2Procedure.execute(entity)) {
				RenderSystem.setShaderTexture(0, new ResourceLocation("test:textures/screens/energy_bar_increment.png"));
				Minecraft.getInstance().gui.blit(event.getPoseStack(), posX + -19, posY + -31, 0, 0, 5, 8, 5, 8);
			}
			if (EnergyBarUIOverlayDisplayChunk1Procedure.execute(entity)) {
				RenderSystem.setShaderTexture(0, new ResourceLocation("test:textures/screens/energy_bar_increment.png"));
				Minecraft.getInstance().gui.blit(event.getPoseStack(), posX + -15, posY + -31, 0, 0, 5, 8, 5, 8);
			}
			RenderSystem.setShaderTexture(0, new ResourceLocation("test:textures/screens/mini_energy.png"));
			Minecraft.getInstance().gui.blit(event.getPoseStack(), posX + -100, posY + -32, 0, 0, 9, 9, 9, 9);

			RenderSystem.setShaderTexture(0, new ResourceLocation("test:textures/screens/mini_heart.png"));
			Minecraft.getInstance().gui.blit(event.getPoseStack(), posX + -100, posY + -40, 0, 0, 9, 9, 9, 9);

			if (EnergyBarUIOverlayDisplayChunk11Procedure.execute(entity)) {
				RenderSystem.setShaderTexture(0, new ResourceLocation("test:textures/screens/energy_bar_increment.png"));
				Minecraft.getInstance().gui.blit(event.getPoseStack(), posX + -55, posY + -31, 0, 0, 5, 8, 5, 8);
			}
			if (EnergyBarUIOverlayDisplayChunk12Procedure.execute(entity)) {
				RenderSystem.setShaderTexture(0, new ResourceLocation("test:textures/screens/energy_bar_increment.png"));
				Minecraft.getInstance().gui.blit(event.getPoseStack(), posX + -59, posY + -31, 0, 0, 5, 8, 5, 8);
			}
			if (EnergyBarUIOverlayDisplayChunk13Procedure.execute(entity)) {
				RenderSystem.setShaderTexture(0, new ResourceLocation("test:textures/screens/energy_bar_increment.png"));
				Minecraft.getInstance().gui.blit(event.getPoseStack(), posX + -63, posY + -31, 0, 0, 5, 8, 5, 8);
			}
			if (EnergyBarUIOverlayDisplayChunk14Procedure.execute(entity)) {
				RenderSystem.setShaderTexture(0, new ResourceLocation("test:textures/screens/energy_bar_increment.png"));
				Minecraft.getInstance().gui.blit(event.getPoseStack(), posX + -67, posY + -31, 0, 0, 5, 8, 5, 8);
			}
			if (EnergyBarUIOverlayDisplayChunk15Procedure.execute(entity)) {
				RenderSystem.setShaderTexture(0, new ResourceLocation("test:textures/screens/energy_bar_increment.png"));
				Minecraft.getInstance().gui.blit(event.getPoseStack(), posX + -71, posY + -31, 0, 0, 5, 8, 5, 8);
			}
			if (EnergyBarUIOverlayDisplayChunk16Procedure.execute(entity)) {
				RenderSystem.setShaderTexture(0, new ResourceLocation("test:textures/screens/energy_bar_increment.png"));
				Minecraft.getInstance().gui.blit(event.getPoseStack(), posX + -75, posY + -31, 0, 0, 5, 8, 5, 8);
			}
			if (EnergyBarUIOverlayDisplayChunk17Procedure.execute(entity)) {
				RenderSystem.setShaderTexture(0, new ResourceLocation("test:textures/screens/energy_bar_increment.png"));
				Minecraft.getInstance().gui.blit(event.getPoseStack(), posX + -79, posY + -31, 0, 0, 5, 8, 5, 8);
			}
			if (EnergyBarUIOverlayDisplayChunk18Procedure.execute(entity)) {
				RenderSystem.setShaderTexture(0, new ResourceLocation("test:textures/screens/energy_bar_increment.png"));
				Minecraft.getInstance().gui.blit(event.getPoseStack(), posX + -83, posY + -31, 0, 0, 5, 8, 5, 8);
			}
			if (EnergyBarUIOverlayDisplayChunk19Procedure.execute(entity)) {
				RenderSystem.setShaderTexture(0, new ResourceLocation("test:textures/screens/energy_bar_increment.png"));
				Minecraft.getInstance().gui.blit(event.getPoseStack(), posX + -87, posY + -31, 0, 0, 5, 8, 5, 8);
			}
			if (EnergyBarUIOverlayDisplayChunk20Procedure.execute(entity)) {
				RenderSystem.setShaderTexture(0, new ResourceLocation("test:textures/screens/energy_bar_increment.png"));
				Minecraft.getInstance().gui.blit(event.getPoseStack(), posX + -91, posY + -31, 0, 0, 5, 8, 5, 8);
			}
		}
		RenderSystem.depthMask(true);
		RenderSystem.defaultBlendFunc();
		RenderSystem.enableDepthTest();
		RenderSystem.disableBlend();
		RenderSystem.setShaderColor(1, 1, 1, 1);
	}
}
