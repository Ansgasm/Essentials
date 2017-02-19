package me.anselm.essentials.essentials4acon;

import me.anselm.essentials.essentials4acon.commands.GmCommand;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandMap;
import org.bukkit.craftbukkit.v1_8_R3.CraftServer;
import org.bukkit.plugin.java.JavaPlugin;

import java.lang.reflect.Field;

/**
 * Created by Anselm on 19.02.2017.
 */
public class Main extends JavaPlugin{


    //Useful stuff
    public static String prefix = ("[§4Essentials§f] ");

    private CommandMap commandMap;

    private static Main instance;


    //Enabling
    public void onEnable() {
        instance = this;

        registerCommandMap();
        registerEVNT();

        commandMap.register("gm", new GmCommand());

        this.getLogger().warning(prefix + "Essentials was started succesfully!");
    }




    //Disabling
    public void onDisable() {
        instance = null;
        this.getLogger().warning(prefix + "Essentials was stopped!");
    }



    //Registering CommandMap

    private void registerCommandMap() {
        try {
            Field field = Bukkit.getServer().getClass().getDeclaredField("commandMap");
            field.setAccessible(true);
            commandMap  = (CommandMap) field.get(Bukkit.getServer());
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }



    //Registering Listeners
    public void registerEVNT() {

    }
}
