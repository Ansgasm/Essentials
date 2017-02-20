package me.anselm.essentials.essentials4acon.commands;

import me.anselm.essentials.essentials4acon.Main;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;


/**
 * Created by Anselm on 19.02.2017.
 */
public class GmCommand extends Command{

    public GmCommand() {
        super(
                "gm",
                "Changes the gamemode of a player",
                "/gm <gamemode> <player>",
                new ArrayList<String>()

        );
        setPermission("essentials.gm");
    }


    public boolean execute(CommandSender sender, String label, String[] args) {
        //Checking if sender is a player
        if(sender instanceof Player) {
            Player player = (Player) sender;

            if (player.hasPermission(getPermission())) {

                //Checking if the args equal 1 "/gm blabla"
                if (args.length == 1) {

                    //Checking if the second arg equals 0 "/gm 0"
                    if ((args[0].equals("0")) || (args[0].equalsIgnoreCase("survival"))) {

                        //Checking if the sender is in SurvivalMode
                        if (player.getGameMode().equals(GameMode.SURVIVAL)) {

                            //If the sender is in Survivalmode
                            player.sendMessage(Main.prefix + "You are in §4Survivalmode §falready!");
                        } else {

                            player.setGameMode(GameMode.SURVIVAL);
                            player.sendMessage(Main.prefix + "Gamemode changed: §4Survival§f!");
                        }
                    }

                    //Checking if the second arg equals 1 "/gm 1"
                    if ((args[0].equals("1")) || (args[0].equalsIgnoreCase("creative"))) {


                        //Checking if the sender is in CreativeMode
                        if (player.getGameMode().equals(GameMode.CREATIVE)) {

                            //If the sender is in Creativemode
                            player.sendMessage(Main.prefix + "You are in §4Creativemode §falready!");
                        } else {

                            player.setGameMode(GameMode.CREATIVE);
                            player.sendMessage(Main.prefix + "Gamemode changed: §4Creative§f!");
                        }

                    }


                    //Checking if the second arg equals 2 "/gm 2"
                    if ((args[0].equals("2")) || (args[0].equalsIgnoreCase("adventure"))) {


                        //Checking if the sender is in AdventureMode
                        if (player.getGameMode().equals(GameMode.ADVENTURE)) {

                            //If the sender is in Adventureemode
                            player.sendMessage(Main.prefix + "You are in §4Adventuremode §falready!");
                        } else {

                            player.setGameMode(GameMode.ADVENTURE);
                            player.sendMessage(Main.prefix + "Gamemode changed: §4Adventure§f!");
                        }
                    }


                    //Checking if the second arg equals 3 "/gm 3"
                    if ((args[0].equals("3")) || (args[0].equalsIgnoreCase("spectator"))) {

                        //Checking if the sender is in SpectatorMode
                        if (player.getGameMode().equals(GameMode.SPECTATOR)) {

                            //If the sender is in SpectatorMode
                            player.sendMessage(Main.prefix + "You are in Spectatormode §falready!");
                        } else {

                            player.setGameMode(GameMode.SPECTATOR);
                            player.sendMessage(Main.prefix + "Gamemode changed: §4Spectator§f!");
                        }


                    }


                }

                //Checking if the command has a second argument "/gm blabla blabla"
                if(args.length == 2) {
                    Player target = Bukkit.getPlayer(args[1]);

                    //Checking if the target exists
                    if(target != null) {

                        //Checking if the second arg equals 0 "/gm 0"
                        if((args[0].equals("0")) || (args[0].equalsIgnoreCase("survival"))) {

                            //Checking if the sender is in Survival
                            if(target.getGameMode().equals(GameMode.SURVIVAL)) {

                                //If the sender is in SurvivalMode
                                player.sendMessage(Main.prefix + "§4" + target.getName() + " §fis in §4Survivalmode §falready!");
                            }else {

                                target.setGameMode(GameMode.SURVIVAL);
                                player.sendMessage(Main.prefix + "§4" + target.getName() + "s §fgamemode was changed: §4Survival§f!");
                                target.sendMessage(Main.prefix + "Gamemode changed by §4" + player.getName() + "§f: §4Survival§f!");
                            }
                        }

                        //Checking if the second arg equals 1 "/gm 1"
                        if((args[0].equals("1")) || (args[0].equalsIgnoreCase("creative"))) {


                            //Checking if the sender is in CreativeMode
                            if(target.getGameMode().equals(GameMode.CREATIVE)) {

                                //If the sender is in CreativeMode
                                player.sendMessage(Main.prefix + "§4" + target.getName() + " §fis in §4Creativemode §falready!");
                            }else {


                                target.setGameMode(GameMode.CREATIVE);
                                player.sendMessage(Main.prefix + "§4" + target.getName() + "s §fgamemode was changed: §4Creative§f!");
                                target.sendMessage(Main.prefix + "Gamemode changed by §4" + player.getName() + "§f: §4Creative§f!");
                            }
                        }


                        //Checking if the second arg equals 2 "/gm 2"
                        if((args[0].equals("2")) || (args[0].equalsIgnoreCase("adventure"))) {


                            //Checking if the sender is in AdventureMode
                            if(target.getGameMode().equals(GameMode.ADVENTURE)) {

                                //If the sender is in AdventureMode
                                player.sendMessage(Main.prefix + "§4" + target.getName() + " §fis in §4Adventuremode §falready!");
                            }else {


                                target.setGameMode(GameMode.ADVENTURE);
                                player.sendMessage(Main.prefix + "§4" + target.getName() + "s §fgamemode was changed: §4Adventure§f!");
                                target.sendMessage(Main.prefix + "Gamemode changed by §4" + player.getName() + "§f: §4Adventure§f!");
                            }
                        }


                        //Checking if the second arg equals 3 "/gm 3"
                        if((args[0].equals("3")) || (args[0].equalsIgnoreCase("spectator"))) {


                            //Checking if the sender is in SpectatorMode
                            if(target.getGameMode().equals(GameMode.SPECTATOR)) {

                                //If the sender is in SpectatorMode
                                player.sendMessage(Main.prefix + "§4" + target.getName() + " §fis in §4Spectatormode §falready!");
                            }else {


                                target.setGameMode(GameMode.SPECTATOR);
                                player.sendMessage(Main.prefix + "§4" + target.getName() + "s §fgamemode was changed: §4Spectator§f!");
                                target.sendMessage(Main.prefix + "Gamemode changed by §4" + player.getName() + "§f: §4Spectator§f!");
                            }
                        }


                    }else{

                        sender.sendMessage(Main.prefix + "§4" + args[1] + "§f ist nicht online!");
                    }
                }


                //Returning the usage if the args are unequal to 1 or 2
                if((args.length != 1) || (args.length != 2)) {
                    return false;
                }
                return true;
            }

        }

        return false;
    }
}
