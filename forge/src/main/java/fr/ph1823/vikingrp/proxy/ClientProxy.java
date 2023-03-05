package fr.ph1823.vikingrp.proxy;

import fr.ph1823.vikingrp.event.RenderEvent;
import net.minecraftforge.common.MinecraftForge;

public class ClientProxy implements CommonProxy {
    @Override
    public void registerSideEvents() {
        MinecraftForge.EVENT_BUS.register(new RenderEvent());
    }
}
