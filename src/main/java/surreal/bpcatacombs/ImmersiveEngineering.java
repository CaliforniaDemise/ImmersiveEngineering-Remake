package surreal.bpcatacombs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.relauncher.FMLLaunchHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.jetbrains.annotations.NotNull;
import surreal.bpcatacombs.client.ClientHandler;
import surreal.bpcatacombs.internal.registration.RegistryManager;
import surreal.bpcatacombs.inventory.IEGuiHandler;
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
import surreal.bpcatacombs.item.BPCItems;

@Mod(modid = Tags.MOD_ID, name = "Immersive Engineering", version = Tags.MOD_VERSION)
@SuppressWarnings("unused")
public class ImmersiveEngineering {

    public static final CreativeTabs MAIN = new CreativeTabs(Tags.MOD_ID) {
        @NotNull
        @Override
        public ItemStack createIcon() {
            return new ItemStack(BPCItems.WIRECOIL_COPPER);
        }
    };

    @Mod.EventHandler
    public void construction(FMLConstructionEvent event) {
        MinecraftForge.EVENT_BUS.register(this);
        if (FMLLaunchHandler.side().isClient()) ClientHandler.construction(event);
    }

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        RegistryManager.preInit(event);
        NetworkRegistry.INSTANCE.registerGuiHandler(this, new IEGuiHandler());
        if (FMLLaunchHandler.side().isClient()) ClientHandler.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        RegistryManager.init(event);
        if (FMLLaunchHandler.side().isClient()) ClientHandler.init(event);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        RegistryManager.postInit(event);
        System.gc();
    }

    @SubscribeEvent public void registerBlocks(RegistryEvent.Register<Block> event) { RegistryManager.registerBlocks(event); }
    @SubscribeEvent public void registerItems(RegistryEvent.Register<Item> event) { RegistryManager.registerItems(event); }

    @SideOnly(Side.CLIENT) @SubscribeEvent public void registerModels(ModelRegistryEvent event) { RegistryManager.registerModels(event); }

    static {
        FluidRegistry.enableUniversalBucket();
    }
}