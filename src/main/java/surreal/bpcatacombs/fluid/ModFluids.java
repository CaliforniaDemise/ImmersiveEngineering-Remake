package surreal.bpcatacombs.fluid;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import surreal.bpcatacombs.Tags;

public class ModFluids {

    public static final Fluid CREOSOTE_OIL = new FluidBase("creosote_oil");
    public static final Fluid PLANT_OIL = new FluidBase("plant_oil");
    public static final Fluid ETHANOL = new FluidBase("ethanol");
    public static final Fluid BIODIESEL = new FluidBase("biodiesel");
    public static final Fluid CONCRETE = new FluidBase("concrete");
    public static final Fluid HERBICIDE = new FluidBase("herbicide");
    public static final Fluid REDSTONE_ACID = new FluidBase("redstone_acid");
    public static final Fluid ACETALDEHYDE = new FluidBase("acetaldehyde");
    public static final Fluid PHENOLIC_RESIN = new FluidBase("phenolic_resin");

    private static class FluidBase extends Fluid {
        public FluidBase(String fluidName) {
            super(fluidName, new ResourceLocation(Tags.MOD_ID, fluidName + "_still"), new ResourceLocation(Tags.MOD_ID, fluidName + "_flowing"));
        }
    }
}
