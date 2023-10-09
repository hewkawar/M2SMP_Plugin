package hewkawar.plugin.listener;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class CommandListener implements Listener {
    @EventHandler
    public void onMenuClick(InventoryClickEvent e) {
        if (e.getView().getTitle().equalsIgnoreCase(ChatColor.GREEN + "Player's Status")) {
            if (e.getCurrentItem() == null) {
                return;
            }

            e.setCancelled(true);
        }
    }
}
