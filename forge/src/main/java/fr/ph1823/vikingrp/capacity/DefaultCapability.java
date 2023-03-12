package fr.ph1823.vikingrp.capacity;

public class DefaultCapability implements IVikingRPCapability {
    private boolean revive = false;
    private boolean animate = false;
    @Override
    public void setRevive(boolean revive) {
        this.revive = revive;
    }

    @Override
    public boolean revive() {
        return this.revive;
    }

    @Override
    public void setAnimate(boolean animate) {
        this.animate = animate;
    }

    @Override
    public boolean animate() {
        return animate;
    }
}
