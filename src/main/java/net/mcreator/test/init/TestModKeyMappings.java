
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.test.init;

import org.lwjgl.glfw.GLFW;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

import net.mcreator.test.network.MechJumpMessage;
import net.mcreator.test.network.MMUpgradeGUIToggleKeybindMessage;
import net.mcreator.test.network.MMChangeModeKeybindMessage;
import net.mcreator.test.TestMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class TestModKeyMappings {
	public static final KeyMapping MECH_JUMP = new KeyMapping("key.test.mech_jump", GLFW.GLFW_KEY_SPACE, "key.categories.movement") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				TestMod.PACKET_HANDLER.sendToServer(new MechJumpMessage(0, 0));
				MechJumpMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping MM_UPGRADE_GUI_TOGGLE_KEYBIND = new KeyMapping("key.test.mm_upgrade_gui_toggle_keybind", GLFW.GLFW_KEY_U, "key.categories.ui") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				TestMod.PACKET_HANDLER.sendToServer(new MMUpgradeGUIToggleKeybindMessage(0, 0));
				MMUpgradeGUIToggleKeybindMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping MM_CHANGE_MODE_KEYBIND = new KeyMapping("key.test.mm_change_mode_keybind", GLFW.GLFW_KEY_R, "key.categories.misc") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				TestMod.PACKET_HANDLER.sendToServer(new MMChangeModeKeybindMessage(0, 0));
				MMChangeModeKeybindMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};

	@SubscribeEvent
	public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
		event.register(MECH_JUMP);
		event.register(MM_UPGRADE_GUI_TOGGLE_KEYBIND);
		event.register(MM_CHANGE_MODE_KEYBIND);
	}

	@Mod.EventBusSubscriber({Dist.CLIENT})
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onClientTick(TickEvent.ClientTickEvent event) {
			if (Minecraft.getInstance().screen == null) {
				MECH_JUMP.consumeClick();
				MM_UPGRADE_GUI_TOGGLE_KEYBIND.consumeClick();
				MM_CHANGE_MODE_KEYBIND.consumeClick();
			}
		}
	}
}
