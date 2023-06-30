package me.weedlylife.cores.listeners;

import me.weedlylife.cores.CoreS;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerLeave implements Listener {
    CoreS main;

    public PlayerLeave(CoreS main) {
        this.main = main;
    }

    @EventHandler
    public void onLeave(PlayerQuitEvent e) {
        Player p = e.getPlayer();
        e.setQuitMessage(ChatColor.WHITE + " - " + ChatColor.GREEN + p.getName());
    }
}
