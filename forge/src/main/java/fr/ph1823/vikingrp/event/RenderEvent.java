package fr.ph1823.vikingrp.event;

import com.mojang.realmsclient.gui.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class RenderEvent {
    private Minecraft mc = Minecraft.getMinecraft();
    @SubscribeEvent
    public void tick(RenderGameOverlayEvent event) {
        //TextFormatting.BLACK
        mc.fontRenderer.drawString(TextFormatting.RED + "VinkingRP " + TextFormatting.AQUA +"1.0", 0, 0, 0);
    }
}
