package com.asterixyz.SRPG.handler;

import com.asterixyz.SRPG.reference.Reference;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class ConfigurationHandler {

    public static Configuration configuration;
    public static boolean testValue = false;

    public static void init(File configFile){
        //Create the configuration object from the given configurationfile
        if (configuration == null) {
            configuration = new Configuration(configFile);
            loadConfiguration();
        }
    }

    @SubscribeEvent
    public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event){
        if (event.modID.equalsIgnoreCase(Reference.MOD_ID)){
            //Resync the configs
            loadConfiguration();
        }
    }

    private static void loadConfiguration(){
        testValue = configuration.getBoolean("configValue",configuration.CATEGORY_GENERAL, false, "This is an example config value");

        if (configuration.hasChanged()){
            configuration.save();
        }
    }

}
