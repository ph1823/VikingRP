package fr.ph1823.vikingrp;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

import javax.annotation.Nonnull;

public class VikingProvider implements ICapabilitySerializable<NBTBase> {
    private IVikingRPCapability capability;

    public VikingProvider() {
        this.capability = new DefaultCapability();
    }
    @Nonnull
    @Override
    public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
        return capability == VikingRPStorage.POLLUTION_CAPABILITY;
    }

    @Nonnull
    @Override
    public <T> T getCapability(@Nonnull Capability<T> capability, EnumFacing facing) {
        return this.hasCapability(capability, facing) ? VikingRPStorage.POLLUTION_CAPABILITY.cast(this.capability) : null;
    }

    @Override
    public NBTBase serializeNBT() {
        return VikingRPStorage.POLLUTION_CAPABILITY.writeNBT(this.capability, null);
    }

    @Override
    public void deserializeNBT(NBTBase nbt) {
        VikingRPStorage.POLLUTION_CAPABILITY.readNBT(this.capability, null, nbt);
    }
}
