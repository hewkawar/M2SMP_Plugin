package hewkawar.plugin.listener;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class JoinLeaveListener implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();

        e.setJoinMessage(ChatColor.RED + "[M2SMP] " + ChatColor.RESET + ChatColor.YELLOW + player.getDisplayName() + ChatColor.RESET + " joined the game");
    }

    @EventHandler
    public void onLeave(PlayerQuitEvent e) {
        Player player = e.getPlayer();

        e.setQuitMessage(ChatColor.RED + "[M2SMP] " + ChatColor.RESET + ChatColor.YELLOW + player.getDisplayName() + ChatColor.RESET + " left the game, Let's hope they come back.");
    }
}
