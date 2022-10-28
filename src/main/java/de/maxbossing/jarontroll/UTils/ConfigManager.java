package de.maxbossing.jarontroll.UTils;

import de.maxbossing.jarontroll.JaronTroll;


public class ConfigManager {
    //gets variables in the Config
    public String getString (String path) {
        return JaronTroll.getInstance().getConfig().getString(path);
    }

    public Integer getInt (String path) {
        return JaronTroll.getInstance().getConfig().getInt(path);
    }

    public Double getDouble (String path) {
        return JaronTroll.getInstance().getConfig().getDouble(path);
    }

    public Boolean getBool (String path) {
        return JaronTroll.getInstance().getConfig().getBoolean(path);
    }

    //sets variables in the Config
    public void setString (String path, String var) {
        JaronTroll.getInstance().getConfig().set(path, var);
        JaronTroll.getInstance().saveConfig();
    }

    public void setInt (String path, Integer var) {
        JaronTroll.getInstance().getConfig().set(path, var);
        JaronTroll.getInstance().saveConfig();
    }

    public void setDouble (String path, Double var) {
        JaronTroll.getInstance().getConfig().set(path, var);
        JaronTroll.getInstance().saveConfig();
    }

    public void setBool (String path, Boolean var) {
        JaronTroll.getInstance().getConfig().set(path, var);
        JaronTroll.getInstance().saveConfig();
    }
}
