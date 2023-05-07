package net.dragonmc.org.amcpv2;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public final class AMCPv2 extends JavaPlugin {
    private static File configFile;

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getLogger().info("§c§lMULTIACCOUNT &4Protection &6is enabled!"); // You can change the enable log here.
        getServer().getPluginManager().registerEvents(new Core(this), this);

        configFile = new File(getDataFolder(), "config.yml");

        if (!configFile.exists()) {
            configFile.getParentFile().mkdirs();
            try {
                configFile.createNewFile();
                getConfig().options().copyDefaults(true);
                saveConfig();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.getLogger().info("§c§lMULTIACCOUNT &4Protection &6is disabled!"); // You can change the disable log also.
    }
}



