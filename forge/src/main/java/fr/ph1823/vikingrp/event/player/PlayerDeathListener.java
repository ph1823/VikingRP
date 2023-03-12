package fr.ph1823.vikingrp.event.player;

import fr.ph1823.vikingrp.VikingRPMod;
import fr.ph1823.vikingrp.VikingRPNetwork;
import fr.ph1823.vikingrp.packet.PlayerDeathPacket;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class PlayerDeathListener {
    @SubscribeEvent
    public void onPlayerDeath(LivingDeathEvent event) {
        VikingRPMod.logger.info("player death");
        if(event.getEntity() instanceof EntityPlayer) {

            VikingRPNetwork.CHANNEL.sendTo(new PlayerDeathPacket(), ((EntityPlayerMP) event.getEntity()));
        }
    }
}
