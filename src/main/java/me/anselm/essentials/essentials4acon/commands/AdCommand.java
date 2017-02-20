package me.anselm.essentials.essentials4acon.commands;

import me.anselm.essentials.essentials4acon.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;

/**
 * Created by Anselm on 20.02.2017.
 */
public class AdCommand extends Command{

    public AdCommand() {
        super(
                "ad",
                "Makes you broadcast an ad!",
                "/ad <delay in seconds> <Ad>",
                new ArrayList<String>()
        );
        setPermission("essentials.ad");
    }

    public boolean execute(final CommandSender sender, String label, String[] args) {

        //Checking if the sender has permission
        if (sender.hasPermission(getPermission())) {

            //Checking if the argument is higher than 1 "/ad <second> blabla blabla etc.
            if (args.length >= 1) {
                final Player player = (Player) sender;

                sender.sendMessage(Main.prefix + "Dont forget to turn on the broadcast with /ad, current State: §4" + Main.ad);


                try {



                    StringBuilder builder = new StringBuilder();

                    for (int i = 1; i < args.length; i++) {
                        builder.append(args[i] + " ");

                    }

                    final Long delay = Long.parseLong(args[0]) * 10;
                    final String message = builder.toString().trim().replace("&", "§");

                    new BukkitRunnable() {
                        public void run() {
                            if (Main.ad == true) {

                                Bukkit.broadcastMessage(message);
                            }else{
                                sender.sendMessage(Main.prefix + "Your broadcast due to perfomance leaks!");
                                sender.sendMessage(Main.prefix + "Please use /ad and try again!");
                                cancel();
                            }

                        }
                    }.runTaskTimer(Main.getInstance(), 0, delay);


                } catch (NumberFormatException exc) {
                    sender.sendMessage(Main.prefix + "Please use /ad <time value in seconds> <message to broadcast>");
                }

            } else if (args.length == 0) {
                if (Main.ad == false) {
                    sender.sendMessage(Main.prefix + "The broadcast was toggled, current state: §4" + Main.ad);
                    sender.sendMessage(Main.prefix + "You're able to use the /ad <timer> <message> now!");
                    Main.ad = true;

                } else {
                    sender.sendMessage(Main.prefix + "The broadcast was toggled, current state: §4" + Main.ad);
                    sender.sendMessage(Main.prefix + "You wont be able to use the /ad <timer> <message> anymore!");
                    Main.ad = false;
                }
            }


        }
        return false;
    }
}
