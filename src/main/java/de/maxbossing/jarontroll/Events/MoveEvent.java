package de.maxbossing.jarontroll.Events;

import de.maxbossing.jarontroll.Commands.TrollCommand;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.ArrayList;

public class MoveEvent implements Listener {
    @EventHandler
    public void onMove(PlayerMoveEvent moveEvent) {

        Player player = moveEvent.getPlayer();

        ArrayList<Player> moveBlock = TrollCommand.getMoveBlock();

        if (moveBlock.contains(player)) {moveEvent.setCancelled(true);}


    }
}
