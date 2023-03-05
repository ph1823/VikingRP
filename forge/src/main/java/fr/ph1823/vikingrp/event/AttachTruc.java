package fr.ph1823.vikingrp.event;

import fr.ph1823.vikingrp.VikingProvider;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import static fr.ph1823.vikingrp.VikingRPMod.*;
public class AttachTruc {
    public static final ResourceLocation CAPABILITY_LOCATION = new ResourceLocation(MODID, "viking"); // On évite d'instancier à chaque fois le même objet

    @SubscribeEvent
    public void attachCapability(AttachCapabilitiesEvent<Entity> event) {
        logger.info("event AttachCapabilitiesEvent");
        event.addCapability(CAPABILITY_LOCATION, new VikingProvider()); // Ici, PollutionProvider est la classe que nous venons de créer et qui implémente ICapabilitySerializable
    }
}
