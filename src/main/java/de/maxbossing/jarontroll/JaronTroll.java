package de.maxbossing.jarontroll;

import de.maxbossing.jarontroll.Commands.TabCompletition.TrollCommandCompletition;
import de.maxbossing.jarontroll.Commands.TabCompletition.jCommandCompletition;
import de.maxbossing.jarontroll.Commands.TrollCommand;
import de.maxbossing.jarontroll.Commands.jCommand;
import de.maxbossing.jarontroll.Constants.TextPrefix;
import de.maxbossing.jarontroll.Events.ChatEvent;
import de.maxbossing.jarontroll.Events.MoveEvent;
import de.maxbossing.jarontroll.Events.PlaceBreakEvent;
import de.maxbossing.jarontroll.Events.PlayerInteractEvent;
import de.maxbossing.jarontroll.UTils.UTils;
import org.bukkit.Instrument;
import org.bukkit.plugin.java.JavaPlugin;

import java.lang.reflect.Modifier;

public final class JaronTroll extends JavaPlugin {

    private static JaronTroll instance;
    private static UTils utils;

    private static final String CONSOLE = TextPrefix.MAIN();

    @Override
    public void onEnable() {
        instance = this;
        utils = new UTils();
        boot();

    }

    void boot() {
        loadCommands();
        utils.log(CONSOLE + "Commands loaded");

        loadEvents();
        utils.log(CONSOLE + "Events Loaded");

        utils.log(" ▄▄▄██▀▀▄▄▄      ██▀███  ▒█████  ███▄    █▄▄▄█████▓██▀███  ▒█████  ██▓    ██▓    \n" +
                       "   ▒██ ▒████▄   ▓██ ▒ ██▒██▒  ██▒██ ▀█   █▓  ██▒ ▓▓██ ▒ ██▒██▒  ██▓██▒   ▓██▒    \n" +
                       "   ░██ ▒██  ▀█▄ ▓██ ░▄█ ▒██░  ██▓██  ▀█ ██▒ ▓██░ ▒▓██ ░▄█ ▒██░  ██▒██░   ▒██░    \n" +
                       "▓██▄██▓░██▄▄▄▄██▒██▀▀█▄ ▒██   ██▓██▒  ▐▌██░ ▓██▓ ░▒██▀▀█▄ ▒██   ██▒██░   ▒██░    \n" +
                       " ▓███▒  ▓█   ▓██░██▓ ▒██░ ████▓▒▒██░   ▓██░ ▒██▒ ░░██▓ ▒██░ ████▓▒░██████░██████▒\n" +
                       " ▒▓▒▒░  ▒▒   ▓▒█░ ▒▓ ░▒▓░ ▒░▒░▒░░ ▒░   ▒ ▒  ▒ ░░  ░ ▒▓ ░▒▓░ ▒░▒░▒░░ ▒░▓  ░ ▒░▓  ░\n" +
                       " ▒ ░▒░   ▒   ▒▒ ░ ░▒ ░ ▒░ ░ ▒ ▒░░ ░░   ░ ▒░   ░     ░▒ ░ ▒░ ░ ▒ ▒░░ ░ ▒  ░ ░ ▒  ░\n" +
                       " ░ ░ ░   ░   ▒    ░░   ░░ ░ ░ ▒    ░   ░ ░  ░       ░░   ░░ ░ ░ ▒   ░ ░    ░ ░   \n" +
                       " ░   ░       ░  ░  ░        ░ ░          ░           ░        ░ ░     ░  ░   ░  ░\n" +
                       "                                                                    Version 0.1  \n" +
                       "                                                                        by Max     ");
    }

    void loadCommands() {
        utils.command("troll", new TrollCommand());
        getCommand("troll").setTabCompleter(new TrollCommandCompletition());

        utils.command("j", new jCommand());
        getCommand("j").setTabCompleter(new jCommandCompletition());
    }

    void loadEvents() {
        utils.event(new MoveEvent());
        utils.event(new PlaceBreakEvent());
        utils.event(new ChatEvent());
        utils.event(new PlayerInteractEvent());
    }

    public static UTils getutils() {
        return utils;
    }

    public static JaronTroll getInstance() {
        return instance;
    }


}
