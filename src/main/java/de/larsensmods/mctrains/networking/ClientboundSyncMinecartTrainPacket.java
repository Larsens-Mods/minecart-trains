package de.larsensmods.mctrains.networking;

import de.larsensmods.mctrains.MinecartTrains;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.util.Identifier;

public record ClientboundSyncMinecartTrainPacket(int parentEntityID, int childEntityID) implements CustomPayload {

    public static final CustomPayload.Id<ClientboundSyncMinecartTrainPacket> TYPE = new CustomPayload.Id<>(Identifier.of(MinecartTrains.MOD_ID, "sync_minecart_chain"));
    public static final PacketCodec<RegistryByteBuf, ClientboundSyncMinecartTrainPacket> CODEC = PacketCodec.of((packet, buffer) -> {
        buffer.writeVarInt(packet.parentEntityID);
        buffer.writeVarInt(packet.childEntityID);
    }, buffer -> {
        int parentId = buffer.readVarInt();
        int childId = buffer.readVarInt();

        return new ClientboundSyncMinecartTrainPacket(parentId, childId);
    });

    @Override
    public Id<? extends CustomPayload> getId() {
        return TYPE;
    }

}
