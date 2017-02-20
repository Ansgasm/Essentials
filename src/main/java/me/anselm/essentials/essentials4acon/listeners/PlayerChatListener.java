package me.anselm.essentials.essentials4acon.listeners;

import me.anselm.essentials.essentials4acon.Main;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

/**
 * Created by Anselm on 20.02.2017.
 */
public class PlayerChatListener implements Listener{

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        String config = ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig().getString("Prefix").replace("{player}", player.getName()).replace("{message}", event.getMessage()));




        event.setFormat(config);
    }
}
