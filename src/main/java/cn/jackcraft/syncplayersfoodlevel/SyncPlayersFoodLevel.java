package cn.jackcraft.syncplayersfoodlevel;

import cn.jackcraft.syncplayersfoodlevel.Listeners.FoodLevelListener;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class SyncPlayersFoodLevel extends JavaPlugin {
    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new FoodLevelListener(), this);
    }
    @Override
    public void onDisable() {
        HandlerList.unregisterAll(this);
    }

    public static void syncFoodLevel(Player player, int foodLevel) {
        for (Player p : Bukkit.getOnlinePlayers()) {
            if (!p.equals(player) && p.isValid()) {
                p.setFoodLevel(foodLevel);
            }
        }
    }
}
