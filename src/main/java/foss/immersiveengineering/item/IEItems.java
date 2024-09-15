package foss.immersiveengineering.item;

import foss.immersiveengineering.Tags;
import foss.immersiveengineering.api.client.model.ModelProvider;
import foss.immersiveengineering.api.oredict.OredictProvider;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.*;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
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

public class IEItems {

    private static final List<Item> ITEMS = new ArrayList<>();

    public static final CreativeTabs TAB = new CreativeTabs(Tags.MOD_ID) {
        @Nonnull
        @Override
        @SideOnly(Side.CLIENT)
        public ItemStack createIcon() {
            return new ItemStack(Items.APPLE);
        }
    };

    //             STEEL_HELMET, STEEL_CHESTPLATE, STEEL_LEGGINGS, STEEL_BOOTS,

    // PRESSES
    public static final Item PRESS_PLATE = register("plate_press"), PRESS_GEAR = register("gear_press"), PRESS_ROD = register("rod_press"),
            PRESS_BULLET_CASING = register("bullet_casing_press"), PRESS_WIRE = register("wire_press"),
            PRESS_2x2 = register("2x2_press"), PRESS_3x3 = register("3x3_press"), PRESS_UNPACKING = register("unpacking_press");

    // RODS
    public static final Item
            TREATED_STICK = registerOre("treated_stick", "stickTreated"), IRON_ROD = registerOre("iron_rod", "rodIron"),
            STEEL_ROD = registerOre("steel_rod", "rodSteel"), ALUMINIUM_ROD = registerOre("aluminium_rod", "rodAluminium");

    // CRAFTING MATERIALS
    public static final Item
            HEMP_FIBER = register("hemp_fiber"), TOUGH_FABRIC = register("tough_fabric"), ERSATZ_LEATHER = registerOre("ersatz_leather", "leather"),
            IRON_COMPONENT = register("iron_component"), STEEL_COMPONENT = register("steel_component"),
            ELECTRONIC_COMPONENT = register("electric_component"), ADVANCED_ELECTRONIC_COMPONENT = register("adv_electric_component"),
            LIGHT_BULB = register("light_bulb"), VACUUM_TUBE = register("vacuum_tube"), CIRCUIT_BACKPLANE = register("circuit_backplane"),
            EMPTY_CASING = register("empty_casing"), EMPTY_SHEEL = register("empty_sheel");

    public static final Item
            WATERWHEEL_SEGMENT = register("waterwheel_segment"), WINDMILL_BLADE = register("windmill_blade"), WINDMILL_SAIL = register("windmill_sail"),
            WOODEN_GRIP = register("wooden_grip"), REVOLVER_BARREL = register("revolver_barrel"), REVOLVER_DRUM = register("revolver_drum"), REVOLVER_HAMMER = register("revolver_hammer");

    // MATERIALS
    public static final Item COAL_COKE = registerOre("coal_coke", "gemCoke"), SLAG = registerOre("slag", "slag");

    // DUSTS
    public static final Item
            COKE_DUST = registerOre("coke_dust", "dustCoke"), NITRATE_DUST = registerOre("nitrate", "dustNitrate"), SULFUR_DUST = registerOre("sulfur", "dustSulfur"),
            SAWDUST = registerOre("sawdust", "sawdust"),
            HOP_GRAPHITE_DUST = registerOre("graphite_dust", "dustHOPGraphite"), COPPER_DUST = registerOre("copper_dust", "dustCopper"),
            ALUMINIUM_DUST = registerOre("aluminium_dust", "dustAluminium"), LEAD_DUST = registerOre("lead_dust", "dustLead"),
            SILVER_DUST = registerOre("silver_dust", "dustSilver"), NICKEL_DUST = registerOre("nickel_dust", "dustNickel"),
            URANIUM_DUST = registerOre("uranium_dust", "dustUranium"), CONSTANTAN_DUST = registerOre("constantan_dust", "dustConstantan"),
            ELECTRUM_DUST = registerOre("electrum_dust", "dustElectrum"), STEEL_DUST = registerOre("steel_dust", "dustSteel"),
            IRON_DUST = registerOre("iron_dust", "dustIron"), GOLD_DUST = registerOre("gold_dust", "dustGold");

