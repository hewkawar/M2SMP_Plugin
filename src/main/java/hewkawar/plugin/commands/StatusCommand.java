package hewkawar.plugin.commands;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class StatusCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] arg) {

        if (!(sender instanceof Player)) {
            sender.sendMessage("This command can only be executed by a player.");
            return true;
        }

        Player player = (Player) sender;

        Inventory inventory = Bukkit.createInventory(player, 9, ChatColor.GREEN + "Player's Status");

        // PlayerHead
        ItemStack playerHead = new ItemStack(Material.PLAYER_HEAD, 1);

        ItemMeta playerHeadItemMeta = playerHead.getItemMeta();

        playerHeadItemMeta.setDisplayName(ChatColor.RESET + PlaceholderAPI.setPlaceholders(player.getPlayer(), "%player_name%"));

        // PlayerHead Lore
        ArrayList<String> playerHeadLore = new ArrayList<>();
        playerHeadLore.add(ChatColor.WHITE + PlaceholderAPI.setPlaceholders(player.getPlayer(), "UUID : %player_uuid%"));
        playerHeadLore.add(ChatColor.WHITE + PlaceholderAPI.setPlaceholders(player.getPlayer(), "Play Time : %statistic_time_played%"));

        playerHeadItemMeta.setLore(playerHeadLore);

        playerHead.setItemMeta(playerHeadItemMeta);

        // Command Block
        ItemStack serverStatus = new ItemStack(Material.COMMAND_BLOCK, 1);

        ItemMeta serverStatusMeta = serverStatus.getItemMeta();

        serverStatusMeta.setDisplayName(ChatColor.RED + "M2SMP's Status");

        // serverStatus Lore
        ArrayList<String> serverStatusLore = new ArrayList<>();
        serverStatusLore.add(ChatColor.WHITE + PlaceholderAPI.setPlaceholders(player.getPlayer(), "Player : %server_online% / %server_max_players%"));
        serverStatusLore.add(ChatColor.WHITE + PlaceholderAPI.setPlaceholders(player.getPlayer(), "Version : %server_version%"));
        serverStatusLore.add(ChatColor.WHITE + PlaceholderAPI.setPlaceholders(player.getPlayer(), "Uptime : %server_uptime%"));
        serverStatusLore.add(ChatColor.WHITE + PlaceholderAPI.setPlaceholders(player.getPlayer(), "TPS : %server_tps%"));
        serverStatusLore.add(ChatColor.WHITE + PlaceholderAPI.setPlaceholders(player.getPlayer(), "Total Chunks : %server_total_chunks%"));
        serverStatusLore.add(ChatColor.WHITE + PlaceholderAPI.setPlaceholders(player.getPlayer(), "Total Entities : %server_total_entities%"));

        serverStatusMeta.setLore(serverStatusLore);

        serverStatus.setItemMeta(serverStatusMeta);

        inventory.setItem(4, playerHead);
        inventory.setItem(8, serverStatus);

        player.openInventory(inventory);

        return true;
    }
}
