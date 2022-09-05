package me.lorenzo.fortcraft.bukkit;

import org.bukkit.Bukkit;
import org.bukkit.Location;

import java.util.UUID;

/**
 * Model (Wrapper) to represent a {@link Location Location} that can be serialized by {@link com.google.gson.Gson Gson} library
 */
public class BukkitLocation {
    /**
     * {@link org.bukkit.World World} identifier associated with this location wrapper
     */
    private UUID worldId;

    private double x;
    private double y;
    private double z;

    private float yaw;
    private float pitch;

    /**
     * Internal constructor used by internals to instantiate BukkitLocation's instances
     *
     * @param worldId the world uuid got from {@link Location Location}
     * @param x       {@link Location Location} x
     * @param y       {@link Location Location} y
     * @param z       {@link Location Location} z
     * @param yaw     {@link Location Location} yaw
     * @param pitch   {@link Location Location} pitch
     */
    private BukkitLocation(UUID worldId, double x, double y, double z, float yaw, float pitch) {
        this.worldId = worldId;
        this.x = x;
        this.y = y;
        this.z = z;
        this.yaw = yaw;
        this.pitch = pitch;
    }

    /**
     * Method to convert {@link BukkitLocation BukkitLocation} to {@link Location Location}
     *
     * @param bukkitLocation instance of the wrapper used for conversion
     * @return location represented in bukkit-usable format
     */
    public static Location toBukkitLocation(BukkitLocation bukkitLocation) {
        UUID uuid = bukkitLocation.worldId;
        double x = bukkitLocation.x;
        double y = bukkitLocation.y;
        double z = bukkitLocation.z;
        float yaw = bukkitLocation.yaw;
        float pitch = bukkitLocation.pitch;

        return new Location(Bukkit.getWorld(uuid), x, y, z, yaw, pitch);
    }

    /**
     * Method to convert {@link Location Location} to {@link BukkitLocation BukkitLocation}
     *
     * @param location instance of location used for conversion
     * @return location represented in bukkit-usable format
     */
    public static BukkitLocation fromLocation(Location location) {
        UUID uuid = location.getWorld().getUID();
        double x = location.getX();
        double y = location.getY();
        double z = location.getZ();
        float yaw = location.getYaw();
        float pitch = location.getPitch();

        return new BukkitLocation(uuid, x, y, z, yaw, pitch);
    }
}
