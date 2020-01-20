package com.demmodders.droppeditembunch;

import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

@EventBusSubscriber(modid = DroppedItemBunch.MODID)
public class EventsDropped {
    public static final Logger LOGGER = LogManager.getLogger(DroppedItemBunch.MODID);

    @SubscribeEvent
    public static void checkCrowding(EntityJoinWorldEvent e){
        if(e.getEntity() instanceof EntityItem) {
            double x = (double)e.getEntity().posX;
            double y = (double)e.getEntity().posY;
            double z = (double)e.getEntity().posZ;
            AxisAlignedBB scan = new AxisAlignedBB(x-ConfigDropped.radius, y-ConfigDropped.radius, z-ConfigDropped.radius, x+ConfigDropped.radius, y+ConfigDropped.radius, z+ConfigDropped.radius);
            List<Entity> entities = e.getEntity().getEntityWorld().getEntitiesWithinAABB(e.getEntity().getClass(), scan);

            if (!entities.isEmpty() && !entities.get(0).isDead) {
                try {
                    int count = ((EntityItem) e.getEntity()).getItem().getCount();
                    for(Entity item:entities){
                        if (((EntityItem)item).getItem().getItem() == ((EntityItem) e.getEntity()).getItem().getItem()) {
                            count += ((EntityItem) item).getItem().getCount();
                            item.setDead();
                            e.getWorld().removeEntity(item);
                        }
                    }
                    if (count > 1) {
                        ((EntityItem) e.getEntity()).setItem(new ItemStack(((EntityItem) e.getEntity()).getItem().getItem(), count));
                        LOGGER.debug(DroppedItemBunch.NAME + " Bunched together " + count + " Items from " + String.valueOf(entities.size() + 1) + " EntityItems");
                    }
                } catch (NullPointerException | IndexOutOfBoundsException error){
                error.printStackTrace();
                }
            }
        }
    }
}
