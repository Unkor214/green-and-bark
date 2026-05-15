package me.unkor.gab;

import me.unkor.gab.events.GabEvents;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Gab extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new GabEvents(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
