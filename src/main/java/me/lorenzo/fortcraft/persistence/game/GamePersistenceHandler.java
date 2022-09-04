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
     * @param game Object to save in specified path
     */
    @Override
    public void serialize(Game game) throws IOException {
        Path gamePath = Paths.get(basePath.getPath(), game.getName() + ".json");
        FileWriter fileWriter = new FileWriter(gamePath.toFile());

        if(!gamePath.toFile().exists()) {
            gamePath.toFile().getParentFile().mkdirs();
        }

        gson.toJson(game, fileWriter);
        fileWriter.close();
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
