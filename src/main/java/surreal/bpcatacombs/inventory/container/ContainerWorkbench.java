package surreal.bpcatacombs.inventory.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

import javax.annotation.Nonnull;

public class ContainerWorkbench extends Container {

    public ContainerWorkbench(EntityPlayer player, IInventory playerInventory, IItemHandler workbench) {
        // Blueprint slot 23, 23
        // Input slots 73, 22

        this.addSlotToContainer(new SlotItemHandler(workbench, 0, 23, 23));

        for (int x = 0; x < 2; x++) {
            for (int y = 0; y < 3; y++) {
                this.addSlotToContainer(new SlotItemHandler(workbench, x + y * 2 + 1, 73 + (18 * x), 22 + (18 * y)));
            }
        }

        for (int l = 0; l < 3; ++l) {
            for (int j1 = 0; j1 < 9; ++j1) {
                this.addSlotToContainer(new Slot(playerInventory, j1 + l * 9 + 7, 86 + j1 * 18, 103 + l * 18));
            }
        }

        for (int i1 = 0; i1 < 9; ++i1) {
            this.addSlotToContainer(new Slot(playerInventory, i1, 8 + i1 * 18, 161));
        }
    }

    @Override
    public boolean canInteractWith(@Nonnull EntityPlayer playerIn) {
        return true;
    }
}
