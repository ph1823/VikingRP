package fr.ph1823.vikingrp;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;

import javax.annotation.Nullable;

public class VikingRPStorage implements Capability.IStorage <IVikingRPCapability> {
    @CapabilityInject(IVikingRPCapability.class)
    public static final Capability <IVikingRPCapability> POLLUTION_CAPABILITY = null;

    @Override
    public NBTBase writeNBT(Capability <IVikingRPCapability>capability, IVikingRPCapability instance, EnumFacing side) {
        // Écriture des données
        return new NBTTagCompound();
    }

    @Override
    public void readNBT(Capability <IVikingRPCapability>capability, IVikingRPCapability instance, EnumFacing side, NBTBase base) {
        if(base instanceof NBTTagCompound) {
            NBTTagCompound nbt = (NBTTagCompound)base;
            // Lecture des données
        }
    }
}
