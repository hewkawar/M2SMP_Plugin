package hewkawar.plugin;

import hewkawar.plugin.commands.StatusCommand;
import hewkawar.plugin.listener.JoinLeaveListener;
import hewkawar.plugin.listener.CommandListener;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class M2SMP extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic

        // register Commands
        Objects.requireNonNull(getCommand("status")).setExecutor(new StatusCommand());

        // register Listener
        getServer().getPluginManager().registerEvents(new CommandListener(), this);
        getServer().getPluginManager().registerEvents(new JoinLeaveListener(), this);

        // Check PlaceholderAPI is installed
        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
            Bukkit.getPluginManager().registerEvents(this, this);
        }


    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
