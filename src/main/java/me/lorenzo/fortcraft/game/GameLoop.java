package me.lorenzo.fortcraft.game;

/**
 * Object used to manage game loop for {@link me.lorenzo.fortcraft.FortCraft FortCraft} plugin
 */
public class GameLoop implements Runnable {

    /**
     * Game that should be handled in this instance of GameLoop
     */
    private final Game game;

    /**
     * Constructor for game loop
     *
     * @param game Game that should be handled in this instance
     */
    public GameLoop(Game game) {
        this.game = game;
    }

    /**
     * Method that contains all the logics
     */
    @Override
    public void run() {

    }
}
