package de.maxbossing.jarontroll.Commands.TabCompletition;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TrollCommandCompletition implements TabCompleter {
    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {

        if (args.length == 2) {

            List<String> args2 = new ArrayList<>();

            Collections.addAll(args2, "freeze", "burn", "tnt", "boost", "cage", "cobweb", "nether", "hole", "mobflud", "placeBlock", "breakBlock" );

            return args2;
        }

        return null;
    }
}
