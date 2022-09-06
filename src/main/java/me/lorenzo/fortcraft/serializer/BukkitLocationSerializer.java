/*
 * Copyright (c) 2022 - ChocoDev
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package me.lorenzo.fortcraft.serializer;

import com.google.gson.*;
import me.lorenzo.fortcraft.bukkit.BukkitLocation;

import java.lang.reflect.Type;
import java.util.UUID;

public class BukkitLocationSerializer implements JsonSerializer<BukkitLocation>, JsonDeserializer<BukkitLocation> {

    /**
     * Serializes {@link BukkitLocation BukkitLocation} to JsonObject
     *
     * @param src       the object that needs to be converted to Json.
     * @param typeOfSrc the actual type (fully genericized version) of the source object.
     * @return JsonElement serialized for Gson library
     */
    @Override
    public JsonElement serialize(BukkitLocation src, Type typeOfSrc, JsonSerializationContext context) {
        String worldId = String.valueOf(src.getWorldId());
        double x = src.getX();
        double y = src.getY();
        double z = src.getZ();
        float yaw = src.getYaw();
        float pitch = src.getPitch();

        String stringLocation = worldId + ";" + x + ";" + y + ";" + z + ";" + yaw + ";" + pitch;

        JsonPrimitive jsonPrimitive = new JsonPrimitive(stringLocation);
        return jsonPrimitive;
    }

    /**
     * Deserializes {@link JsonObject JsonObject} to BukkitLocation
     *
     * @param json    The Json data being deserialized
     * @param typeOfT The type of the Object to deserialize to
     * @return BukkitLocation deserialized for Gson library
     */
    @Override
    public BukkitLocation deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonPrimitive jsonPrimitive = json.getAsJsonPrimitive();
        String serializedLocation = jsonPrimitive.getAsString();

        String[] parameters = serializedLocation.split(";");

        UUID world = UUID.fromString(parameters[0]);
        double x = Double.parseDouble(parameters[1]);
        double y = Double.parseDouble(parameters[2]);
        double z = Double.parseDouble(parameters[3]);
        float yaw = Float.parseFloat(parameters[4]);
        float pitch = Float.parseFloat(parameters[5]);

        BukkitLocation bukkitLocation = new BukkitLocation(world, x, y, z, yaw, pitch);
        return bukkitLocation;
    }
}
