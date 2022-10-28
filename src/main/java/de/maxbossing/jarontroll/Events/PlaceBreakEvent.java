package de.maxbossing.jarontroll.Events;

import de.maxbossing.jarontroll.Commands.TrollCommand;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class PlaceBreakEvent implements Listener {
    @EventHandler
    public void onBreak(BlockBreakEvent event) {
        if (TrollCommand.getBreakBlock().contains(event.getPlayer())) {
            event.setCancelled(true);
        }
    }
    @EventHandler
    public void onPlace(BlockPlaceEvent event) {
        if (TrollCommand.getPlaceBlock().contains(event.getPlayer())) {
            event.setCancelled(true);
        }
    }
}
