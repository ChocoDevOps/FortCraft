package me.lorenzo.fortcraft.game;

import me.lorenzo.fortcraft.bukkit.BukkitLocation;

import java.util.ArrayList;
import java.util.List;

/**
 * Model for {@link me.lorenzo.fortcraft.FortCraft FortCraft} game instance
 */
public class Game {
    /**
     * Name of the fortcraft game
     */
    private String name;

    /**
     * Maximum allowed players for this game
     */
    private int maxPlayers;

    /**
     * Minimum allowed players for this game
     */
    private int minPlayers;

    /**
     * List of locations where players will be spawned at the join
     */
    private List<BukkitLocation> spawnLocations;

    /**
     * Constructor for Game model used for setup purposes
     * @param name The name of the game (Map)
     * @param minPlayers Minimum players to start the game
     * @param maxPlayers Maximum players that can join a certain game
     */
    public Game(String name, int minPlayers, int maxPlayers) {
        this.name = name;
        this.minPlayers = minPlayers;
        this.maxPlayers = maxPlayers;
        this.spawnLocations = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

    public void setMaxPlayers(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public int getMinPlayers() {
        return minPlayers;
    }

    public void setMinPlayers(int minPlayers) {
        this.minPlayers = minPlayers;
    }

    public void setSpawn(BukkitLocation bukkitLocation) {
        this.spawnLocations.add(bukkitLocation);
    }

    @Override
    public String toString() {
        return "Game{" +
                "name='" + name + '\'' +
                ", maxPlayers=" + maxPlayers +
                ", minPlayers=" + minPlayers +
                '}';
    }
}
