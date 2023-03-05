package fr.ph1823.vikingrp;

import fr.ph1823.vikingrp.events.PlayerInteractListener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class Main extends JavaPlugin {

    public Logger logger;
    public String prefix = "[VikingRP] ";


    @Override
    public void onLoad() {
        this.logger = getLogger();
        this.logger.info(prefix + " Load VikingRP plugin");
    }
    @Override
    public void onEnable() {

        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new PlayerInteractListener(), this);

        this.logger.info(prefix + " Finish load VikingRP plugin");
    }

    @Override
    public void onDisable() {}
}