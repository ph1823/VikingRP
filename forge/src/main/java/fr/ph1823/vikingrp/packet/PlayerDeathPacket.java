package fr.ph1823.vikingrp.packet;

import fr.ph1823.vikingrp.VikingRPMod;
import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class PlayerDeathPacket implements IMessage {

    @Override
    public void fromBytes(ByteBuf buf) {
    }

    @Override
    public void toBytes(ByteBuf buf) {
    }

    public static class Handler implements IMessageHandler<PlayerDeathPacket, IMessage> {

        @Override
        public IMessage onMessage(PlayerDeathPacket message, MessageContext ctx) {
            VikingRPMod.logger.info("Received from server");
            return null; // no response in this case
        }
    }
}
