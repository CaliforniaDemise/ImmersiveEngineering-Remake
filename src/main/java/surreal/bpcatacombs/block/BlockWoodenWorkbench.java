package surreal.bpcatacombs.block;

import surreal.bpcatacombs.tile.TileWorkbench;
import net.minecraft.block.material.Material;

public class BlockWoodenWorkbench extends BlockWorkbench<TileWorkbench> {

    public BlockWoodenWorkbench() {
        super(Material.WOOD);
    }

    @Override
    protected TileWorkbench createTileEntity() {
        return new TileWorkbench();
    }
}
