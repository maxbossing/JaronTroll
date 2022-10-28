package de.maxbossing.jarontroll.UTils;

import de.maxbossing.jarontroll.JaronTroll;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;

public class UTils {
    public void command (String command, CommandExecutor executor) {JaronTroll.getInstance().getCommand(command).setExecutor(executor); }

    public void event (Listener listener) { Bukkit.getPluginManager().registerEvents(listener, JaronTroll.getInstance());}

    public void log (String msg) { Bukkit.getConsoleSender().sendMessage(msg); }

    public void broadcast (String msg) { Bukkit.broadcastMessage(msg); }

    public void sendTitle (String title, String subtitle, int fadein, int stay, int fadeout) {
        for (Player allPlayer : Bukkit.getOnlinePlayers()) {
            allPlayer.sendTitle(title, subtitle, fadein, stay, fadeout);
        }
    }

    public void broadcastPlayers (String msg) {
        for (Player allPlayers : Bukkit.getOnlinePlayers()) {
            allPlayers.sendMessage(msg);
        }
    }
}
