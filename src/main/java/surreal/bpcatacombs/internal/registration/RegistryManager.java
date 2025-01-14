package surreal.bpcatacombs.internal.registration;

import com.google.common.collect.ImmutableList;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import surreal.bpcatacombs.block.BPCBlocks;
import surreal.bpcatacombs.item.BPCItems;

import java.util.List;
import java.util.Objects;

public class RegistryManager {


    private static List<Registry<?>> REGISTRIES;

    static { /// loads at preInit
        ImmutableList.Builder<Registry<?>> builder = new ImmutableList.Builder<>();
        BPCItems items = new BPCItems();
        builder.add(new BPCBlocks(items));
        builder.add(items);
        REGISTRIES = builder.build();
    }

    /**
     * Runs at preInit of the mod.
     * Runs first.
     **/
    public static void preInit(FMLPreInitializationEvent event) {
        REGISTRIES.forEach(r -> r.preInit(event));
    }

    /**
     * Runs at init of the mod.
     **/
    public static void init(FMLInitializationEvent event) {
        REGISTRIES.forEach(r -> r.init(event));
    }

    /**
     * Runs at postInit of the mod.
     * Runs last. Here for cleaning up stuff.
     **/
    public static void postInit(FMLPostInitializationEvent event) {
        REGISTRIES.forEach(r -> r.postInit(event));
        REGISTRIES = null;
    }

    public static void registerBlocks(RegistryEvent.Register<Block> event) {  ((BPCBlocks) REGISTRIES.get(0)).registerEntries(event); }
    public static void registerItems(RegistryEvent.Register<Item> event) { ((BPCItems) REGISTRIES.get(1)).registerEntries(event); }

    @SideOnly(Side.CLIENT)
    public static void registerModels(ModelRegistryEvent event) {
        BPCItems modItems = (BPCItems) REGISTRIES.get(1);
        modItems.list.forEach(item -> ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(Objects.requireNonNull(item.getRegistryName()), "inventory")));
    }
}
