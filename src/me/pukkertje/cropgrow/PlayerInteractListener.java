package me.pukkertje.cropgrow;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

/**
 * Created by puk on 19-3-2015.
 */
public class PlayerInteractListener implements Listener {

    CropGrow plugin;

    public PlayerInteractListener(CropGrow plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        if(event.getAction() != Action.RIGHT_CLICK_BLOCK || !event.hasItem()) return;

        ItemStack bone_meal = new ItemStack(Material.INK_SACK, 1, (short) 15);

        if(event.getItem().equals(bone_meal) && !plugin.canGrow(event.getClickedBlock())) {
            event.getPlayer().sendMessage("This crop can't grow in this biome, I guess bone meal doesn't work either.");
        }
    }

}
