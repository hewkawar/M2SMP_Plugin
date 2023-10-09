package hewkawar.plugin.listener;

import hewkawar.plugin.M2SMP;
import hewkawar.plugin.functions.DiscordWebhookSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class ChatListener implements Listener {
    private final M2SMP plugin;

    public ChatListener(M2SMP plugin) {
        this.plugin = plugin;
    }
    @EventHandler
    public void onMessageCreate(PlayerChatEvent e) {
        String message = e.getMessage();
        String player = e.getPlayer().getDisplayName();

        DiscordWebhookSender.sendToDiscordWebhook(this.plugin.getConfig().getString("webhookUrl"),"**" + player + "**: " + message, 3447003);
    }
}
