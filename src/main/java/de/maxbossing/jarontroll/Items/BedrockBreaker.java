package de.maxbossing.jarontroll.Items;

import de.maxbossing.jarontroll.JaronTroll;
import de.maxbossing.jarontroll.UTils.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;

import java.security.Key;

public class BedrockBreaker {

    private static final NamespacedKey KEY = new NamespacedKey(JaronTroll.getInstance(), "bedrock_breaker");

    private static final ItemStack ITEMSTACK = new ItemBuilder(Material.WOODEN_PICKAXE).setDisplayname("§5Bedrock Breaker").setLore("Destroys even the hardest Blocks. One-Time Use").addCustomModelData(1).build();

    public static ItemStack getItemstack() {
        return ITEMSTACK;
    }

    public static NamespacedKey getKey() {return KEY; }
}
