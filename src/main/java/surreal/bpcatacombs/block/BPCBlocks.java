package surreal.bpcatacombs.block;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import surreal.bpcatacombs.Tags;
import surreal.bpcatacombs.item.BPCItems;
import surreal.bpcatacombs.item.ItemBlockWorkbench;
import surreal.bpcatacombs.tile.TileWorkbench;
import surreal.bpcatacombs.util.SupplierInput;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.registries.IForgeRegistry;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class BPCBlocks {

    private static List<Block> BLOCKS = new ArrayList<>();

    @ObjectHolder("bpcatacombs:workbench.json") public static final Block WOODEN_WORKBENCH = null;

    public static <T extends Block> T register(T block, @Nullable SupplierInput<T, Item> handleItem, String name) {
        block.setRegistryName(Tags.MOD_ID, name).setTranslationKey(Tags.MOD_ID + "." + name);
        block.setCreativeTab(BPCItems.TAB);
        BLOCKS.add(block);
        if (handleItem != null) BPCItems.register(handleItem.accept(block), block.getRegistryName());
        return block;
    }

    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        IForgeRegistry<Block> registry = event.getRegistry();
        BLOCKS.forEach(registry::register);
    }

    public static void preInit(FMLPreInitializationEvent event) {
        register(new BlockWoodenWorkbench(), ItemBlockWorkbench::new, "workbench");
    }

    public static void init(FMLInitializationEvent event) {
        registerTiles();
    }

    public static void postInit(FMLPostInitializationEvent event) {
        BLOCKS = null;
    }

    private static void registerTiles() {
        GameRegistry.registerTileEntity(TileWorkbench.class, new ResourceLocation(Tags.MOD_ID, "workbench"));
    }
}
