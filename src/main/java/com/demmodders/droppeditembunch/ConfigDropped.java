package com.demmodders.droppeditembunch;

import net.minecraftforge.common.config.Config;

@Config(modid = DroppedItemBunch.MODID)
public class ConfigDropped {
    @Config.Name("Check Radius")
    @Config.Comment("How far from the item to check for similar item entities when it is dropped, big values will be troublesome, I haven't checked though\nIts also a square radius")
    @Config.RangeDouble(min = 1f)
    public static double radius = 2f;
}
