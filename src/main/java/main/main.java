package main;

import commands.commands;
import core.logger;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

import static main.whes1015.VersionCode;

public class main extends JavaPlugin implements Listener {

    public static Integer Support=22031;

    @Override
    public void onEnable() {
        if(VersionCode>=Support) {
            saveDefaultConfig();
            Objects.requireNonNull(getCommand("he")).setExecutor(new commands(this));
            Objects.requireNonNull(getCommand("loc")).setExecutor(new commands(this));
            logger.log("INFO", "Here_onEnable", "Loading Success! - Designed by ExpTech.tw!");
        }else {
            logger.log("WARN","Here_onEnable","Please update your Core version");
            Bukkit.getPluginManager().disablePlugins();
        }
    }

    @Override
    public void onDisable(){
        logger.log("INFO","Here_onDisable","Closing! Version: "+getDescription().getVersion());
    }
}
