package com.github.dwesolowski.quarry;

import com.github.dwesolowski.quarry.commands.OresCommand;
import com.github.dwesolowski.quarry.commands.ResetOresCommand;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.Bukkit;

public class Quarry extends JavaPlugin {

    @Override
    public void onEnable() {
        registerCommands();
    }

    @Override
    public void onDisable() {
        Bukkit.getPluginManager().disablePlugin(this);
    }

    private void registerCommands() {
        getCommand("ores").setExecutor(new OresCommand(this));
        getCommand("resetores").setExecutor(new ResetOresCommand(this));
    }
}
