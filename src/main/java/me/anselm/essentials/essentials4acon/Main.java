package me.anselm.essentials.essentials4acon;

import me.anselm.essentials.essentials4acon.commands.*;
import me.anselm.essentials.essentials4acon.listeners.FallDamageListener;
import me.anselm.essentials.essentials4acon.listeners.PlayerChatListener;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandMap;
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

    public static boolean ad = false ;

    private static Main instance;

    public static ArrayList<Player>flying = new ArrayList<>();






    //Enabling
    public void onEnable() {
        instance = this;



        registerCommandMap();
        registerEVNT();
        registerConfig();

        commandMap.register("gm", new GmCommand());
        commandMap.register("fly", new FlyCommand());
        commandMap.register( "flyspeed", new FlySpeedCommand());
        commandMap.register("broadcast", new BroadcastCommand());
        commandMap.register("ad", new AdCommand());
        commandMap.register("msg", new MsgCommand());



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
        this.getServer().getPluginManager().registerEvents(new PlayerChatListener(), this);
    }


    public void registerConfig() {
        getConfig().options().copyDefaults(true);
        saveConfig();
    }
}
