package cn.jackcraft.syncplayersfoodlevel;

import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;

public final class SyncPlayersFoodLevel extends JavaPlugin {
    @Override
    public void onEnable() {
    }
    @Override
    public void onDisable() {
        HandlerList.unregisterAll(this);
    }
}
