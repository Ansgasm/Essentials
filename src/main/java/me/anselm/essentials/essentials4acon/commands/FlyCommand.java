package me.anselm.essentials.essentials4acon.commands;

import me.anselm.essentials.essentials4acon.Main;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Anselm on 20.02.2017.
 */
public class FlyCommand extends Command{

    //Constructor
    public FlyCommand() {
        super(
                "fly",
                "Allows you to fly!",
                "/fly",
                new ArrayList<String>()

        );
        setPermission("essentials.fly");
    }


    public boolean execute(CommandSender sender, String label, String[] args) {

        //Checking if the sender is a player
        if(sender instanceof Player) {
            Player player = (Player)sender;

            //Checking if the sender has permission
            if(sender.hasPermission(getPermission())) {

                //Checking if the args equal 0 "/fly"
                if(args.length == 0) {


                    if((player.getGameMode().equals(GameMode.SURVIVAL)) || (player.getGameMode().equals(GameMode.ADVENTURE))) {

                    //Checking if the sender is already allowed to fly
                    if(player.getAllowFlight()) {

                        player.setAllowFlight(false);
                        player.setFlying(false);
                        player.sendMessage(Main.prefix + "Flying is §4disabled§f!");
                        Main.flying.remove(player);
                    }else {

                        player.setAllowFlight(true);
                        player.setFlying(true);
                        player.sendMessage(Main.prefix + "Flying is §4enabled§f!");
                        Main.flying.add(player);
                    }
                    }else{
                        player.sendMessage(Main.prefix + "Please change your gamemode in §4Survival §for §4Adventure§f!");
                    }
                }else{

                        return false;

                }
            }
            return true;
        }


        return false;
    }
}
