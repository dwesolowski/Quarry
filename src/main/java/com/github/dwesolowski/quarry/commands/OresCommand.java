package com.github.dwesolowski.quarry.commands;

import com.github.dwesolowski.quarry.Quarry;
import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Statistic;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class OresCommand implements CommandExecutor {

    private final Quarry plugin;
    private String straightline = ChatColor.STRIKETHROUGH + StringUtils.repeat(" ", 80);

    public OresCommand(Quarry plugin) {
        this.plugin = plugin;
        this.straightline = ChatColor.STRIKETHROUGH + StringUtils.repeat(" ", 80);
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (p.hasPermission("quarry.ores")) {
                if (args.length == 0) {
                    int diamondOre = p.getStatistic(Statistic.MINE_BLOCK, Material.DIAMOND_ORE);
                    int emeraldOre = p.getStatistic(Statistic.MINE_BLOCK, Material.EMERALD_ORE);
                    int redstoneOre = p.getStatistic(Statistic.MINE_BLOCK, Material.REDSTONE_ORE);
                    int lapisOre = p.getStatistic(Statistic.MINE_BLOCK, Material.LAPIS_ORE);
                    int goldOre = p.getStatistic(Statistic.MINE_BLOCK, Material.GOLD_ORE);
                    int ironOre = p.getStatistic(Statistic.MINE_BLOCK, Material.IRON_ORE);
                    int coalOre = p.getStatistic(Statistic.MINE_BLOCK, Material.COAL_ORE);

                    sender.sendMessage(ChatColor.GRAY + this.straightline);
                    sender.sendMessage(ChatColor.GOLD + "Ore Statistics for " + ChatColor.WHITE + p.getName() + ChatColor.GOLD + ".");
                    sender.sendMessage(ChatColor.DARK_GRAY + " » " + ChatColor.AQUA + diamondOre + (diamondOre == 0 ? " Diamond" : " Diamonds"));
                    sender.sendMessage(ChatColor.DARK_GRAY + " » " + ChatColor.GREEN + emeraldOre + (emeraldOre == 0 ? " Emerald" : " Emeralds"));
                    sender.sendMessage(ChatColor.DARK_GRAY + " » " + ChatColor.RED + redstoneOre + " Redstone");
                    sender.sendMessage(ChatColor.DARK_GRAY + " » " + ChatColor.BLUE + lapisOre + " Lapis");
                    sender.sendMessage(ChatColor.DARK_GRAY + " » " + ChatColor.GOLD + goldOre + " Gold");
                    sender.sendMessage(ChatColor.DARK_GRAY + " » " + ChatColor.WHITE + ironOre + " Iron");
                    sender.sendMessage(ChatColor.DARK_GRAY + " » " + ChatColor.GRAY + coalOre + " Coal");
                    sender.sendMessage(ChatColor.GRAY + this.straightline);
                    return true;
                }
                if (args.length > 1) {
                    sender.sendMessage(ChatColor.RED + "Usage: /ores <playerName>");
                    return false;
                }
                Player target = (Bukkit.getServer().getPlayerExact(args[0]));
                if (target == null) {
                    sender.sendMessage(ChatColor.RED + "Statistics not available for player " + ChatColor.WHITE + args[0] + ChatColor.RED + "!");
                    return false;
                }
                int diamondOre = target.getStatistic(Statistic.MINE_BLOCK, Material.DIAMOND_ORE);
                int emeraldOre = target.getStatistic(Statistic.MINE_BLOCK, Material.EMERALD_ORE);
                int redstoneOre = target.getStatistic(Statistic.MINE_BLOCK, Material.REDSTONE_ORE);
                int lapisOre = target.getStatistic(Statistic.MINE_BLOCK, Material.LAPIS_ORE);
                int goldOre = target.getStatistic(Statistic.MINE_BLOCK, Material.GOLD_ORE);
                int ironOre = target.getStatistic(Statistic.MINE_BLOCK, Material.IRON_ORE);
                int coalOre = target.getStatistic(Statistic.MINE_BLOCK, Material.COAL_ORE);

                sender.sendMessage(ChatColor.GRAY + this.straightline);
                sender.sendMessage(ChatColor.GOLD + "Ore Statistics for " + ChatColor.WHITE + target.getName() + ChatColor.GOLD + ".");
                sender.sendMessage(ChatColor.DARK_GRAY + " » " + ChatColor.AQUA + diamondOre + (diamondOre == 0 ? " Diamond" : " Diamonds"));
                sender.sendMessage(ChatColor.DARK_GRAY + " » " + ChatColor.GREEN + emeraldOre + (emeraldOre == 0 ? " Emerald" : " Emeralds"));
                sender.sendMessage(ChatColor.DARK_GRAY + " » " + ChatColor.RED + redstoneOre + " Redstone");
                sender.sendMessage(ChatColor.DARK_GRAY + " » " + ChatColor.BLUE + lapisOre + " Lapis");
                sender.sendMessage(ChatColor.DARK_GRAY + " » " + ChatColor.GOLD + goldOre + " Gold");
                sender.sendMessage(ChatColor.DARK_GRAY + " » " + ChatColor.WHITE + ironOre + " Iron");
                sender.sendMessage(ChatColor.DARK_GRAY + " » " + ChatColor.GRAY + coalOre + " Coal");
                sender.sendMessage(ChatColor.GRAY + this.straightline);
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
