package me.weedlylife.cores.listeners;

import me.weedlylife.cores.CoreS;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;

public class PlayerJoin implements Listener {
    CoreS main;

    public PlayerJoin(CoreS main) {
        this.main = main;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        e.setJoinMessage(ChatColor.WHITE + " + " + ChatColor.GREEN + p.getName());
        p.sendMessage(ChatColor.YELLOW + "Weclome to the survival!");
        p.setGameMode(GameMode.SURVIVAL);
        p.getWorld().playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1.0F, 2.0F);
        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this.main, () -> {
            p.setPlayerListFooter(ChatColor.YELLOW + "Your ping: " + ChatColor.GREEN + p.getPing() + ChatColor.YELLOW + "\n Online players: " + ChatColor.GREEN + Bukkit.getServer().getOnlinePlayers().size());
            p.setPlayerListHeader(ChatColor.GRAY + String.valueOf(ChatColor.BOLD) + ChatColor.UNDERLINE + "Survival");
        },20L, 300L);
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        Player player = e.getPlayer();
        String message = e.getMessage();
        String name = player.getDisplayName();
        e.setCancelled(true);
        Bukkit.broadcastMessage(" " + name + ChatColor.WHITE + ": " + ChatColor.RESET + message);
    }
}
