package me.weedlylife.cores;

import java.util.ArrayList;
import java.util.Objects;
import me.weedlylife.cores.commands.PingCommand;
import me.weedlylife.cores.commands.SitCommand;
import me.weedlylife.cores.listeners.PlayerJoin;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class CoreS extends JavaPlugin {
    public static CoreS plugin;

    String consoleprefix = "[CoalCore]";

    String text = "ENABLED THE CORE.";

    public ArrayList<Player> sitting = new ArrayList<>();

    public void onEnable() {
        super.onEnable();
        registerListeners();
        registerCommands();
        System.out.println(this.consoleprefix + this.text);
        System.out.println(this.consoleprefix + this.text);
        System.out.println(this.consoleprefix + this.text);
        plugin = this;
    }

    public void registerListeners() {
        getServer().getPluginManager().registerEvents(new PlayerJoin(this), this);
    }

    public void registerCommands() {
        Objects.requireNonNull(getCommand("ping")).setExecutor(new PingCommand(this));
        Objects.requireNonNull(getCommand("sit")).setExecutor(new SitCommand(this));
    }

    public void onDisable() {
        plugin = null;
    }
}
