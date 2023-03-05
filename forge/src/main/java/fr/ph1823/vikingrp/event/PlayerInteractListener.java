package fr.ph1823.vikingrp.event;

import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class PlayerInteractListener {

    @SubscribeEvent
    public void onPlayerInteract(PlayerInteractEvent.EntityInteract event) {
        //(event.getTarget() instanceof )
        //event.getEntityPlayer().startRiding(event.getTarget())
        event.getTarget().startRiding(event.getEntityPlayer());
    }
}
