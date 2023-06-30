package me.weedlylife.cores.commands;

import me.weedlylife.cores.CoreS;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PingCommand implements CommandExecutor {
    CoreS main;

    public PingCommand(CoreS main) {
        this.main = main;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player)sender;
            if (args.length == 0) {
                p.sendMessage(ChatColor.YELLOW + "You have: " + ChatColor.GREEN + p.getPing() + " ms" + ChatColor.YELLOW + ".");
                p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
            } else if (args.length == 1) {
                Player t = Bukkit.getServer().getPlayer(args[0]);
                if (t != null) {
                    p.sendMessage(ChatColor.GREEN + t.getName() + ChatColor.YELLOW + " has: " + ChatColor.GREEN + t.getPing() + " ms" + ChatColor.YELLOW + ".");
                    p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
                } else {
                    p.sendMessage(ChatColor.RED + "This player is not online!");
                }
            } else {
                p.sendMessage(ChatColor.RED + "Use /ping <player>");
            }
        } else {
            sender.sendMessage("You can only use this command ingame!");
        }
        return false;
    }
}
