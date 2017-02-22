package me.anselm.essentials.essentials4acon.commands;

import me.anselm.essentials.essentials4acon.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

/**
 * Created by Anselm on 21.02.2017.
 */
public class MsgCommand extends Command{

    public MsgCommand() {
        super(
                "msg",
                "Allows you to message a player!",
                "/msg <player> <message>",
                new ArrayList<String >()
        );
    }

    public boolean execute(CommandSender sender, String label, String[] args) {

        if(args.length >= 1) {
            if(sender instanceof Player) {
                Player player = (Player)sender;

                Player target = Bukkit.getPlayer(args[0]);

                StringBuilder builder = new StringBuilder();

                for (int i = 1; i < args.length; i++) {
                    builder.append(args[i] + " ");

                }

                String message = builder.toString().trim().replace("&", "§");

                target.sendMessage("§c" + player.getName() + "§f -> §a" + target.getName() + ": §f" + message);


            }
        }


        return false;
    }

}
