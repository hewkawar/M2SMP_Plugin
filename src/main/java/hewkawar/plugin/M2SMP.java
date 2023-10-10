package hewkawar.plugin;

import hewkawar.plugin.commands.StatusCommand;
import hewkawar.plugin.functions.DiscordWebhookSender;
import hewkawar.plugin.listener.ChatListener;
import hewkawar.plugin.listener.JoinLeaveListener;
import hewkawar.plugin.listener.CommandListener;
import hewkawar.plugin.listener.WorldListener;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class M2SMP extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        saveDefaultConfig();

        getConfig();

        // register Commands
        Objects.requireNonNull(getCommand("status")).setExecutor(new StatusCommand());

        // register Listener
        getServer().getPluginManager().registerEvents(new CommandListener(), this);
        getServer().getPluginManager().registerEvents(new JoinLeaveListener(this), this);
        getServer().getPluginManager().registerEvents(new ChatListener(this), this);
        getServer().getPluginManager().registerEvents(new WorldListener(this), this);

        // Check PlaceholderAPI is installed
        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
            Bukkit.getPluginManager().registerEvents(this, this);
        }

        String webhookUrl = getConfig().getString("webhookUrl");
        String OnStartedMessage = getConfig().getString("on-start-webhook");

        if (webhookUrl != null && OnStartedMessage != null) {
            DiscordWebhookSender.sendToDiscordWebhook(webhookUrl, OnStartedMessage, 2067276);
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        String webhookUrl = getConfig().getString("webhookUrl");
        String OnStopMessage = getConfig().getString("on-stop-webhook");

        if (webhookUrl != null && OnStopMessage != null) {
            DiscordWebhookSender.sendToDiscordWebhook(webhookUrl, OnStopMessage, 10038562);
        }
    }
}
