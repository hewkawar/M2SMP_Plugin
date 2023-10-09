package hewkawar.plugin;

import org.bukkit.plugin.java.JavaPlugin;

public final class M2SMP extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

        getServer().getPluginManager().registerEvents(new JoinLeaveListener(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
