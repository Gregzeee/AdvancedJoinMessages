package dev.gregzee.advancedjoinmessages.Events;

import dev.gregzee.advancedjoinmessages.AdvancedJoinMessages;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class LeaveListener implements Listener {

    public final AdvancedJoinMessages plugin;

    public LeaveListener(AdvancedJoinMessages plugin) {
        this.plugin = plugin;
    }

    public void onPlayerLeave(PlayerQuitEvent e) {
        // Getting the required messages from the config file and assigning them to their corresponding variables
        String leaveMessage = plugin.getConfig().getString("messages.leave-message");
        leaveMessage = leaveMessage.replace("{player}", e.getPlayer().getDisplayName());
        leaveMessage = leaveMessage.replace("{server-ip}", plugin.getConfig().getString("configurations.server-ip"));
        leaveMessage = leaveMessage.replace("{server-name}", plugin.getConfig().getString("configurations.server-name"));

        // setting the quit message
        e.setQuitMessage(leaveMessage);
    }
}
