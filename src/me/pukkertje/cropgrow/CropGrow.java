package me.pukkertje.cropgrow;

import org.bukkit.Material;
import org.bukkit.block.Biome;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

/**
 * Created by puk on 19-3-2015.
 */
public class CropGrow extends JavaPlugin {

    FileConfiguration config;

    public final Logger log = Logger.getLogger("Minecraft");

    @Override
    public void onEnable() {
        new CropGrowListener(this);
        new BlockPlaceListener(this);
        new PlayerInteractListener(this);

        this.saveDefaultConfig();
        this.reloadConfig();

        config = getConfig();
    }

    public boolean canGrow(Block b) {
        if (b.getLocation().getBlockY() <= config.getInt("exclusion")) {
            return true;
        }

        String type = "";
        Biome biome = b.getBiome();

        if (b.getType() == Material.CROPS) type = "wheat";
        else if (b.getType() == Material.CARROT) type = "carrot";
        else if (b.getType() == Material.POTATO) type = "potato";
        else return true;

        boolean grow = true;

        for (String s : config.getStringList(type)) {
            if (biome.equals(Biome.valueOf(s))) {
                grow = false;
                break;
            }
        }
        return config.getBoolean("allowed") ? !grow : grow ;
    }

}
