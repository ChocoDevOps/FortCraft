package me.lorenzo.fortcraft.persistence;

import java.nio.file.Path;

/**
 * Persistence handling base abstraction
 */
public interface PersistenceHandler<T> {

    /**
     * Save object into specified path
     * @param object Object to save in specified path
     * @param path Path used to save specified object
     */
    void serialize(T object, Path path);

    /**
     * Retrieve and deserialize object from specified path
     * @param path Path where object is located
     * @return Object deserialized
     */
    T deserialize(Path path);

}
