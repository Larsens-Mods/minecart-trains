package de.larsensmods.mctrains;

import de.larsensmods.mctrains.networking.ClientPacketHandler;
import de.larsensmods.mctrains.networking.ClientboundSyncMinecartTrainPacket;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;

public class MinecartTrainsClient implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
		ClientPlayNetworking.registerGlobalReceiver(ClientboundSyncMinecartTrainPacket.TYPE, (payload, context) -> {
			ClientPacketHandler.handleSyncMinecartTrain(payload);
		});
	}

}