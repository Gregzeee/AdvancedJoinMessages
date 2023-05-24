package dev.gregzee.advancedjoinmessages.Events;

import dev.gregzee.advancedjoinmessages.AdvancedJoinMessages;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {

    public final AdvancedJoinMessages plugin;

    public JoinListener(AdvancedJoinMessages plugin) {
        this.plugin = plugin;
    }

    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();

        // Getting the required messages from the config file and assigning them to their corresponding variables
        String firstJoinMessage = plugin.getConfig().getString("messages.first-join-message");
        String joinMessage = plugin.getConfig().getString("messages.join-message");

        // Editing the join messages
        firstJoinMessage = firstJoinMessage.replace("{player}", e.getPlayer().getDisplayName());
        firstJoinMessage = firstJoinMessage.replace("{server-ip}", plugin.getConfig().getString("configurations.server-ip"));
        firstJoinMessage = firstJoinMessage.replace("{server-name}", plugin.getConfig().getString("configurations.server-name"));

        joinMessage = joinMessage.replace("{player}", e.getPlayer().getDisplayName());
        joinMessage = joinMessage.replace("{server-ip}", plugin.getConfig().getString("configurations.server-ip"));
        joinMessage = joinMessage.replace("{server-name}", plugin.getConfig().getString("configurations.server-name"));

        // Checking if the player just joined for the first time.
        if (!p.hasPlayedBefore()) {
            e.setJoinMessage(firstJoinMessage);
        } else { // If the player did not join for the first time the other message will be broadcasted to chat
            e.setJoinMessage(joinMessage);
        }
    }
}
