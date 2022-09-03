package me.lorenzo.fortcraft.game;

import me.lorenzo.fortcraft.persistence.PersistenceHandler;
import me.lorenzo.fortcraft.persistence.game.GamePersistenceHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Object used to handle {@link me.lorenzo.fortcraft.FortCraft FortCraft} game instances
 */
public class GameHandler {
    /**
     * Instance of GameManager
     */
    private static GameHandler instance;

    private final PersistenceHandler<Game> persistenceHandler;

    /**
     * List of available games
     */
    private final List<Game> gameList;

    /**
     * Creates or retrieves {@link GameHandler GameHandler} instance
     * @return GameHandler instance
     */
    public static GameHandler getInstance() {
        if(instance == null)
            instance = new GameHandler();
        return instance;
    }

    /**
     * Private constructor for GameHandler, used for Singleton Pattern
     */
    private GameHandler() {
        this.gameList = new ArrayList<>();
        this.persistenceHandler = new GamePersistenceHandler();
    }

    /**
     * Register a {@link Game Game} to gameList
     * @param game Game to be registered
     * @return True if it is successfully registered, false if something went wrong
     */
    public boolean addGame(Game game) {
        if(findGameByName(game.getName()).isPresent()) return false;

        gameList.add(game);
        return true;
    }

    /**
     * Unregister a game
     * @param game Game to be unregistered
     */
    public void removeGame(Game game) {
        gameList.remove(game);
    }

    /**
     * Find a {@link Game Game} by it's name
     * @param name Name of the game to be found
     * @return Game object with the name
     */
    public Optional<Game> findGameByName(String name) {
        return gameList.stream()
                .filter(g -> g.getName().equalsIgnoreCase(name))
                .findFirst();
    }

    /**
     * Retrieves all the registered games
     * @return Full list of registered games
     */
    public List<Game> getGameList() {
        return gameList;
    }

}
