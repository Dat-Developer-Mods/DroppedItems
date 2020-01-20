package com.demmodders.droppeditembunch;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = DroppedItemBunch.MODID, name = DroppedItemBunch.NAME, version = DroppedItemBunch.VERSION, acceptedMinecraftVersions = "*")
public class DroppedItemBunch {
    public static final String MODID = "demdroppeditems";
    public static final String NAME = "Dropped Items Bunch";
    public static final String VERSION = "0.0.1";
    public static final String MC_VERSION = "[1.12.2]";

    public static final Logger LOGGER = LogManager.getLogger(DroppedItemBunch.MODID);


    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {

    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        LOGGER.info(DroppedItemBunch.NAME + "says hi!");
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {

    }
}

