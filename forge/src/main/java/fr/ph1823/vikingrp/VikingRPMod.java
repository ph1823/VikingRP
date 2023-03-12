package fr.ph1823.vikingrp;

import fr.ph1823.vikingrp.event.AttachTruc;
import fr.ph1823.vikingrp.event.PlayerInteractListener;
import fr.ph1823.vikingrp.packet.PlayerDeathPacket;
import fr.ph1823.vikingrp.proxy.CommonProxy;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import org.apache.logging.log4j.Logger;

@Mod(modid = VikingRPMod.MODID, name = VikingRPMod.NAME, version = VikingRPMod.VERSION)
public class VikingRPMod
{
    public static final String MODID = "vikingrp";
    public static final String NAME = "VikingRP";
    public static final String VERSION = "1.0.0";

    public static Logger logger;

    @SidedProxy(
            clientSide = "fr.ph1823.vikingrp.proxy.ClientProxy",
            serverSide = "fr.ph1823.vikingrp.proxy.ServerProxy"
    )
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
        proxy.preInit();
        VikingRPNetwork.CHANNEL.registerMessage(PlayerDeathPacket.Handler.class, PlayerDeathPacket.class, 0, Side.CLIENT);

    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        logger.info("Register Side event");
        MinecraftForge.EVENT_BUS.register(new PlayerInteractListener());
        MinecraftForge.EVENT_BUS.register(new AttachTruc());

        proxy.registerSideEvents();
    }



}
