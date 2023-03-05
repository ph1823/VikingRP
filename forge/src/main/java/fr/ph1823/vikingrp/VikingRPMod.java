package fr.ph1823.vikingrp;

import fr.ph1823.vikingrp.event.PlayerInteractListener;
import fr.ph1823.vikingrp.proxy.CommonProxy;
import net.minecraft.init.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = VikingRPMod.MODID, name = VikingRPMod.NAME, version = VikingRPMod.VERSION)
public class VikingRPMod
{
    public static final String MODID = "vikingrp";
    public static final String NAME = "VikingRP";
    public static final String VERSION = "1.0.0";

    private static Logger logger;

    @SidedProxy(
            clientSide = "fr.ph1823.vikingrp.proxy.ClientProxy",
            serverSide = "fr.ph1823.vikingrp.proxy.ServerProxy"
    )
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();

    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        logger.info("Register Side event");
        MinecraftForge.EVENT_BUS.register(new PlayerInteractListener());
        proxy.registerSideEvents();
    }
}
