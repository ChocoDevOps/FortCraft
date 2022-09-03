package me.lorenzo.fortcraft.persistence.game;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import me.lorenzo.fortcraft.FortCraft;
import me.lorenzo.fortcraft.game.Game;
import me.lorenzo.fortcraft.persistence.PersistenceHandler;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Implementation of {@link PersistenceHandler PersistenceHandler} for handling Game
 */
public class GamePersistenceHandler implements PersistenceHandler<Game> {
    /**
     * Gson object, to handle json in persistence logic
     */
    private Gson gson;

    /**
     * Base path for saving serialized games
     */
    private File basePath;

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
     * @param game Object to save in specified path
     * @param path Path used to save specified object
     */
    @Override
    public void serialize(Game game, Path path) throws IOException {
        Path gamePath = Paths.get(basePath.getPath(), game.getName() + ".json");

        gson.toJson(game, new FileWriter(gamePath.toFile()));
    }

    /**
     * Returns {@link Game game} object from specified Json path
     * @param path Path where object is located
     * @return Game from specified path
     */
    @Override
    public Game deserialize(Path path) throws FileNotFoundException {
        return gson.fromJson(new FileReader(path.toFile()), Game.class);
    }
}
