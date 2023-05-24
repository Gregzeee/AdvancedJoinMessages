package dev.gregzee.advancedjoinmessages;

import dev.gregzee.advancedjoinmessages.Events.JoinListener;
import dev.gregzee.advancedjoinmessages.Events.LeaveListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class AdvancedJoinMessages extends JavaPlugin {

    String PREFIX = getConfig().getString("prefix");

    @Override
    public void onEnable() {
        // Registering the Listeners
        getServer().getPluginManager().registerEvents(new JoinListener(this), this);
        getServer().getPluginManager().registerEvents(new LeaveListener(this), this);

        // Getting the config file
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();

        Bukkit.getLogger().info(PREFIX + "Has started up without any errors");

    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info(PREFIX + "Has disabled");
    }
}
