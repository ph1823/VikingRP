package fr.ph1823.vikingrp.event;

import fr.ph1823.vikingrp.VikingRPStorage;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import static fr.ph1823.vikingrp.VikingRPMod.logger;

public class PlayerInteractListener {

    @SubscribeEvent
    public void onPlayerInteract(PlayerInteractEvent.EntityInteract event) {
        logger.info("event PlayerInteractEvent");
        //(event.getTarget() instanceof )
        //event.getEntityPlayer().startRiding(event.getTarget())
        event.getTarget().startRiding(event.getEntityPlayer());
        event.getEntityPlayer().getCapability(VikingRPStorage.POLLUTION_CAPABILITY, null).setRevive(!event.getEntityPlayer().getCapability(VikingRPStorage.POLLUTION_CAPABILITY, null).revive());
    }
}
