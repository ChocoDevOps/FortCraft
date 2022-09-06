package me.lorenzo.fortcraft.game;

import me.lorenzo.fortcraft.persistence.game.GamePersistenceHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Object used to handle {@link me.lorenzo.fortcraft.FortCraft FortCraft} game instances
 */
public class GameHandler {
    /**
     * Instance of GameManager
     */
    private static GameHandler instance;

    /**
     * Handler to save and load games from storage
     */
    private final GamePersistenceHandler persistenceHandler;

    /**
     * List of available games
     */
    private final List<Game> gameList;

    /**
     * Private constructor for GameHandler, used for Singleton Pattern
     */
    private GameHandler() {
        this.gameList = new ArrayList<>();
        this.persistenceHandler = new GamePersistenceHandler();
    }

    /**
     * Creates or retrieves {@link GameHandler GameHandler} instance
     *
     * @return GameHandler instance
     */
    public static GameHandler getInstance() {
        if (instance == null)
            instance = new GameHandler();
        return instance;
    }

    /**
     * Register a {@link Game Game} to gameList
     *
     * @param game Game to be registered
     * @return True if it is successfully registered, false if something went wrong
     */
    public boolean addGame(Game game) {
        if (findGameByName(game.getName()).isPresent()) return false;

        if (findGameByWorldId(game.getWorldId()).isPresent()) return false;
        
        gameList.add(game);
        return true;
    }

    /**
     * Unregister a game
     *
     * @param game Game to be unregistered
     */
    public void removeGame(Game game) {
        gameList.remove(game);
    }

    /**
     * Find a {@link Game Game} by its name
     *
     * @param name Name of the game to be found
     * @return Game object with that name
     */
    public Optional<Game> findGameByName(String name) {
        return gameList.stream()
                .filter(g -> g.getName().equalsIgnoreCase(name))
                .findFirst();
    }

    /**
     * Find a {@link Game Game} by its world
     *
     * @param worldId World id of the game to be found
     * @return Game object with that worldId
     */
    public Optional<Game> findGameByWorldId(UUID worldId) {
        return gameList.stream()
                .filter(g -> g.getWorldId().equals(worldId))
                .findFirst();
    }

    /**
     * Retrieves all the registered games
     *
     * @return Full list of registered games
     */
    public List<Game> getGameList() {
        return gameList;
    }

    /**
     * Retrieves all the saved games from {@link me.lorenzo.fortcraft.persistence.PersistenceHandler PersistenceHandler}
     * and loads them
     */
    public void loadGames() {
        this.gameList.addAll(persistenceHandler.fetchGames());
    }

    /**
     * Saves all the loaded games to files with {@link me.lorenzo.fortcraft.persistence.PersistenceHandler PersistenceHandler}
     */
    public void saveGames() {
        this.gameList.stream().forEach(persistenceHandler::serialize);
    }
}
