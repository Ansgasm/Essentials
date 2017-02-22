package me.anselm.essentials.essentials4acon.commands;

import me.anselm.essentials.essentials4acon.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

/**
 * Created by Anselm on 20.02.2017.
 */
public class FlySpeedCommand extends Command{


    //Constructor
    public FlySpeedCommand() {
        super(
            "flyspeed",
            "Changes your flyspeed",
            "/flyspeed <value>",
            new ArrayList<String>()
        );
        setPermission("essentials.fly");
    }

    public boolean execute(CommandSender sender, String label, String[] args) {

        //Checking if the sender is a player
        if(sender instanceof Player) {
            Player player = (Player)sender;

            //Checking if the sender has permission
            if(player.hasPermission(getPermission())) {

                //Checking if the args equal 1 "/flyspeed blabla"
                if(args.length == 1) {



                    //test


                    //Letting the player reset his flyspeed to vanilla
                    if(args[0].equalsIgnoreCase("reset")) {
                        player.setFlySpeed(0.1F);
                        player.sendMessage(Main.prefix + "Your flyspeed was reset to §41.0 §f!");


                        //Sending an error message if the second arg is higher or smaller then 10
                    }else{
                        try {

                            //All the floats of the flyspeed
                            Float inputflyspeed = Float.parseFloat(args[0]);
                            Float finishedflyspeed = inputflyspeed /10;

                            //Checking if the second arg i higher then 0 and lower then 10
                            if ((inputflyspeed > 10) || (inputflyspeed < 0)) {
                                player.sendMessage(Main.prefix + "Please enter a value thats §4higher §fthen §40 §fand lower then §410 §f!");
                            } else {
                                player.setFlySpeed(finishedflyspeed);
                                player.sendMessage(Main.prefix + "Your flyspeed was changed to §4" + inputflyspeed + "§f!");

                            }
                        }catch (NumberFormatException exc) {
                            player.sendMessage(Main.prefix + "Please enter a §4value§f, not a §4letter§f!");
                        }
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
