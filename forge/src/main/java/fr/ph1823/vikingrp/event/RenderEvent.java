package fr.ph1823.vikingrp.event;

import fr.ph1823.vikingrp.capacity.VikingRPStorage;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.relauncher.ReflectionHelper;

import java.lang.reflect.Field;

public class RenderEvent {

    private final Field sleep = ReflectionHelper.findField(EntityPlayer.class, "sleeping", "field_71083_bS");
    private Minecraft mc = Minecraft.getMinecraft();

    @SubscribeEvent
    public void tick(RenderGameOverlayEvent event) {
        //EntityPlayer.class.getField("sleeping");
        //TextFormatting.BLACK
        if(event.getType() == RenderGameOverlayEvent.ElementType.TEXT) {
            mc.fontRenderer.drawString(TextFormatting.RED + "VinkingRP " + TextFormatting.AQUA + "1.0", 0, 0, 0);

            if (mc.player.getHealth() < 5 && mc.player.getCapability(VikingRPStorage.POLLUTION_CAPABILITY, null) != null)
                mc.player.getCapability(VikingRPStorage.POLLUTION_CAPABILITY, null).setRevive(true);
        }
    }

    @SubscribeEvent
    public void onPlayerRender(RenderPlayerEvent.Pre event) throws IllegalAccessException {
        //event.getRenderer().getMainModel().bipedHead. = .5f;
        if(mc.player.getCapability(VikingRPStorage.POLLUTION_CAPABILITY, null) != null) {
            if (mc.player.getCapability(VikingRPStorage.POLLUTION_CAPABILITY, null).revive()) {
                //event.getEntityPlayer().bedLocation = null;
                sleep.set(event.getEntityPlayer(), true);
            }
        }
    }

    @SubscribeEvent
    public void cameraSetup(EntityViewRenderEvent.CameraSetup event) {
        //GlStateManager.translate(0.0, 0.0, -1.5);
        event.setYaw(0.0F);
        event.setPitch(-90.0F);
    }

    @SubscribeEvent
    public void tick(TickEvent.RenderTickEvent event) {
        if(mc.player != null) {
            if(mc.player.getCapability(VikingRPStorage.POLLUTION_CAPABILITY, null) != null) {
                if(mc.player.getCapability(VikingRPStorage.POLLUTION_CAPABILITY, null).revive()) {
                    //mc.displayGuiScreen(new GuiErrorBase());
                }
            }

        }
    }
}
