package net.dragonmc.org.amcpv2;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class Core implements Listener {

    private final AMCPv2 plugin;

    public Core(AMCPv2 plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        String playerIP = player.getAddress().getAddress().getHostAddress().split(":")[0];

        for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
            String onlinePlayerIP = onlinePlayer.getAddress().getAddress().getHostAddress().split(":")[0];

            if (playerIP.equals(onlinePlayerIP) && !player.equals(onlinePlayer)) {
                player.kickPlayer(getKickMessage());
            }
        }
    }

    public String getKickMessage() {
        String kickMessage = plugin.getConfig().getString("kick-message", "Multi-accounting is not allowed on this server.");
        if (kickMessage != null) {
            return ChatColor.translateAlternateColorCodes('&', kickMessage);
        }
        return "Multi-accountinAA this server.";
    }
}





