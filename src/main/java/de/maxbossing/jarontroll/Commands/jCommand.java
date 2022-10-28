package de.maxbossing.jarontroll.Commands;

import de.maxbossing.jarontroll.Items.BedrockBreaker;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class jCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (!(sender instanceof Player)) return true;
        Player player = (Player) sender;
        if (args.length == 1) {
            switch (args[0]) {
                case "bedrockBreaker":
                    player.getInventory().addItem(BedrockBreaker.getItemstack());
                    break;

            }
        }



        return false;
    }
}
