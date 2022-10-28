package de.maxbossing.jarontroll.Events;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatEvent implements Listener {
    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        if (event.getMessage().equals("heheheha")) {
            event.setCancelled(true);
            event.getPlayer().sendMessage("test2");
            for (Player allPlayers : Bukkit.getOnlinePlayers()) {
                allPlayers.sendMessage("test2");
                allPlayers.playSound(allPlayers.getLocation(), Sound.ENTITY_LIGHTNING_BOLT_THUNDER, 100, 10);
                allPlayers.sendMessage("penis");
            }

        }
    }
}
