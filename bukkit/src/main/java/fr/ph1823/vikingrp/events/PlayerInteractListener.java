package fr.ph1823.vikingrp.events;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

public class PlayerInteractListener implements Listener {

    @EventHandler
    public void onPlayerRightClick(PlayerInteractEntityEvent event) {
       Entity e =  event.getRightClicked();
       Player p = event.getPlayer();
       p.addPassenger(e);
    }
}
