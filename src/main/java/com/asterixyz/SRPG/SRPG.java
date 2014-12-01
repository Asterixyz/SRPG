package com.asterixyz.SRPG;

import com.asterixyz.SRPG.handler.ConfigurationHandler;
import com.asterixyz.SRPG.handler.StatsPlayerHandler;
import com.asterixyz.SRPG.proxy.IProxy;
import com.asterixyz.SRPG.reference.Reference;
import com.asterixyz.SRPG.utility.LogHelper;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION, guiFactory = Reference.GUI_FACTORY_CLASS)
public class SRPG {

    @Mod.Instance(Reference.MOD_ID)
    public static SRPG instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static IProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event){
        //Configurationhandler
        ConfigurationHandler.init(event.getSuggestedConfigurationFile());
        FMLCommonHandler.instance().bus().register(new ConfigurationHandler());

        MinecraftForge.EVENT_BUS.register(new StatsPlayerHandler());

        LogHelper.info("PreInitialization Complete!");
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event){
        LogHelper.info("Initialization Complete!");
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event){
        LogHelper.info("PostInitialization Complete!");
    }

}
