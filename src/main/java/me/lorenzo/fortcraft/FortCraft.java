package me.lorenzo.fortcraft;

import org.bukkit.plugin.java.JavaPlugin;

/**
 * Main class for FortCraft plugin
 */
public final class FortCraft extends JavaPlugin {

    /**
     * Fortcraft plugin instance
     */
    private static FortCraft instance;

    /**
     * Returns the fortcraft plugin instance
     * @return {@link FortCraft Fortcraft instance}
     */
    public static FortCraft getInstance() {
        return instance;
    }

    /**
     * Method called on plugin enable process
     */
    @Override
    public void onEnable() {
        instance = this;
    }

    /**
     * Method called on plugin disable process
     */
    @Override
    public void onDisable() {
        instance = this;
    }
}
