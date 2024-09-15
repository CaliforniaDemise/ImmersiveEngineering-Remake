package foss.immersiveengineering.block;

import foss.immersiveengineering.Tags;
import foss.immersiveengineering.item.IEItems;
import foss.immersiveengineering.item.ItemBlockWorkbench;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class IEBlocks {

    private static final List<Block> BLOCKS = new ArrayList<>();
    private static final Consumer<Block> BASIC_ITEM;

    public static final BlockWoodenWorkbench WOODEN_WORKBENCH = register(new BlockWoodenWorkbench(), block -> IEItems.register(new ItemBlockWorkbench(block), block.getRegistryName()), "workbench");

    public static <T extends Block> T register(T block, Consumer<T> handleItem, String name) {
        block.setRegistryName(Tags.MOD_ID, name).setTranslationKey(Tags.MOD_ID + "." + name);
        block.setCreativeTab(IEItems.TAB);
        BLOCKS.add(block);
        handleItem.accept(block);
        return block;
    }

    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        IForgeRegistry<Block> registry = event.getRegistry();
        BLOCKS.forEach(registry::register);
    }

    static {
        BASIC_ITEM = block -> {
            ItemBlock item = new ItemBlock(block);
            IEItems.register(item, block.getRegistryName());
        };
    }
}
