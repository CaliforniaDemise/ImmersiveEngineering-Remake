package surreal.bpcatacombs.block;

import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

/**
 * Workbench Implementation
 * Slave block doesn't have a tile entity, it sends activations to main block (to open gui or do whatever)
 **/
@SuppressWarnings("deprecation")
public abstract class BlockWorkbench<T extends TileEntity> extends BlockHorizontal implements ITileEntityProvider {

    // Easier with int property
    protected static final PropertyInteger MULTIBLOCK_SLAVE = PropertyInteger.create("slave", 0, 1);

    public BlockWorkbench(Material material, MapColor color) {
        super(material, color);
        setDefaultState(getDefaultState().withProperty(FACING, EnumFacing.NORTH).withProperty(MULTIBLOCK_SLAVE, 0));
        useNeighborBrightness = true;
        lightOpacity = 1;
    }

    public BlockWorkbench(Material material) {
        this(material, material.getMaterialMapColor());
    }
    
    // Events
    @Override
    @ParametersAreNonnullByDefault
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        T tile = getTileEntity(worldIn, pos, state);
        return false;
    }

    @Override
    @ParametersAreNonnullByDefault
    public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
        EnumFacing facing = getMainFacing(worldIn, pos, state);
        if (state.getValue(MULTIBLOCK_SLAVE) == 0) facing = facing.getOpposite();
        worldIn.setBlockToAir(pos.offset(facing));
    }

    @Nonnull
    @Override
    public EnumBlockRenderType getRenderType(@Nonnull IBlockState state) {
        return state.getValue(MULTIBLOCK_SLAVE) == 0 ? super.getRenderType(state) : EnumBlockRenderType.INVISIBLE;
    }

    @Override
    @ParametersAreNonnullByDefault
    public boolean doesSideBlockRendering(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing face) {
       return face == EnumFacing.UP;
    }

    @Override
    public boolean isOpaqueCube(@Nonnull IBlockState state) {
       return false;
    }

    @Override
    public boolean isFullCube(@Nonnull IBlockState state) {
       return false;
    }

    // BlockState
    @Override
    @Nonnull
    @ParametersAreNonnullByDefault
    public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer, EnumHand hand) {
        return getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite());
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        int slave = state.getValue(MULTIBLOCK_SLAVE) * 4;
        int facing = state.getValue(FACING).getHorizontalIndex();
        return facing | slave;
    }

    @Nonnull
    @Override
    public IBlockState getStateFromMeta(int meta) {
        int slave = (meta & 4) >> 2;
        EnumFacing facing = EnumFacing.HORIZONTALS[meta & 3];
        return getDefaultState().withProperty(FACING, facing).withProperty(MULTIBLOCK_SLAVE, slave);
    }

    @Nonnull
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, FACING, MULTIBLOCK_SLAVE);
    }

    // Tile Entity
    @SuppressWarnings("unchecked")
    protected T getTileEntity(IBlockAccess world, BlockPos pos, IBlockState state) {
        BlockPos mainPos = getMainPos(world, pos, state);
        TileEntity te = world.getTileEntity(mainPos);
        assert te != null;
        return (T) te;
    }

    protected abstract T createTileEntity();

    @Nullable
    @Override
    public TileEntity createNewTileEntity(@Nonnull World worldIn, int meta) {
        return meta == 0 ? createTileEntity() : null;
    }

    // Slave Handling
    /**
     * Can be used outside
     **/
    public final IBlockState asSlave(IBlockState state) {
        return state.withProperty(MULTIBLOCK_SLAVE, 1);
    }

    /**
     * Which neighbour block is the main block, based on slave.
     * state can be the main block.
     * using getOpposite() on returning value returns where slave is based on main block.
     **/
    protected EnumFacing getMainFacing(@Nonnull IBlockAccess world, @Nonnull BlockPos pos, @Nonnull IBlockState state) {
        EnumFacing facing = state.getValue(FACING);
        return getMainFacing(facing);
    }

    /**
     * Which facing main block is based on slave.
     * facing is where workbench.json faces (FACING property)
     * Can be used outside
     **/
    public final EnumFacing getMainFacing(EnumFacing facing) {
        switch (facing) {
            case NORTH: return EnumFacing.EAST;
            case SOUTH: return EnumFacing.WEST;
            case EAST: return EnumFacing.SOUTH;
            case WEST: return EnumFacing.NORTH;
            default: throw new IllegalStateException("Workbench can't face up or down!");
        }
    }

    /**
     * Position of the main block.
     **/
    protected BlockPos getMainPos(@Nonnull IBlockAccess world, @Nonnull BlockPos pos, @Nonnull IBlockState state) {
        if (state.getValue(MULTIBLOCK_SLAVE) == 0) return pos;
        EnumFacing facing = getMainFacing(world, pos, state);
        return pos.offset(facing);
    }

    /**
     * Position of the slave block.
     **/
    protected BlockPos getSlavePos(@Nonnull IBlockAccess world, @Nonnull BlockPos pos, @Nonnull IBlockState state) {
        if (state.getValue(MULTIBLOCK_SLAVE) == 1) return pos;
        EnumFacing facing = getMainFacing(world, pos, state).getOpposite();
        return pos.offset(facing);
    }
}
