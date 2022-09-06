package me.lorenzo.fortcraft.game;

import me.lorenzo.fortcraft.bukkit.BukkitLocation;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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
     * Id of the world assigned to this Game instance
     */
    private UUID worldId;

    /**
     * List of locations where players will be spawned at the join
     */
    private List<BukkitLocation> spawnLocations;

    /**
     * List of locations where players will be launched from
     */
    private List<BukkitLocation> launchLocations;

    /**
     * Constructor for Game model used for setup purposes
     *
     * @param name       The name of the game (Map)
     * @param minPlayers Minimum players to start the game
     * @param maxPlayers Maximum players that can join a certain game
     */
    public Game(String name, int minPlayers, int maxPlayers, UUID worldId) {
        this.name = name;
        this.minPlayers = minPlayers;
        this.maxPlayers = maxPlayers;
        this.worldId = worldId;
        this.spawnLocations = new ArrayList<>();
        this.launchLocations = new ArrayList<>();
    }

    /**
     * Get the name of the game
     *
     * @return game name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the game name
     *
     * @param name game name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get maximum allowed players for this game
     *
     * @return maximum allowed players
     */
    public int getMaxPlayers() {
        return maxPlayers;
    }

    /**
     * Set maximum allowed players for this game
     *
     * @param maxPlayers max players allowed
     */
    public void setMaxPlayers(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    /**
     * Get minimum players to start the game
     *
     * @return minimum players to start the game
     */
    public int getMinPlayers() {
        return minPlayers;
    }

    /**
     * Set minimum players to start the game
     *
     * @param minPlayers minimum players to start the game
     */
    public void setMinPlayers(int minPlayers) {
        this.minPlayers = minPlayers;
    }

    /**
     * Returns worldId assigned to this Game instance
     *
     * @return worldId assigned to this Game instance
     */
    public UUID getWorldId() {
        return worldId;
    }

    /**
     * Set the initial spawn for this game
     *
     * @param bukkitLocation spawn for players when they join that game
     */
    public void setSpawn(BukkitLocation bukkitLocation) {
        this.spawnLocations.add(bukkitLocation);
    }

    /**
     * Returns a list of locations from which players can be launched
     *
     * @return list of locations from which players can be launched
     */
    public List<BukkitLocation> getLaunchLocations() {
        return launchLocations;
    }

    /**
     * Add new location to launchLocations list
     *
     * @param bukkitLocation Location to add
     */
    public void addLaunchLocation(BukkitLocation bukkitLocation) {
        this.launchLocations.add(bukkitLocation);
    }

    /**
     * Readable overriding of default toString method
     *
     * @return String representation of the current game object
     */
    @Override
    public String toString() {
        return "Game{" +
                "name='" + name + '\'' +
                ", maxPlayers=" + maxPlayers +
                ", minPlayers=" + minPlayers +
                '}';
    }
}
