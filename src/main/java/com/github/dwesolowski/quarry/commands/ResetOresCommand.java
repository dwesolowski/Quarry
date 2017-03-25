package com.github.dwesolowski.quarry.commands;

import com.github.dwesolowski.quarry.Quarry;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Statistic;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ResetOresCommand implements CommandExecutor {

    private final Quarry plugin;

    public ResetOresCommand(Quarry plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (p.hasPermission("quarry.resetores")) {
                if ((args.length < 1) || (args.length > 1)) {
                    sender.sendMessage(ChatColor.RED + "Usage: /resetores <playerName>");
                    return false;
                }
                Player target = (Bukkit.getServer().getPlayerExact(args[0]));
                if (target == null) {
                    sender.sendMessage(ChatColor.RED + "Player " + ChatColor.GOLD + args[0] + ChatColor.GREEN + " In game use only!");
                    return false;
                }
                p.sendMessage(ChatColor.RED + "Resetting " + ChatColor.GRAY + target.getName() + ChatColor.RED + "'s ore statistics.");
                target.setStatistic(Statistic.MINE_BLOCK, Material.DIAMOND_ORE, 0);
                target.setStatistic(Statistic.MINE_BLOCK, Material.EMERALD_ORE, 0);
                target.setStatistic(Statistic.MINE_BLOCK, Material.REDSTONE_ORE, 0);
                target.setStatistic(Statistic.MINE_BLOCK, Material.LAPIS_ORE, 0);
                target.setStatistic(Statistic.MINE_BLOCK, Material.GOLD_ORE, 0);
                target.setStatistic(Statistic.MINE_BLOCK, Material.IRON_ORE, 0);
                target.setStatistic(Statistic.MINE_BLOCK, Material.COAL_ORE, 0);
                target.sendMessage(ChatColor.RED + "Your ore statistics were reset by " + ChatColor.GRAY + p.getDisplayName() + ChatColor.RED + ".");
                return true;
            } else {
                sender.sendMessage(ChatColor.RED + "You do not have permission to execute this command!");
            }
        } else {
            sender.sendMessage(ChatColor.RED + "Command not allowed in console, must be used in-game only!");
        }
        return false;
    }
}