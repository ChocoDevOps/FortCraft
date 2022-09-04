package me.lorenzo.fortcraft;

import me.lorenzo.fortcraft.bukkit.BukkitLocation;
import me.lorenzo.fortcraft.game.Game;
import me.lorenzo.fortcraft.persistence.game.GamePersistenceHandler;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;

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
