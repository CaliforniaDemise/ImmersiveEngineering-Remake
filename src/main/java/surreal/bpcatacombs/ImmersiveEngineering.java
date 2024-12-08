package surreal.bpcatacombs;

import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.relauncher.FMLLaunchHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import surreal.bpcatacombs.block.BPCBlocks;
import surreal.bpcatacombs.client.ClientHandler;
import surreal.bpcatacombs.inventory.IEGuiHandler;
import surreal.bpcatacombs.item.BPCItems;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLConstructionEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

@Mod(modid = Tags.MOD_ID, name = "Immersive Engineering", version = Tags.MOD_VERSION)
@SuppressWarnings("unused")
public class ImmersiveEngineering {

    @Mod.EventHandler
    public void construction(FMLConstructionEvent event) {
        MinecraftForge.EVENT_BUS.register(this);
        if (FMLLaunchHandler.side().isClient()) ClientHandler.construction(event);
    }

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        BPCBlocks.preInit(event);
        BPCItems.preInit(event);
        NetworkRegistry.INSTANCE.registerGuiHandler(this, new IEGuiHandler());
        if (FMLLaunchHandler.side().isClient()) ClientHandler.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        BPCBlocks.init(event);
        BPCItems.init(event);
        if (FMLLaunchHandler.side().isClient()) ClientHandler.init(event);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        this.afterRegistry(event);
    }

    @SubscribeEvent public void registerBlocks(RegistryEvent.Register<Block> event) { BPCBlocks.registerBlocks(event); }
    @SubscribeEvent public void registerItems(RegistryEvent.Register<Item> event) { BPCItems.registerItems(event); }

    @SideOnly(Side.CLIENT) @SubscribeEvent public void registerModels(ModelRegistryEvent event) { ClientHandler.registerModels(event); }

    private void afterRegistry(FMLPostInitializationEvent event) {
        BPCBlocks.postInit(event);
        BPCItems.postInit(event);
        System.gc();
    }
}