package me.anselm.essentials.essentials4acon;

import me.anselm.essentials.essentials4acon.commands.FlyCommand;
import me.anselm.essentials.essentials4acon.commands.FlySpeedCommand;
import me.anselm.essentials.essentials4acon.commands.GmCommand;
import me.anselm.essentials.essentials4acon.listeners.FallDamageListener;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandMap;
import org.bukkit.craftbukkit.v1_8_R3.CraftServer;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.lang.reflect.Field;
import java.util.ArrayList;

/**
 * Created by Anselm on 19.02.2017.
 */
public class Main extends JavaPlugin{


    //Useful stuff
    public static String prefix = ("[§4Essentials§f] ");

    private CommandMap commandMap;

    private static Main instance;

    public static ArrayList<Player>flying = new ArrayList<>();


    //Enabling
    public void onEnable() {
        instance = this;

        registerCommandMap();
        registerEVNT();

        commandMap.register("gm", new GmCommand());
        commandMap.register("fly", new FlyCommand());
        commandMap.register( "flyspeed", new FlySpeedCommand());

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

    public static JavaPlugin getInstance() {
        return instance;
    }



    //Registering Listeners
    public void registerEVNT() {
        this.getServer().getPluginManager().registerEvents( new FallDamageListener(), this);
    }
}
