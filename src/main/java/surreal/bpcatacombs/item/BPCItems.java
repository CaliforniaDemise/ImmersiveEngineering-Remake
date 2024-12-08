package surreal.bpcatacombs.item;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.oredict.OreDictionary;
import surreal.bpcatacombs.Tags;
import surreal.bpcatacombs.api.client.model.ModelProvider;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.*;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;

import javax.annotation.Nonnull;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BPCItems {

    private static List<Item> ITEMS = new ArrayList<>();

    public static final CreativeTabs TAB = new CreativeTabs(Tags.MOD_ID) {
        @Nonnull
        @Override
        @SideOnly(Side.CLIENT)
        public ItemStack createIcon() {
            return new ItemStack(Items.APPLE);
        }
    };

    @ObjectHolder("bpcatacombs:plate_press") public static final Item PRESS_PLATE = null;
    @ObjectHolder("bpcatacombs:gear_press") public static final Item PRESS_GEAR = null;
    @ObjectHolder("bpcatacombs:rod_press") public static final Item PRESS_ROD = null;
    @ObjectHolder("bpcatacombs:bullet_casing_press") public static final Item PRESS_BULLET_CASING = null;
    @ObjectHolder("bpcatacombs:wire_press") public static final Item PRESS_WIRE = null;
    @ObjectHolder("bpcatacombs:2x2_press") public static final Item PRESS_2X2 = null;
    @ObjectHolder("bpcatacombs:3x3_press") public static final Item PRESS_3X3 = null;
    @ObjectHolder("bpcatacombs:unpacking_press") public static final Item PRESS_UNPACKING = null;
    @ObjectHolder("bpcatacombs:treated_stick") public static final Item TREATED_STICK = null;
    @ObjectHolder("bpcatacombs:iron_stick") public static final Item IRON_STICK = null;
    @ObjectHolder("bpcatacombs:steel_stick") public static final Item STEEL_STICK = null;
    @ObjectHolder("bpcatacombs:aluminium_stick") public static final Item ALUMINIUM_STICK = null;
    @ObjectHolder("bpcatacombs:netherite_stick") public static final Item NETHERITE_STICK = null;
    @ObjectHolder("bpcatacombs:hemp_fiber") public static final Item HEMP_FIBER = null;
    @ObjectHolder("bpcatacombs:tough_fabric") public static final Item TOUGH_FABRIC = null;
    @ObjectHolder("bpcatacombs:ersatz_leather") public static final Item ERSATZ_LEATHER = null;
    @ObjectHolder("bpcatacombs:iron_component") public static final Item IRON_COMPONENT = null;
    @ObjectHolder("bpcatacombs:steel_component") public static final Item STEEL_COMPONENT = null;
    @ObjectHolder("bpcatacombs:electronic_component") public static final Item ELECTRONIC_COMPONENT = null;
    @ObjectHolder("bpcatacombs:adv_electronic_component") public static final Item ADV_ELECTRIC_COMPONENT = null;
    @ObjectHolder("bpcatacombs:light_bulb") public static final Item LIGHT_BULB = null;
    @ObjectHolder("bpcatacombs:vacuum_tube") public static final Item VACUUM_TUBE = null;
    @ObjectHolder("bpcatacombs:circuit_backplane") public static final Item CIRCUIT_BACKPLANE = null;
    @ObjectHolder("bpcatacombs:empty_casing") public static final Item EMPTY_CASING = null;
    @ObjectHolder("bpcatacombs:empty_shell") public static final Item EMPTY_SHELL = null;
    @ObjectHolder("bpcatacombs:waterwheel_part") public static final Item WATERWHEEL_PART = null;
    @ObjectHolder("bpcatacombs:windmill_part") public static final Item WINDMILL_PART = null;
    @ObjectHolder("bpcatacombs:windmill_sail") public static final Item WINDMILL_SAIL = null;
    @ObjectHolder("bpcatacombs:wooden_grip") public static final Item WOODEN_GRIP = null;
    @ObjectHolder("bpcatacombs:revolver_barrel") public static final Item REVOLVER_BARREL = null;
    @ObjectHolder("bpcatacombs:revolver_drum") public static final Item REVOLVER_DRUM = null;
    @ObjectHolder("bpcatacombs:revolver_hammer") public static final Item REVOLVER_HAMMER = null;
    @ObjectHolder("bpcatacombs:coke") public static final Item COKE = null;
    @ObjectHolder("bpcatacombs:slag") public static final Item SLAG = null;
    @ObjectHolder("bpcatacombs:coke_dust") public static final Item COKE_DUST = null;
    @ObjectHolder("bpcatacombs:nitrate_dust") public static final Item NITRATE_DUST = null;
    @ObjectHolder("bpcatacombs:sulfur_dust") public static final Item SULFUR_DUST = null;
    @ObjectHolder("bpcatacombs:sawdust") public static final Item SAWDUST = null;
    @ObjectHolder("bpcatacombs:hop_graphite_dust") public static final Item HOP_GRAPHITE_DUST = null;
    @ObjectHolder("bpcatacombs:copper_dust") public static final Item COPPER_DUST = null;
    @ObjectHolder("bpcatacombs:aluminium_dust") public static final Item ALUMINIUM_DUST = null;
    @ObjectHolder("bpcatacombs:lead_dust") public static final Item LEAD_DUST = null;
    @ObjectHolder("bpcatacombs:silver_dust") public static final Item SILVER_DUST = null;
    @ObjectHolder("bpcatacombs:nickel_dust") public static final Item NICKEL_DUST = null;
    @ObjectHolder("bpcatacombs:uranium_dust") public static final Item URANIUM_DUST = null;
    @ObjectHolder("bpcatacombs:constantan_dust") public static final Item CONSTANTAN_DUST = null;
    @ObjectHolder("bpcatacombs:electrum_dust") public static final Item ELECTRUM_DUST = null;
    @ObjectHolder("bpcatacombs:steel_dust") public static final Item STEEL_DUST = null;
    @ObjectHolder("bpcatacombs:iron_dust") public static final Item IRON_DUST = null;
    @ObjectHolder("bpcatacombs:gold_dust") public static final Item GOLD_DUST = null;
    @ObjectHolder("bpcatacombs:hop_graphite_ingot") public static final Item HOP_GRAPHITE_INGOT = null;
    @ObjectHolder("bpcatacombs:copper_ingot") public static final Item COPPER_INGOT = null;
    @ObjectHolder("bpcatacombs:aluminium_ingot") public static final Item ALUMINIUM_INGOT = null;
    @ObjectHolder("bpcatacombs:lead_ingot") public static final Item LEAD_INGOT = null;
    @ObjectHolder("bpcatacombs:silver_ingot") public static final Item SILVER_INGOT = null;
    @ObjectHolder("bpcatacombs:nickel_ingot") public static final Item NICKEL_INGOT = null;
    @ObjectHolder("bpcatacombs:uranium_ingot") public static final Item URANIUM_INGOT = null;
    @ObjectHolder("bpcatacombs:constantan_ingot") public static final Item CONSTANTAN_INGOT = null;
    @ObjectHolder("bpcatacombs:electrum_ingot") public static final Item ELECTRUM_INGOT = null;
    @ObjectHolder("bpcatacombs:steel_ingot") public static final Item STEEL_INGOT = null;
    @ObjectHolder("bpcatacombs:copper_nugget") public static final Item COPPER_NUGGET = null;
    @ObjectHolder("bpcatacombs:aluminium_nugget") public static final Item ALUMINIUM_NUGGET = null;
    @ObjectHolder("bpcatacombs:lead_nugget") public static final Item LEAD_NUGGET = null;
    @ObjectHolder("bpcatacombs:silver_nugget") public static final Item SILVER_NUGGET = null;
    @ObjectHolder("bpcatacombs:nickel_nugget") public static final Item NICKEL_NUGGET = null;
    @ObjectHolder("bpcatacombs:uranium_nugget") public static final Item URANIUM_NUGGET = null;
    @ObjectHolder("bpcatacombs:constantan_nugget") public static final Item CONSTANTAN_NUGGET = null;
    @ObjectHolder("bpcatacombs:electrum_nugget") public static final Item ELECTRUM_NUGGET = null;
    @ObjectHolder("bpcatacombs:steel_nugget") public static final Item STEEL_NUGGET = null;
    @ObjectHolder("bpcatacombs:netherite_nugget") public static final Item NETHERITE_NUGGET = null;
    @ObjectHolder("bpcatacombs:copper_plate") public static final Item COPPER_PLATE = null;
    @ObjectHolder("bpcatacombs:duroplast_plate") public static final Item DUROPLAST_PLATE = null;
    @ObjectHolder("bpcatacombs:aluminium_plate") public static final Item ALUMINIUM_PLATE = null;
    @ObjectHolder("bpcatacombs:lead_plate") public static final Item LEAD_PLATE = null;
    @ObjectHolder("bpcatacombs:silver_plate") public static final Item SILVER_PLATE = null;
    @ObjectHolder("bpcatacombs:nickel_plate") public static final Item NICKEL_PLATE = null;
    @ObjectHolder("bpcatacombs:uranium_plate") public static final Item URANIUM_PLATE = null;
    @ObjectHolder("bpcatacombs:constantan_plate") public static final Item CONSTANTAN_PLATE = null;
    @ObjectHolder("bpcatacombs:electrum_plate") public static final Item ELECTRUM_PLATE = null;
    @ObjectHolder("bpcatacombs:steel_plate") public static final Item STEEL_PLATE = null;
    @ObjectHolder("bpcatacombs:iron_plate") public static final Item IRON_PLATE = null;
    @ObjectHolder("bpcatacombs:gold_plate") public static final Item GOLD_PLATE = null;
    @ObjectHolder("bpcatacombs:copper_wire") public static final Item COPPER_WIRE = null;
    @ObjectHolder("bpcatacombs:aluminium_wire") public static final Item ALUMINIUM_WIRE = null;
    @ObjectHolder("bpcatacombs:lead_wire") public static final Item LEAD_WIRE = null;
    @ObjectHolder("bpcatacombs:electrum_wire") public static final Item ELECTRUM_WIRE = null;
    @ObjectHolder("bpcatacombs:steel_wire") public static final Item STEEL_WIRE = null;
    @ObjectHolder("bpcatacombs:lv_coil") public static final Item LV_COIL = null;
    @ObjectHolder("bpcatacombs:mv_coil") public static final Item MV_COIL = null;
    @ObjectHolder("bpcatacombs:hv_coil") public static final Item HV_COIL = null;
    @ObjectHolder("bpcatacombs:insulated_lv_coil") public static final Item INSULATED_LV_COIL = null;
    @ObjectHolder("bpcatacombs:insulated_mv_coil") public static final Item INSULATED_MV_COIL = null;
    @ObjectHolder("bpcatacombs:hemp_coil") public static final Item HEMP_COIL = null;
    @ObjectHolder("bpcatacombs:steel_coil") public static final Item STEEL_COIL = null;
    @ObjectHolder("bpcatacombs:redstone_coil") public static final Item REDSTONE_COIL = null;
    @ObjectHolder("bpcatacombs:hammer") public static final Item HAMMER = null;
    @ObjectHolder("bpcatacombs:wire_cutter") public static final Item WIRE_CUTTER = null;
    @ObjectHolder("bpcatacombs:screwdriver") public static final Item SCREWDRIVER = null;
    @ObjectHolder("bpcatacombs:manual") public static final Item MANUAL = null;
    @ObjectHolder("bpcatacombs:multimeter") public static final Item MULTIMETER = null;
    @ObjectHolder("bpcatacombs:toolbox") public static final Item TOOLBOX = null;
    @ObjectHolder("bpcatacombs:skyhook") public static final Item SKYHOOK = null;
    @ObjectHolder("bpcatacombs:steel_pickaxe") public static final Item STEEL_PICKAXE = null;
    @ObjectHolder("bpcatacombs:steel_axe") public static final Item STEEL_AXE = null;
    @ObjectHolder("bpcatacombs:steel_shovel") public static final Item STEEL_SHOVEL = null;
    @ObjectHolder("bpcatacombs:steel_hoe") public static final Item STEEL_HOE = null;
    @ObjectHolder("bpcatacombs:steel_sword") public static final Item STEEL_SWORD = null;
    @ObjectHolder("bpcatacombs:steel_helmet") public static final Item STEEL_HELMET = null;
    @ObjectHolder("bpcatacombs:steel_chestplate") public static final Item STEEL_CHESTPLATE = null;
    @ObjectHolder("bpcatacombs:steel_leggings") public static final Item STEEL_LEGGINGS = null;
    @ObjectHolder("bpcatacombs:steel_boots") public static final Item STEEL_BOOTS = null;
    @ObjectHolder("bpcatacombs:ear_defenders") public static final Item EAR_DEFENDERS = null;
    @ObjectHolder("bpcatacombs:accumulator_backpack") public static final Item ACCUMULATOR_BACKPACK = null;
    @ObjectHolder("bpcatacombs:heavy_shield") public static final Item HEAVY_SHIELD = null;
    @ObjectHolder("bpcatacombs:mining_drill") public static final Item MINING_DRILL = null;
    @ObjectHolder("bpcatacombs:buzzsaw") public static final Item BUZZSAW = null;
    @ObjectHolder("bpcatacombs:revolver") public static final Item REVOLVER = null;
    @ObjectHolder("bpcatacombs:chemthrower") public static final Item CHEMTHROWER = null;
    @ObjectHolder("bpcatacombs:railgun") public static final Item RAILGUN = null;
    @ObjectHolder("bpcatacombs:mineral_tools") public static final Item MINERAL_TOOLS = null;
    @ObjectHolder("bpcatacombs:glider") public static final Item GLIDER = null;
    @ObjectHolder("bpcatacombs:steel_drill_head") public static final Item STEEL_DRILL_HEAD = null;
    @ObjectHolder("bpcatacombs:iron_drill_head") public static final Item IRON_DRILL_HEAD = null;
    @ObjectHolder("bpcatacombs:air_tank") public static final Item AIR_TANK = null;
    @ObjectHolder("bpcatacombs:additional_augers") public static final Item ADDITIONAL_AUGERS = null;
    @ObjectHolder("bpcatacombs:rock_softening_acid") public static final Item ROCK_SOFTENING_ACID = null;
    @ObjectHolder("bpcatacombs:sawblade") public static final Item SAWBLADE = null;
    @ObjectHolder("bpcatacombs:rockcutter_blade") public static final Item ROCKCUTTER_BLADE = null;
    @ObjectHolder("bpcatacombs:grinding_disk") public static final Item GRINDING_DISK = null;
    @ObjectHolder("bpcatacombs:blade_quiver") public static final Item BLADE_QUIVER = null;
    @ObjectHolder("bpcatacombs:lubrication_system") public static final Item LUBRICATION_SYSTEM = null;
    @ObjectHolder("bpcatacombs:speedloader") public static final Item SPEEDLOADER = null;
    @ObjectHolder("bpcatacombs:extended_magazine") public static final Item EXTENDED_MAGAZINE = null;
    @ObjectHolder("bpcatacombs:electron_tubes") public static final Item ELECTRON_TUBES = null;
    @ObjectHolder("bpcatacombs:large_tank") public static final Item LARGE_TANK = null;
    @ObjectHolder("bpcatacombs:focused_nozzle") public static final Item FOCUSED_NOZZLE = null;
    @ObjectHolder("bpcatacombs:multitank") public static final Item MULTITANK = null;
    @ObjectHolder("bpcatacombs:precision_scope") public static final Item PRECISION_SCOPE = null;
    @ObjectHolder("bpcatacombs:flashbulb") public static final Item FLASHBULB = null;
    @ObjectHolder("bpcatacombs:cartridge_casull") public static final Item CARTRIDGE_CASULL = null;
    @ObjectHolder("bpcatacombs:cartridge_piercing") public static final Item CARTRIDGE_PIERCING = null;
    @ObjectHolder("bpcatacombs:cartridge_buckshot") public static final Item CARTRIDGE_BUCKSHOT = null;
    @ObjectHolder("bpcatacombs:cartridge_explosive") public static final Item CARTRIDGE_EXPLOSIVE = null;
    @ObjectHolder("bpcatacombs:cartridge_silver") public static final Item CARTRIDGE_SILVER = null;
    @ObjectHolder("bpcatacombs:cartridge_dragon") public static final Item CARTRIDGE_DRAGON = null;
    @ObjectHolder("bpcatacombs:cartridge_phial") public static final Item CARTRIDGE_PHIAL = null;
    @ObjectHolder("bpcatacombs:cartridge_flare") public static final Item CARTRIDGE_FLARE = null;
    @ObjectHolder("bpcatacombs:cartridge_firework") public static final Item CARTRIDGE_FIREWORK = null;
    @ObjectHolder("bpcatacombs:cartridge_homing") public static final Item CARTRIDGE_HOMING = null;
    @ObjectHolder("bpcatacombs:cartridge_wolfpack") public static final Item CARTRIDGE_WOLFPACK = null;
    @ObjectHolder("bpcatacombs:minecart_crate") public static final Item MINECART_CRATE = null;
    @ObjectHolder("bpcatacombs:minecart_crate_reinforced") public static final Item MINECART_CRATE_REINFORCED = null;
    @ObjectHolder("bpcatacombs:minecart_wood_barrel") public static final Item MINECART_WOOD_BARREL = null;
    @ObjectHolder("bpcatacombs:hemp_seeds") public static final Item HEMP_SEEDS = null;
    @ObjectHolder("bpcatacombs:jerrycan") public static final Item JERRYCAN = null;
    @ObjectHolder("bpcatacombs:blueprint") public static final Item BLUEPRINT = null;
    @ObjectHolder("bpcatacombs:shader") public static final Item SHADER = null;
    @ObjectHolder("bpcatacombs:core_sample") public static final Item CORE_SAMPLE = null;
    @ObjectHolder("bpcatacombs:electrode") public static final Item ELECTRODE = null;
    @ObjectHolder("bpcatacombs:fluorescent_tube") public static final Item FLUORESCENT_TUBE = null;
    @ObjectHolder("bpcatacombs:maintenance_kit") public static final Item MAINTENANCE_KIT = null;
    @ObjectHolder("bpcatacombs:fertilizer") public static final Item FERTILIZER = null;

    public static Item register(String name) {
        return register(new Item(), name);
    }

    public static <T extends Item> T register(T item, String name) {
        return register(item, new ResourceLocation(Tags.MOD_ID, name));
    }

    public static <T extends Item> T register(T item, ResourceLocation location) {
        item.setRegistryName(location).setTranslationKey(location.getNamespace() + "." + location.getPath());
        item.setCreativeTab(TAB);
        ITEMS.add(item);
        return item;
    }

    public static void registerItems(RegistryEvent.Register<Item> event) {
        IForgeRegistry<Item> registry = event.getRegistry();
        ITEMS.forEach(registry::register);
    }

    public static void preInit(FMLPreInitializationEvent event) {
        register("plate_press");
        register("gear_press");
        register("rod_press");
        register("bullet_casing_press");
        register("wire_press");
        register("2x2_press");
        register("3x3_press");
        register("unpacking_press");
        register("treated_stick");
        register("iron_stick");
        register("steel_stick");
        register("aluminium_stick");
        register("netherite_stick");
        register("hemp_fiber");
        register("tough_fabric");
        register("ersatz_leather");
        register("iron_component");
        register("steel_component");
        register("electronic_component");
        register("adv_electronic_component");
        register("light_bulb");
        register("vacuum_tube");
        register("circuit_backplane");
        register("empty_casing");
        register("empty_shell");
        register("waterwheel_part");
        register("windmill_part");
        register("windmill_sail");
        register("wooden_grip");
        register("revolver_barrel");
        register("revolver_drum");
        register("revolver_hammer");
        register("coke");
        register("slag");
        register("coke_dust");
        register("nitrate_dust");
        register("sulfur_dust");
        register("sawdust");
        register("hop_graphite_dust");
        register("copper_dust");
        register("aluminium_dust");
        register("lead_dust");
        register("silver_dust");
        register("nickel_dust");
        register("uranium_dust");
        register("constantan_dust");
        register("electrum_dust");
        register("steel_dust");
        register("iron_dust");
        register("gold_dust");
        register("hop_graphite_ingot");
        register("copper_ingot");
        register("aluminium_ingot");
        register("lead_ingot");
        register("silver_ingot");
        register("nickel_ingot");
        register("uranium_ingot");
        register("constantan_ingot");
        register("electrum_ingot");
        register("steel_ingot");
        register("copper_nugget");
        register("aluminium_nugget");
        register("lead_nugget");
        register("silver_nugget");
        register("nickel_nugget");
        register("uranium_nugget");
        register("constantan_nugget");
        register("electrum_nugget");
        register("steel_nugget");
        register("netherite_nugget");
        register("copper_plate");
        register("duroplast_plate");
        register("aluminium_plate");
        register("lead_plate");
        register("silver_plate");
        register("nickel_plate");
        register("uranium_plate");
        register("constantan_plate");
        register("electrum_plate");
        register("steel_plate");
        register("iron_plate");
        register("gold_plate");
        register("copper_wire");
        register("aluminium_wire");
        register("lead_wire");
        register("electrum_wire");
        register("steel_wire");
        register("lv_coil");
        register("mv_coil");
        register("hv_coil");
        register("insulated_lv_coil");
        register("insulated_mv_coil");
        register("hemp_coil");
        register("steel_coil");
        register("redstone_coil");
        register("hammer");
        register("wire_cutter");
        register("screwdriver");
        register("manual");
        register("multimeter");
        register("toolbox");
        register("skyhook");
        register("steel_pickaxe");
        register("steel_axe");
        register("steel_shovel");
        register("steel_hoe");
        register("steel_sword");
        register("steel_helmet");
        register("steel_chestplate");
        register("steel_leggings");
        register("steel_boots");
        register("ear_defenders");
        register("accumulator_backpack");
        register("heavy_shield");
        register("mining_drill");
        register("buzzsaw");
        register("revolver");
        register("chemthrower");
        register("railgun");
        register("mineral_tools");
        register("glider");
        register("steel_drill_head");
        register("iron_drill_head");
        register("air_tank");
        register("additional_augers");
        register("rock_softening_acid");
        register("sawblade");
        register("rockcutter_blade");
        register("grinding_disk");
        register("blade_quiver");
        register("lubrication_system");
        register("speedloader");
        register("extended_magazine");
        register("electron_tubes");
        register("large_tank");
        register("focused_nozzle");
        register("multitank");
        register("precision_scope");
        register("flashbulb");
        register("cartridge_casull");
        register("cartridge_piercing");
        register("cartridge_buckshot");
        register("cartridge_explosive");
        register("cartridge_silver");
        register("cartridge_dragon");
        register("cartridge_phial");
        register("cartridge_flare");
        register("cartridge_firework");
        register("cartridge_homing");
        register("cartridge_wolfpack");
        register("minecart_crate");
        register("minecart_crate_reinforced");
        register("minecart_wood_barrel");
        register("hemp_seeds");
        register("jerrycan");
        register("blueprint");
        register("shader");
        register("core_sample");
        register("electrode");
        register("fluorescent_tube");
        register("maintenance_kit");
        register("fertilizer");
    }

    public static void init(FMLInitializationEvent event) {
        registerOres();
    }

    public static void postInit(FMLPostInitializationEvent event) {
        ITEMS = null;
    }

    @SideOnly(Side.CLIENT)
    public static void registerModels(ModelRegistryEvent event) {
        StringBuilder builder = new StringBuilder("# Item Groups\nitemGroup.bpcatacombs=Immersive Engineering\n\n");

        for (Item item : ITEMS) {
            addItem(builder, item);
            if (item instanceof ModelProvider) {
                ModelProvider provider = (ModelProvider) item;
                provider.registerModels();
            }
            else ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(Objects.requireNonNull(item.getRegistryName()), "inventory"));
        }

        // TODO Handle every single item
        // writeBuilder(builder);
    }

    private static void registerOres() {
        registerOre(TREATED_STICK, "stickTreated");
        registerOre(IRON_STICK, "stickIron", "rodIron");
        registerOre(STEEL_STICK, "stickSteel", "rodSteel");
        registerOre(ALUMINIUM_STICK, "stickAluminium", "stickAluminum", "rodAluminium", "rodAluminum");
        registerOre(NETHERITE_STICK, "stickNetherite", "rodNetherite");
        registerOre(ERSATZ_LEATHER, "leather");
        registerOre(COKE, "gemCoke");
        registerOre(SLAG, "slag");
        registerOre(COKE_DUST, "dustCoke");
        registerOre(NITRATE_DUST, "dustNitrate");
        registerOre(SULFUR_DUST, "dustSulfur");
        registerOre(HOP_GRAPHITE_DUST, "dustHOPGraphite");
        registerOre(COPPER_DUST, "dustCopper");
        registerOre(ALUMINIUM_DUST, "dustAluminium", "dustAluminum");
        registerOre(LEAD_DUST, "dustLead");
        registerOre(SILVER_DUST, "dustSilver");
        registerOre(NICKEL_DUST, "dustNickel");
        registerOre(URANIUM_DUST, "dustUranium");
        registerOre(CONSTANTAN_DUST, "dustConstantan");
        registerOre(ELECTRUM_DUST, "dustElectrum");
        registerOre(STEEL_DUST, "dustSteel");
        registerOre(IRON_DUST, "dustIron");
        registerOre(GOLD_DUST, "dustGold");
        registerOre(HOP_GRAPHITE_INGOT, "ingotHOPGraphite");
        registerOre(COPPER_INGOT, "ingotCopper");
        registerOre(ALUMINIUM_INGOT, "ingotAluminium", "ingotAluminum");
        registerOre(LEAD_INGOT, "ingotLead");
        registerOre(SILVER_INGOT, "ingotSilver");
        registerOre(NICKEL_INGOT, "ingotNickel");
        registerOre(URANIUM_INGOT, "ingotUranium");
        registerOre(CONSTANTAN_INGOT, "ingotConstantan");
        registerOre(ELECTRUM_INGOT, "ingotElectrum");
        registerOre(STEEL_INGOT, "ingotSteel");
        registerOre(COPPER_NUGGET, "nuggetCopper");
        registerOre(ALUMINIUM_NUGGET, "nuggetAluminium", "plateAluminum");
        registerOre(LEAD_NUGGET, "nuggetLead");
        registerOre(SILVER_NUGGET, "nuggetSilver");
        registerOre(NICKEL_NUGGET, "nuggetNickel");
        registerOre(URANIUM_NUGGET, "nuggetUranium");
        registerOre(CONSTANTAN_NUGGET, "nuggetConstantan");
        registerOre(ELECTRUM_NUGGET, "nuggetElectrum");
        registerOre(STEEL_NUGGET, "nuggetSteel");
        registerOre(NETHERITE_NUGGET, "nuggetNetherite");
        registerOre(COPPER_PLATE, "plateCopper");
        registerOre(ALUMINIUM_PLATE, "plateAluminium", "plateAluminum");
        registerOre(LEAD_PLATE, "plateLead");
        registerOre(SILVER_PLATE, "plateSilver");
        registerOre(NICKEL_PLATE, "plateNickel");
        registerOre(URANIUM_PLATE, "plateUranium");
        registerOre(CONSTANTAN_PLATE, "plateConstantan");
        registerOre(ELECTRUM_PLATE, "plateElectrum");
        registerOre(STEEL_PLATE, "plateSteel");
        registerOre(IRON_PLATE, "plateIron");
        registerOre(GOLD_PLATE, "plateGold");
        registerOre(COPPER_WIRE, "wireCopper");
        registerOre(ALUMINIUM_WIRE, "wireAluminium", "wireAluminum");
        registerOre(LEAD_WIRE, "wireLead");
        registerOre(ELECTRUM_WIRE, "wireElectrum");
        registerOre(STEEL_WIRE, "wireSteel");
    }

    private static void registerOre(Item item, String... entries) {
        if (item != null) {
            for (String entry : entries) {
                OreDictionary.registerOre(entry, item);
            }
        }
    }

    private static void addItem(StringBuilder builder, Item item) {
        builder.append(item.getTranslationKey()).append("=\n");
    }

    private static void writeBuilder(StringBuilder builder) {
        File file = new File("src/main/resources/assets/bpcatacombs/lang/en_us.lang");

        try {
            FileWriter writer = new FileWriter(file);
            writer.write(builder.toString());
            writer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}
