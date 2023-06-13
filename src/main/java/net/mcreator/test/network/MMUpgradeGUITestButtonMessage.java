
package net.mcreator.test.network;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class MMUpgradeGUITestButtonMessage {

	private final int buttonID, x, y, z;

	public MMUpgradeGUITestButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public MMUpgradeGUITestButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(MMUpgradeGUITestButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(MMUpgradeGUITestButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
		NetworkEvent.Context context = contextSupplier.get();
		context.enqueueWork(() -> {
			Player entity = context.getSender();
			int buttonID = message.buttonID;
			int x = message.x;
			int y = message.y;
			int z = message.z;

			handleButtonAction(entity, buttonID, x, y, z);
		});
		context.setPacketHandled(true);
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
		Level world = entity.level;
		HashMap guistate = MMUpgradeGUITestMenu.guistate;

		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;

		if (buttonID == 0) {

			MMUpgradeGUIButtonWhenClicked1Procedure.execute();
		}
		if (buttonID == 1) {

			MMUpgradeGUIButtonWhenClicked2Procedure.execute();
		}
		if (buttonID == 2) {

			MMUpgradeGUIButtonWhenClicked3Procedure.execute();
		}
		if (buttonID == 3) {

			MMUpgradeGUIButtonWhenClicked4Procedure.execute();
		}
		if (buttonID == 4) {

			MMUpgradeGUIButtonWhenClicked5Procedure.execute();
		}
		if (buttonID == 5) {

			MMUpgradeGUIButtonWhenClicked6Procedure.execute();
		}
		if (buttonID == 6) {

			MMUpgradeGUIButtonWhenClicked7Procedure.execute();
		}
		if (buttonID == 7) {

			MMUpgradeGUIButtonWhenClicked8Procedure.execute();
		}
		if (buttonID == 8) {

			MMUpgradeGUIButtonWhenClicked9Procedure.execute();
		}
		if (buttonID == 9) {

			MMUpgradeGUIButtonWhenClicked10Procedure.execute();
		}
		if (buttonID == 10) {

			MMUpgradeGUIButtonWhenClicked11Procedure.execute();
		}
		if (buttonID == 11) {

			MMUpgradeGUIButtonWhenClicked12Procedure.execute();
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		TestMod.addNetworkMessage(MMUpgradeGUITestButtonMessage.class, MMUpgradeGUITestButtonMessage::buffer, MMUpgradeGUITestButtonMessage::new, MMUpgradeGUITestButtonMessage::handler);
	}

}
