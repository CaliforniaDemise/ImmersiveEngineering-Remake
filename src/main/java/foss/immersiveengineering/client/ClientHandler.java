package foss.immersiveengineering.client;

import foss.immersiveengineering.Tags;
import foss.immersiveengineering.client.resource.IEModels;
import foss.immersiveengineering.client.resource.IETextures;
import foss.immersiveengineering.item.IEItems;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLConstructionEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.FMLLaunchHandler;
import net.minecraftforge.fml.relauncher.Side;

@SuppressWarnings("unused")
public class ClientHandler {

    public static void construction(FMLConstructionEvent event) {
        if (FMLLaunchHandler.side() == Side.CLIENT) {
            IETextures.initTextures();
            IEModels.initModels();
            MinecraftForge.EVENT_BUS.register(ClientHandler.class);
        }
    }

    public static void preInit(FMLPreInitializationEvent event) {
        if (FMLLaunchHandler.side() == Side.CLIENT) {
            OBJLoader.INSTANCE.addDomain(Tags.MOD_ID);
        }
    }

    public static void init(FMLInitializationEvent event) {
    }

    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
        IEItems.registerModels(event);
    }
}