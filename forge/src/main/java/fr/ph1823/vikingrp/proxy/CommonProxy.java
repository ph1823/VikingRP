package fr.ph1823.vikingrp.proxy;

import fr.ph1823.vikingrp.capacity.DefaultCapability;
import fr.ph1823.vikingrp.capacity.IVikingRPCapability;
import fr.ph1823.vikingrp.capacity.VikingRPStorage;
import net.minecraftforge.common.capabilities.CapabilityManager;

public interface CommonProxy {

    public void registerSideEvents();

    default void preInit() {
        CapabilityManager.INSTANCE.register(IVikingRPCapability.class, new VikingRPStorage(), DefaultCapability::new);
    }
}
