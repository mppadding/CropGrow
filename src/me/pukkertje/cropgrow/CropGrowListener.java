package me.pukkertje.cropgrow;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockGrowEvent;

/**
 * Created by puk on 19-3-2015.
 */
public class CropGrowListener implements Listener {

    CropGrow plugin;

    public CropGrowListener(CropGrow plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
        this.plugin = plugin;
    }

    @EventHandler
    public void onBlockGrow(BlockGrowEvent event) {
        if(!plugin.canGrow(event.getBlock())) event.setCancelled(true);
    }

}
