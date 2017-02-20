package me.anselm.essentials.essentials4acon.listeners;

import me.anselm.essentials.essentials4acon.Main;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

/**
 * Created by Anselm on 20.02.2017.
 */
public class FallDamageListener implements Listener{

    @EventHandler
    public void onFallDamage(EntityDamageEvent event) {
        //Checking if the Entity thats getting damaged is a player
       if(event.getEntityType() == EntityType.PLAYER) {
           Player player = (Player)event.getEntity();

           //Checking if the damage is falldamage
           if(event.getCause().equals(EntityDamageEvent.DamageCause.FALL)) {

               //Checking if the player used the FlyCommand
               if(Main.flying.contains(player)) {
                   event.setCancelled(true);
               }
           }

       }
    }
}
