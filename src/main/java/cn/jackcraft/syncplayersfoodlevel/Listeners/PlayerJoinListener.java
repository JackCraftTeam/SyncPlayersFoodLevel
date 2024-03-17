package cn.jackcraft.syncplayersfoodlevel.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.HashMap;
import java.util.Map;

public class PlayerJoinListener implements Listener {
    @EventHandler(priority = EventPriority.LOW, ignoreCancelled = true)
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        Map<Integer, Integer> levelCounts = new HashMap<>();
        for (Player p : Bukkit.getOnlinePlayers()) {
            int level = p.getInventory().getHeldItemSlot();
            levelCounts.put(level, levelCounts.getOrDefault(level, 0) + 1);
        }
        int mostLevel = -1;
        int maxLevel = 0;
        for (Map.Entry<Integer, Integer> entry : levelCounts.entrySet()) {
            int level = entry.getKey();
            int count = entry.getValue();
            if (count > maxLevel) {
                mostLevel = level;
                maxLevel = count;
            }
        }
        if (mostLevel != -1) {
            player.setFoodLevel(mostLevel);
        }
    }
}
