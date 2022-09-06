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

package me.lorenzo.fortcraft;

import me.lorenzo.fortcraft.bukkit.BukkitLocation;
import me.lorenzo.fortcraft.game.Game;
import me.lorenzo.fortcraft.game.GameHandler;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Main class for FortCraft plugin
 */
public final class FortCraft extends JavaPlugin {

    /**
     * FortCraft plugin instance
     */
    private static FortCraft instance;

    /**
     * GameHandler instance for load/save purposes
     */
    private GameHandler gameHandler;

    /**
     * Returns the fortcraft plugin instance
     *
     * @return {@link FortCraft Fortcraft instance}
     */
    public static FortCraft getInstance() {
        return instance;
    }

    /**
     * Method called on plugin enable process
     */
    @Override
    public void onEnable() {
        instance = this;

        initGame();

        Bukkit.getScheduler().runTaskLater(this, new Runnable() {
            @Override
            public void run() {
                Game game = new Game("TestGame", 1, 100, Bukkit.getWorld("world").getUID());
                game.setSpawn(BukkitLocation.fromLocation(
                        new Location(Bukkit.getWorld("world"), 1, 1, 1)
                ));
                gameHandler.addGame(game);
            }
        }, 40);
    }

    /**
     * Method called on plugin disable process
     */
    @Override
    public void onDisable() {
        gameHandler.saveGames();
    }

    /**
     * Initialize {@link GameHandler GameHandler} instance and load saved games
     */
    private void initGame() {
        this.gameHandler = GameHandler.getInstance();

        gameHandler.loadGames();
    }
}
