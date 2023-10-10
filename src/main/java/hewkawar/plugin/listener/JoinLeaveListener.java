package hewkawar.plugin.listener;

import hewkawar.plugin.M2SMP;
import hewkawar.plugin.functions.DiscordWebhookSender;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.awt.*;

public class JoinLeaveListener implements Listener {
    private final M2SMP plugin;

    public JoinLeaveListener(M2SMP plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        String joinMessage = this.plugin.getConfig().getString("join-message");
        String joinMessageWebhook = this.plugin.getConfig().getString("join-message-webhook");
        String webhookUrl = this.plugin.getConfig().getString("webhookUrl");
        if (joinMessage != null){
            joinMessage = joinMessage.replace("%player%", e.getPlayer().getDisplayName());
            e.setJoinMessage(ChatColor.translateAlternateColorCodes('&', joinMessage));
        }
        if (webhookUrl != null && joinMessageWebhook != null) {
            joinMessageWebhook = joinMessageWebhook.replace("%player%", e.getPlayer().getDisplayName());
            DiscordWebhookSender.sendToDiscordWebhook(webhookUrl,joinMessageWebhook, 5763719);
        }
    }

    @EventHandler
    public void onLeave(PlayerQuitEvent e) {
        String LeaveMessage = this.plugin.getConfig().getString("leave-message");
        String LeaveMessageWebhook = this.plugin.getConfig().getString("leave-message-webhook");
        String webhookUrl = this.plugin.getConfig().getString("webhookUrl");
        if (LeaveMessage != null && LeaveMessageWebhook != null){
            LeaveMessage = LeaveMessage.replace("%player%", e.getPlayer().getDisplayName());
            e.setQuitMessage(ChatColor.translateAlternateColorCodes('&', LeaveMessage));
        }
        if (webhookUrl != null && LeaveMessageWebhook != null) {
            LeaveMessageWebhook = LeaveMessageWebhook.replace("%player%", e.getPlayer().getDisplayName());
            DiscordWebhookSender.sendToDiscordWebhook(webhookUrl,LeaveMessageWebhook, 15548997);

        }
    }
}