    // INGOTS
    public static final Item
            HOP_GRAPITE_INGOT = registerOre("graphite_ingot", "ingotHOPGraphite"), COPPER_INGOT = registerOre("copper_ingot", "ingotCopper"),
            ALUMINIUM_INGOT = registerOre("aluminium_ingot", "ingotAluminium"), LEAD_INGOT = registerOre("lead_ingot", "ingotLead"),
            SILVER_INGOT = registerOre("silver_ingot", "ingotSilver"), NICKEL_INGOT = registerOre("nickel_ingot", "ingotNickel"),
            URANIUM_INGOT = registerOre("uranium_ingot", "ingotUranium"), CONSTANTAN_INGOT = registerOre("constantan_ingot", "ingotConstantan"),
            ELECTRUM_INGOT = registerOre("electrum_ingot", "ingotElectrum"), STEEL_INGOT = registerOre("steel_ingot", "ingotSteel");

    // NUGGETS
    public static final Item
            COPPER_NUGGET = registerOre("copper_nugget", "nuggetCopper"),
            ALUMINIUM_NUGGET = registerOre("aluminium_nugget", "nuggetAluminium"), LEAD_NUGGET = registerOre("lead_nugget", "nuggetLead"),
            SILVER_NUGGET = registerOre("silver_nugget", "nuggetSilver"), NICKEL_NUGGET = registerOre("nickel_nugget", "nuggetNickel"),
            URANIUM_NUGGET = registerOre("uranium_nugget", "nuggetUranium"), CONSTANTAN_NUGGET = registerOre("constantan_nugget", "nuggetConstantan"),
            ELECTRUM_NUGGET = registerOre("electrum_nugget", "nuggetElectrum"), STEEL_NUGGET = registerOre("steel_nugget", "nuggetSteel");

    // PLATES
    public static final Item
            COPPER_PLATE = registerOre("copper_plate", "plateCopper"), DUROPLAST_SHEET = registerOre("duroplast_sheet", "plateDuroplast"),
            ALUMINIUM_PLATE = registerOre("aluminium_plate", "plateAluminium"), LEAD_PLATE = registerOre("lead_plate", "plateLead"),
            SILVER_PLATE = registerOre("silver_plate", "plateSilver"), NICKEL_PLATE = registerOre("nickel_plate", "plateNickel"),
            URANIUM_PLATE = registerOre("uranium_plate", "plateUranium"), CONSTANTAN_PLATE = registerOre("constantan_plate", "plateConstantan"),
            ELECTRUM_PLATE = registerOre("electrum_plate", "plateElectrum"), STEEL_PLATE = registerOre("steel_plate", "plateSteel"),
            IRON_PLATE = registerOre("iron_plate", "plateIron"), GOLD_PLATE = registerOre("gold_plate", "plateGold");

    // WIRES
    public static final Item
            COPPER_WIRE = registerOre("copper_wire", "wireCopper"),
            ALUMINIUM_WIRE = registerOre("aluminium_wire", "wireAluminium"), LEAD_WIRE = registerOre("lead_wire", "wireLead"),
            ELECTRUM_WIRE = registerOre("electrum_wire", "wireElectrum"), STEEL_WIRE = registerOre("steel_wire", "wireSteel");

    // COILS
    public static final Item
            LV_COIL = register("lv_coil"), MV_COIL = register("mv_coil"), HV_COIL = register("hv_coil"),
            INSULATED_LV_COIL = register("lv_coil_insulated"), INSULATED_MV_COIL = register("mv_coil_insulated"),
            HEMP_COIL = register("hemp_coil"), STEEL_COIL = register("steel_coil"), REDSTONE_COIL = register("redstone_coil");

    // TOOLS
    public static final Item HAMMER = register("hammer"), CUTTER = register("cutter"), SCREWDRIVER = register("screwdriver"), MANUAL = register("manual"), MULTIMETER = register("multimeter"), TOOLBOX = register("toolbox"), SKYHOOK = register("skyhook");

    public static final ItemPickaxe STEEL_PICKAXE = register(new ItemToolSteel.Pickaxe(), "steel_pickaxe");
    public static final ItemAxe STEEL_AXE = register(new ItemToolSteel.Axe(), "steel_axe");
    public static final ItemSpade STEEL_SHOVEL = register(new ItemToolSteel.Shovel(), "steel_shovel");
    public static final ItemHoe STEEL_HOE = register(new ItemToolSteel.Hoe(), "steel_hoe");
    public static final ItemSword STEEL_SWORD = register(new ItemToolSteel.Sword(), "steel_sword");

    /* STEEL ARMORS */

    public static final Item EAR_DEFENDERS = register("ear_defenders");

    public static final Item ACCUMULATOR_BACKPACK = register("accumulator_backpack");

