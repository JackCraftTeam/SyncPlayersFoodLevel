package cn.jackcraft.syncplayersfoodlevel.Listeners;

import cn.jackcraft.syncplayersfoodlevel.SyncPlayersFoodLevel;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class FoodLevelListener implements Listener {
    @EventHandler(priority = EventPriority.LOW)
    public void onFoodLevelChange(FoodLevelChangeEvent event) {
        if (event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();
            SyncPlayersFoodLevel.syncFoodLevel(player, event.getFoodLevel());
        }
    }
}
