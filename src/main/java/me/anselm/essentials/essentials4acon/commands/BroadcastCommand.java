package me.anselm.essentials.essentials4acon.commands;

import me.anselm.essentials.essentials4acon.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

/**
 * Created by Anselm on 20.02.2017.
 */
public class BroadcastCommand extends Command{


    //Constructor
    public BroadcastCommand() {
        super(
                "broadcast",
                "Lets you broadcast a message to all players!",
                "/broadcast <messag>",

                new ArrayList<String>()

        );
        setPermission("essentials.broadcast");
    }

    @Override
    public boolean execute(CommandSender sender, String label, String[] args) {

        //Checking if the sender has permission
        if(sender.hasPermission(getPermission())) {

            //Checking if the args equal 1
            if(args.length > 0) {
                StringBuilder builder = new StringBuilder();

                Player player = (Player)sender;


                for(int i = 0; i < args.length; i++) {
                    builder.append(args[i] + " ");

                }

                String message = builder.toString().trim().replace("&", "§");


                Bukkit.broadcastMessage(message);
                sender.sendMessage(Main.prefix + "Your message was broadcasted succesfully!");

            }
        }



        return false;
    }
}
