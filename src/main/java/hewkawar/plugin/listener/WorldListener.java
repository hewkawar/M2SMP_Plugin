package hewkawar.plugin.listener;

import hewkawar.plugin.M2SMP;
import hewkawar.plugin.functions.DiscordWebhookSender;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;

public class WorldListener implements Listener {
    private final M2SMP plugin;

    public WorldListener(M2SMP plugin) {
        this.plugin = plugin;
    }
    @EventHandler
    public void onWorldChange(PlayerChangedWorldEvent e) {
        Player player = e.getPlayer();
        String worldName = e.getPlayer().getWorld().getName();
        String webhookUrl = this.plugin.getConfig().getString("webhookUrl");
        String WorldChangeText = this.plugin.getConfig().getString("world-change-message");
        String WorldChangeWebhook = this.plugin.getConfig().getString("world-change-webhook");

        if (WorldChangeText != null) {
            WorldChangeText = WorldChangeText.replace("%player%", player.getDisplayName());
            WorldChangeText = WorldChangeText.replace("%world_name%", worldName);
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', WorldChangeText));
        }

        if (webhookUrl != null && WorldChangeWebhook != null) {
            WorldChangeWebhook = WorldChangeWebhook.replace("%player%", player.getDisplayName());
            WorldChangeWebhook = WorldChangeWebhook.replace("%world_name%", worldName);
            DiscordWebhookSender.sendToDiscordWebhook(webhookUrl,WorldChangeWebhook, 10181046);
        }
    }
}
