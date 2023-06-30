package me.weedlylife.cores.commands;

import me.weedlylife.cores.CoreS;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class SitCommand implements CommandExecutor {
    CoreS main;

    public SitCommand(CoreS main) {
        this.main = main;
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only a player can use this command");
            return true;
        }
        Player p = (Player)sender;
        if (this.main.sitting.contains(p)) {
            p.sendMessage(ChatColor.YELLOW + "You are already sitting! shift to unsit!");
            return true;
        }
        this.main.sitting.add(p);
        Location location = p.getLocation().subtract(0.0D, 1.6D, 0.0D);
        World world = location.getWorld();
        assert world != null;
        ArmorStand chair = (ArmorStand)world.spawnEntity(location, EntityType.ARMOR_STAND);
        chair.setGravity(false);
        chair.setVisible(false);
        chair.setInvulnerable(false);
        chair.addPassenger((Entity)p);
        return true;
    }
}