    public static final Item HEAVY_SHIELD = register("heavy_shield");

    // DRILL
    public static final Item
            MINING_DRILL = register("mining_drill"),
            STEEL_DRILL_HEAD = register("steel_drill_head"), IRON_DRILL_HEAD = register("iron_drill_head"),
            AIR_TANK = register("air_tank"), ADDITIONAL_AUGERS = register("augers"),
            ROCK_SOFTENING_ACID = register("rock_acid");

    public static final Item
            BUZZSAW = register("buzzsaw"),
            SAWBLADE = register("sawblade"), ROCKCUTTER_BLADE = register("rockcutter_blade"), GRINDING_DISK = register("grinding_disk"),
            BLADE_QUIVER = register("blade_quiver");

    public static final Item
            LUBRICATION_SYSTEM = register("lubrication_system");

    public static final Item
            REVOLVER = register("revolver"),
            SPEEDLOADER = register("speedloader"), BAYONET = register("bayonet"),
            EXTENDED_MAGAZINE = register("extended_magazine"), AMPLIFIED_ELECTRON_TUBES = register("electron_tubes");

    public static final Item
            CHEMTHROWER = register("chemthrower"),
            LARGE_TANK = register("large_tank"), FOCUSED_NOZZLE = register("focused_nozzle"), MULTITANK = register("multitank");

    public static final Item
            PRECISION_SCOPE = register("scope"), FLASHBULB = register("flashbulb");

    public static final Item
            MINERAL_TOOLS = register("mineral_tools"), GLIDER = register("glider"),
            RAILGUN = register("railgun");

    public static final Item
            CARTRIDGE_CASULL = register("casull_cartridge"), CARTRIDGE_PIERCING = register("piercing_cartridge"), CARTRIDGE_BUCKSHOT = register("buckshot_cartridge"),
            CARTRIDGE_EXPLOSIVE = register("explosive_cartridge"), CARTRIDGE_SILVER = register("silver_cartridge"), CARTRIDGE_DRAGON = register("dragon_cartridge"),
            CARTRIDGE_PHIAL = register("phial_cartridge"), CARTRIDGE_FLARE = register("flare_cartridge"), CARTRIDGE_FIREWORK = register("firework_cartridge"),
            CARTRIDGE_HOMING = register("homing_cartridge"), CARTRIDGE_WOLFPACK = register("wolfpack_cartridge");

    public static final Item
            MINECART_CRATE = register("crate_minecart"), MINECART_REINFORCED_CRATE = register("reinforced_crate_minecart"), MINECART_WOOD_BARREL = register("wood_barrel_minecart");

    public static final Item HEMP_SEEDS = register("hemp_seeds");
    public static final Item JERRYCAN = register("jerrycan");
    public static final Item BLUEPRINT = register("blueprint");
    public static final Item SHADER = register("shader");
    public static final Item CORE_SAMPLE = register("core_sample");
    public static final Item GRAPHITE_ELECTRODE = register("electrode");
    public static final Item FLUORESCENT_TUBE = register("fluorescent_tube");
    public static final Item MAINTENANCE_KIT = register("maintenance_kit");
    public static final Item INDUSTRIAL_FERTILIZER = register("fertilizer");

    /*
            MINING_DRILL, STEEL_DRILL_HEAD, IRON_DRILL_HEAD,
            BUZZSAW, SAWBLADE, ROCKCUTTER_BLADE, GRINDING_DISK,
            MINERAL_TOOLS, COLLAPSIBLE_GLIDER,
            REVOLVER, REVOLVER_SPEEDLOADER,
            CHEMTHROWER, RAILGUN,

            ;

    NETHERITE_ROD
    */

    public static ItemOreDict registerOre(String name, String oreName) {
        return register(new ItemOreDict(oreName), name);
    }

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

    public static void registerOres() {
        for (Item item : ITEMS) {
            if (item instanceof OredictProvider) {
                OredictProvider provider = (OredictProvider) item;
                provider.registerOreEntries();
            }
        }
    }

    @SideOnly(Side.CLIENT)
    public static void registerModels(ModelRegistryEvent event) {
        StringBuilder builder = new StringBuilder("# Item Groups\nitemGroup.immersiveengineering=Immersive Engineering\n\n");

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

    private static void addItem(StringBuilder builder, Item item) {
        builder.append(item.getTranslationKey()).append("=\n");
    }

    private static void writeBuilder(StringBuilder builder) {
        File file = new File("src/main/resources/assets/immersiveengineering/lang/en_us.lang");

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
