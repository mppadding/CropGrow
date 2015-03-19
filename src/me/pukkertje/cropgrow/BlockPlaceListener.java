package me.pukkertje.cropgrow;

import org.bukkit.Material;
import org.bukkit.block.Biome;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

/**
 * Created by puk on 19-3-2015.
 */
public class BlockPlaceListener implements Listener {

    CropGrow plugin;

    public BlockPlaceListener(CropGrow plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
        this.plugin = plugin;
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        Player p = event.getPlayer();
        Block b = event.getBlock();

        if(!plugin.canGrow(b))
            p.sendMessage("This biome isn't good for this crop, it probably won't grow.");

    }

}
