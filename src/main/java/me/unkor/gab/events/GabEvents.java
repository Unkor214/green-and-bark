package me.unkor.gab.events;

import io.papermc.paper.event.block.BlockFailedDispenseEvent;
import net.kyori.adventure.key.Key;
import net.kyori.adventure.sound.Sound;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class GabEvents implements Listener {

    @EventHandler
    public void onPlayerClickOnStrippedLog(PlayerInteractEvent event) {
        if (!(event.getAction().isRightClick())) return; //checking its right click
        if (event.getPlayer().getInventory().getItemInMainHand().getType() != Material.BONE_MEAL) return; // checking a bone meal in main hand

        Player player = event.getPlayer(); // get player )

        Block block = event.getClickedBlock(); //creating var "block", and getting a clicked block, and pass to variable this block
        if (block == null) return;

        Material blockMaterial = block.getType(); //getting a block material
        //checking type a block
        if (!(Tag.LOGS.isTagged(blockMaterial) && blockMaterial.name().contains("STRIPPED"))) return; // <- sad return (

        String blockname = blockMaterial.name(); // replacing a "STRIPPED_" (in start the string) in "STRIPPED_*_LOGS"

        Material barkedLog = Material.valueOf(blockname.replaceAll("^STRIPPED_", "")); // get a barked log type and pass all to variable
        block.setType(barkedLog); // setting log )

        if (player.getGameMode() != GameMode.CREATIVE) {
            player.getInventory().getItemInMainHand().setAmount(player.getInventory().getItemInMainHand().getAmount() -1); // receive an object in hand and subtract it
        }

        Particle.COMPOSTER.builder()
                .location(block.getLocation().toCenterLocation())
                .offset(0.9, 0.5, 0.9)
                .count(20)
                .receivers(32, true)
                .spawn();

        player.playSound(Sound.sound(Key.key("item.bone_meal.use"), Sound.Source.PLAYER, 1f, 1f));
    }
}