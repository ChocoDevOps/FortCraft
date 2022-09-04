package me.lorenzo.fortcraft.bukkit;

import org.bukkit.Bukkit;
import org.bukkit.Location;

import java.util.UUID;

/**
 * Model to represent a {@link Location Location} that can be serialized by {@link com.google.gson.Gson Gson} library
 */
public class BukkitLocation {
    private UUID worldId;

    private double x;
    private double y;
    private double z;

    private float yaw;
    private float pitch;

    private BukkitLocation(UUID worldId, double x, double y, double z, float yaw, float pitch) {
        this.worldId = worldId;
        this.x = x;
        this.y = y;
        this.z = z;
        this.yaw = yaw;
        this.pitch = pitch;
    }

    public static Location toBukkitLocation(BukkitLocation bukkitLocation) {
        UUID uuid = bukkitLocation.worldId;
        double x = bukkitLocation.x;
        double y = bukkitLocation.y;
        double z = bukkitLocation.z;
        float yaw = bukkitLocation.yaw;
        float pitch = bukkitLocation.pitch;

        return new Location(Bukkit.getWorld(uuid), x, y, z, yaw, pitch);
    }

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
