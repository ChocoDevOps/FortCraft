package me.lorenzo.fortcraft.persistence.game;

import me.lorenzo.fortcraft.game.Game;
import me.lorenzo.fortcraft.persistence.PersistenceHandler;

import java.nio.file.Path;

public class GamePersistenceHandler implements PersistenceHandler<Game> {

    @Override
    public void serialize(Game game, Path path) {

    }

    @Override
    public Game deserialize(Path path) {
        return null;
    }
}
