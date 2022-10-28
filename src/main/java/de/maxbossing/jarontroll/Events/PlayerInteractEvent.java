package de.maxbossing.jarontroll.Events;

import de.maxbossing.jarontroll.Items.BedrockBreaker;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class PlayerInteractEvent implements Listener {

    @EventHandler
    public void onUse(org.bukkit.event.player.PlayerInteractEvent event) {
        if (event.getItem() == null) return;
        if (!event.getAction().isRightClick())return;
        if (!event.getItem().getItemMeta().getPersistentDataContainer().has(BedrockBreaker.getKey())) return;
        if (event.getClickedBlock() == null) {
            event.getPlayer().sendMessage("Yuo realy wanna waste that on this Block?");
            return; }
        if (event.getClickedBlock().getType() == Material.BEDROCK) {
            event.getPlayer().getInventory().getItemInMainHand().setType(Material.AIR);
            event.getClickedBlock().setType(Material.AIR);
            event.getPlayer().sendMessage("You did it");
        }
    }
}
