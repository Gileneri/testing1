package net.mcreator.test.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class MMUpgradeGUIToggleKeybindOnKeyPressedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof Player _plr ? _plr.containerMenu instanceof MMUpgradeGUITestMenu : false) != true) {
			{
				if (entity instanceof ServerPlayer _ent) {
					BlockPos _bpos = new BlockPos(x, y, z);
					NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
						@Override
						public Component getDisplayName() {
							return Component.literal("MMUpgradeGUITest");
						}

						@Override
						public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
							return new MMUpgradeGUITestMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
						}
					}, _bpos);
				}
			}
		} else if ((entity instanceof Player _plr ? _plr.containerMenu instanceof MMUpgradeGUITestMenu : false) == true) {
			if (entity instanceof Player _player)
				_player.closeContainer();
		}
	}
}
