package foss.immersiveengineering;

import foss.immersiveengineering.block.IEBlocks;
import foss.immersiveengineering.client.ClientHandler;
import foss.immersiveengineering.inventory.IEGuiHandler;
import foss.immersiveengineering.item.IEItems;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLConstructionEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

@Mod(modid = Tags.MOD_ID, name = "Immersive Engineering", version = Tags.MOD_VERSION)
@SuppressWarnings("unused")
public class ImmersiveEngineering {

    @Mod.EventHandler
    public void construction(FMLConstructionEvent event) {
        MinecraftForge.EVENT_BUS.register(this);
        ClientHandler.construction(event);
    }

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        NetworkRegistry.INSTANCE.registerGuiHandler(this, new IEGuiHandler());
        ClientHandler.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        IEItems.registerOres();
        ClientHandler.init(event);
    }

    @SubscribeEvent
    public void registerBlocks(RegistryEvent.Register<Block> event) {
        IEBlocks.registerBlocks(event);
    }

    @SubscribeEvent
    public void registerItems(RegistryEvent.Register<Item> event) {
        IEItems.registerItems(event);
    }
}