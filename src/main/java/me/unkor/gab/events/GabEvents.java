package me.unkor.gab.events;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Tag;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.jetbrains.annotations.NotNull;

public class GabEvents implements Listener {
    @EventHandler
    public void onPlayerClickOnLog(PlayerInteractEvent event) {
        if (!(event.getAction().isRightClick())) return;
        if (event.getPlayer().getInventory().getItemInMainHand().getType() != Material.BONE_MEAL) return;

        Block block = event.getClickedBlock();
        if (block == null) return;

        Material blockMaterial = block.getType();
        if (!(Tag.LOGS.isTagged(blockMaterial) && blockMaterial.name().contains("STRIPPED"))) return;


    }
}
