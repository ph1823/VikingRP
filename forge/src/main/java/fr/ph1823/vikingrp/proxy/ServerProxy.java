package fr.ph1823.vikingrp.proxy;

import fr.ph1823.vikingrp.event.player.PlayerDeathListener;
import net.minecraftforge.common.MinecraftForge;

public class ServerProxy implements CommonProxy{
    @Override
    public void registerSideEvents() {
        MinecraftForge.EVENT_BUS.register(new PlayerDeathListener());
    }
}
