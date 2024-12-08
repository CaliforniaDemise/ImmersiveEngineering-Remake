package surreal.bpcatacombs.item;

import surreal.bpcatacombs.block.BlockWorkbench;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

public class ItemBlockWorkbench extends ItemBlock {

    protected final BlockWorkbench<?> workbench;

    public ItemBlockWorkbench(BlockWorkbench<?> block) {
        super(block);
        this.workbench = block;
    }

    @Nonnull
    @Override
    @ParametersAreNonnullByDefault
    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

        IBlockState iblockstate = worldIn.getBlockState(pos);
        Block block = iblockstate.getBlock();

        if (!block.isReplaceable(worldIn, pos)) pos = pos.offset(facing);
        ItemStack itemstack = player.getHeldItem(hand);

        EnumFacing mainFacing = workbench.getMainFacing(player.getHorizontalFacing().getOpposite()); // where main block will be based on slave block
        EnumFacing slaveFacing = mainFacing.getOpposite();

        BlockPos slavePos = pos.offset(slaveFacing);
        IBlockState slaveState = worldIn.getBlockState(slavePos);

        if (!slaveState.getBlock().isReplaceable(worldIn, slavePos)) {
            slavePos = slavePos.offset(mainFacing);
            pos = pos.offset(mainFacing);
        }

        boolean canPlayerEdit = player.canPlayerEdit(pos, facing, itemstack) && player.canPlayerEdit(slavePos, facing, itemstack);
        boolean mayPlace = worldIn.mayPlace(this.block, pos, false, facing, player) && worldIn.mayPlace(this.block, slavePos, false, facing, player);

        if (!itemstack.isEmpty() && canPlayerEdit && mayPlace) {
            int i = this.getMetadata(itemstack.getMetadata());
            IBlockState iblockstate1 = this.block.getStateForPlacement(worldIn, pos, facing, hitX, hitY, hitZ, i, player, hand);
            IBlockState iblockstateSlave = workbench.asSlave(iblockstate1);

            if (placeBlockAt(itemstack, player, worldIn, pos, facing, hitX, hitY, hitZ, iblockstate1) && placeBlockAt(itemstack, player, worldIn, slavePos, facing, hitX, hitY, hitZ, iblockstateSlave)) {
                iblockstate1 = worldIn.getBlockState(pos);
                SoundType soundtype = iblockstate1.getBlock().getSoundType(iblockstate1, worldIn, pos, player);
                worldIn.playSound(player, pos, soundtype.getPlaceSound(), SoundCategory.BLOCKS, (soundtype.getVolume() + 1.0F) / 2.0F, soundtype.getPitch() * 0.8F);
                itemstack.shrink(1);
            }

            return EnumActionResult.SUCCESS;
        }

        return EnumActionResult.FAIL;
    }
}
