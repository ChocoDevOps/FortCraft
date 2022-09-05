package me.lorenzo.fortcraft.persistence.game;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import me.lorenzo.fortcraft.FortCraft;
import me.lorenzo.fortcraft.exception.PersistenceException;
import me.lorenzo.fortcraft.game.Game;
import me.lorenzo.fortcraft.persistence.PersistenceHandler;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementation of {@link PersistenceHandler PersistenceHandler} for handling {@link Game Game} persistence
 */
public class GamePersistenceHandler implements PersistenceHandler<Game> {
    /**
     * Gson object, to handle json in persistence logic
     */
    private final Gson gson;

    /**
     * Base path for saving serialized games
     */
    private final File basePath;

    /**
     * Initialize instance fields
     */
    public GamePersistenceHandler() {
        this.gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        this.basePath = new File(FortCraft.getInstance().getDataFolder(), "games");
    }

    /**
     * Save game in json format
     *
     * @param game Object to save in specified path
     */
    @Override
    public void serialize(Game game) {
        Path gamePath = Paths.get(basePath.getPath(), game.getName() + ".json");
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(gamePath.toFile());
            if (!gamePath.toFile().exists()) {
                gamePath.toFile().getParentFile().mkdirs();
            }

            gson.toJson(game, fileWriter);
            fileWriter.close();
        } catch (IOException e) {
            throw new PersistenceException(e);
        }
    }

    /**
     * Returns {@link Game game} object from specified Json path
     *
     * @param path Path where object is located
     * @return Game from specified path
     */
    @Override
    public Game deserialize(Path path) {
        try {
            return gson.fromJson(new FileReader(path.toFile()), Game.class);
        } catch (FileNotFoundException e) {
            throw new PersistenceException(e);
        }
    }

    /**
     * Get all available games in root games folder
     *
     * @return List of all available games as {@link Game Game} objects
     */
    public List<Game> fetchGames() {
        return Arrays.stream(basePath.listFiles())
                .map(file -> deserialize(file.toPath()))
                .collect(Collectors.toList());
    }
}
