package de.blockbreaker.paintball.data;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

/**
 * Created by Janne on 01.06.2015.
 */
public class Config {

    public static File file;
    public static FileConfiguration cfg;

    static {
        file = new File("plugins/Paintball", "config.yml");
        cfg = YamlConfiguration.loadConfiguration(file);
    }


    public static void createConfig() {

        if(!file.exists()) {

            cfg.set("map", "-");

            try {
                cfg.save(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
