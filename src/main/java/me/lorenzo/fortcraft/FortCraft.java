package me.lorenzo.fortcraft;

import me.lorenzo.fortcraft.game.GameHandler;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Main class for FortCraft plugin
 */
public final class FortCraft extends JavaPlugin {

    /**
     * FortCraft plugin instance
     */
    private static FortCraft instance;

    /**
     * GameHandler instance for load/save purposes
     */
    private GameHandler gameHandler;

    /**
     * Returns the fortcraft plugin instance
     *
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
        
        this.gameHandler = GameHandler.getInstance();

        gameHandler.loadGames();
    }

    /**
     * Method called on plugin disable process
     */
    @Override
    public void onDisable() {
        gameHandler.saveGames();
    }
}
