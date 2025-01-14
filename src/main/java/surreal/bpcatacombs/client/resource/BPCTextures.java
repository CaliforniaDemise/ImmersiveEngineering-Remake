package surreal.bpcatacombs.client.resource;

import com.cleanroommc.assetmover.AssetMoverAPI;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;

// TODO Handle it without AssetMover
// 1.20.4-11.6.1-181
public class BPCTextures {

    @SideOnly(Side.CLIENT)
    public static void initTextures() {
        TextureMap map = new TextureMap();

        // Blocks
        map.putTex("block/wooden_device/workbench", "blocks/wooden_device/workbench");
        map.putTex("block/multiblocks/autoworkbench_blueprint", "blocks/multiblocks/autoworkbench_blueprint");

        map.putTex("block/wooden_decoration/treated_wood", "blocks/wooden_decoration/treated_wood");

        // Items
        map.putTex("item/armor_faraday_helmet", "items/armor_faraday_helmet");
        map.putTex("item/armor_faraday_chestplate", "items/armor_faraday_chestplate");
        map.putTex("item/armor_faraday_leggings", "items/armor_faraday_leggings");
        map.putTex("item/armor_faraday_boots", "items/armor_faraday_boots");
        map.putTex("item/armor_steel_helmet", "items/armor_steel_helmet");
        map.putTex("item/armor_steel_chestplate", "items/armor_steel_chestplate");
        map.putTex("item/armor_steel_leggings", "items/armor_steel_leggings");
        map.putTex("item/armor_steel_boots", "items/armor_steel_boots");
        map.putTex("item/banner_pattern_bevels", "items/banner_pattern_bevels");
        map.putTex("item/banner_pattern_ornate", "items/banner_pattern_ornate");
        map.putTex("item/banner_pattern_hammer", "items/banner_pattern_hammer");
        map.putTex("item/banner_pattern_screwdriver", "items/banner_pattern_screwdriver");
        map.putTex("item/banner_pattern_treated_wood", "items/banner_pattern_treated_wood");
        map.putTex("item/banner_pattern_warning", "items/banner_pattern_warning");
        map.putTex("item/banner_pattern_windmill", "items/banner_pattern_windmill");
        map.putTex("item/banner_pattern_wirecutter", "items/banner_pattern_wirecutter");
        map.putTex("item/banner_pattern_wolf", "items/banner_pattern_wolf");
        map.putTex("item/blueprint", "items/blueprint");
        map.putTex("item/bullet_armor_piercing", "items/bullet_armor_piercing");
        map.putTex("item/bullet_buckshot", "items/bullet_buckshot");
        map.putTex("item/bullet_casull", "items/bullet_casull");
        map.putTex("item/bullet_crystallwill", "items/bullet_crystallwill");
        map.putTex("item/bullet_dragons_breath", "items/bullet_dragons_breath");
        map.putTex("item/bullet_empty_casing", "items/bullet_empty_casing");
        map.putTex("item/bullet_empty_shell", "items/bullet_empty_shell");
        map.putTex("item/bullet_firework", "items/bullet_firework");
        map.putTex("item/bullet_flare", "items/bullet_flare");
        map.putTex("item/bullet_flare_layer", "items/bullet_flare_layer");
        map.putTex("item/bullet_he", "items/bullet_he");
        map.putTex("item/bullet_homing", "items/bullet_homing");
        map.putTex("item/bullet_potion", "items/bullet_potion");
        map.putTex("item/bullet_potion_layer", "items/bullet_potion_layer");
        map.putTex("item/bullet_silver", "items/bullet_silver");
        map.putTex("item/bullet_terrasteel", "items/bullet_terrasteel");
        map.putTex("item/bullet_wolfpack", "items/bullet_wolfpack");
        map.putTex("item/buzzsaw_diesel", "items/buzzsaw_diesel");
        map.putTex("item/chemthrower", "items/chemthrower");
        map.putTex("item/door_steel", "items/door_steel");
        map.putTex("item/door_treated", "items/door_treated");
        map.putTex("item/door_treated_framed", "items/door_treated_framed");
        map.putTex("item/drill_diesel", "items/drill_diesel");
        map.putTex("item/drill_iron", "items/drill_iron");
        map.putTex("item/drillhead_iron", "items/drillhead_iron");
        map.putTex("item/drillhead_steel", "items/drillhead_steel");
        map.putTex("item/earmuffs", "items/earmuffs");
        map.putTex("item/earmuffs_overlay", "items/earmuffs_overlay");
        map.putTex("item/fake_icon_birthday", "items/fake_icon_birthday");
        map.putTex("item/fake_icon_bttf", "items/fake_icon_bttf");
        map.putTex("item/fake_icon_drillbreak", "items/fake_icon_drillbreak");
        map.putTex("item/fake_icon_fried", "items/fake_icon_fried");
        map.putTex("item/fake_icon_lucky", "items/fake_icon_lucky");
        map.putTex("item/fake_icon_ravenholm", "items/fake_icon_ravenholm");
        map.putTex("item/fertilizer", "items/fertilizer");
        map.putTex("item/fluid_containers_bottle_biodiesel", "items/fluid_containers_bottle_biodiesel");
        map.putTex("item/fluid_containers_bottle_creosote", "items/fluid_containers_bottle_creosote");
        map.putTex("item/fluid_containers_bottle_ethanol", "items/fluid_containers_bottle_ethanol");
        map.putTex("item/fluid_containers_bottle_plantoil", "items/fluid_containers_bottle_plantoil");
        map.putTex("item/fluorescent_tube", "items/fluorescent_tube");
        map.putTex("item/fluorescent_tube_rod", "items/fluorescent_tube_rod");
        map.putTex("item/glider", "items/glider");
        map.putTex("item/graphite_electrode", "items/graphite_electrode");
        map.putTex("item/grindingdisk", "items/grindingdisk");
        map.putTex("item/grindingdisk_blade", "items/grindingdisk_blade");
        map.putTex("item/jerrycan", "items/jerrycan");
        map.putTex("item/logic_circuit", "items/logic_circuit");
        map.putTex("item/maintenance_kit", "items/maintenance_kit");
        map.putTex("item/maneuver_gear", "items/maneuver_gear");
        map.putTex("item/material_circuit_board", "items/material_circuit_board");
        map.putTex("item/material_coal_coke", "items/material_coal_coke");
        map.putTex("item/material_component_electric", "items/material_component_electric");
        map.putTex("item/material_component_electric_adv", "items/material_component_electric_adv");
        map.putTex("item/material_component_iron", "items/material_component_iron");
        map.putTex("item/material_component_steel", "items/material_component_steel");
        map.putTex("item/material_dust_coke", "items/material_dust_coke");
        map.putTex("item/material_dust_hop_graphite", "items/material_dust_hop_graphite");
        map.putTex("item/material_dust_saltpeter", "items/material_dust_saltpeter");
        map.putTex("item/material_dust_sulfur", "items/material_dust_sulfur");
        map.putTex("item/material_dust_wood", "items/material_dust_wood");
        map.putTex("item/material_electron_tube", "items/material_electron_tube");
        map.putTex("item/material_ersatz_leather", "items/material_ersatz_leather");
        map.putTex("item/material_gunpart_barrel", "items/material_gunpart_barrel");
        map.putTex("item/material_gunpart_drum", "items/material_gunpart_drum");
        map.putTex("item/material_gunpart_hammer", "items/material_gunpart_hammer");
        map.putTex("item/material_hemp_fabric", "items/material_hemp_fabric");
        map.putTex("item/material_hemp_fiber", "items/material_hemp_fiber");
        map.putTex("item/material_ingot_hop_graphite", "items/material_ingot_hop_graphite");
        map.putTex("item/material_light_bulb", "items/material_light_bulb");
        map.putTex("item/material_plate_duroplast", "items/material_plate_duroplast");
        map.putTex("item/material_slag", "items/material_slag");
        map.putTex("item/material_stick_aluminum", "items/material_stick_aluminium");
        map.putTex("item/material_stick_iron", "items/material_stick_iron");
        map.putTex("item/material_stick_netherite", "items/material_stick_netherite");
        map.putTex("item/material_stick_steel", "items/material_stick_steel");
        map.putTex("item/material_stick_treated", "items/material_stick_treated");
        map.putTex("item/material_waterwheel_segment", "items/material_waterwheel_segment");
        map.putTex("item/material_windmill_blade", "items/material_windmill_blade");
        map.putTex("item/material_windmill_sail", "items/material_windmill_sail");
        map.putTex("item/material_wire_aluminum", "items/material_wire_aluminium");
        map.putTex("item/material_wire_copper", "items/material_wire_copper");
        map.putTex("item/material_wire_electrum", "items/material_wire_electrum");
        map.putTex("item/material_wire_lead", "items/material_wire_lead");
        map.putTex("item/material_wire_steel", "items/material_wire_steel");
        map.putTex("item/material_wooden_grip", "items/material_wooden_grip");
        map.putTex("item/material_dust_aluminum", "items/material_dust_aluminium");
        map.putTex("item/material_dust_constantan", "items/material_dust_constantan");
        map.putTex("item/material_dust_copper", "items/material_dust_copper");
        map.putTex("item/material_dust_electrum", "items/material_dust_electrum");
        map.putTex("item/material_dust_gold", "items/material_dust_gold");
        map.putTex("item/material_dust_iron", "items/material_dust_iron");
        map.putTex("item/material_dust_lead", "items/material_dust_lead");
        map.putTex("item/material_dust_nickel", "items/material_dust_nickel");
        map.putTex("item/material_dust_quartz", "items/material_dust_quartz");
        map.putTex("item/material_dust_silver", "items/material_dust_silver");
        map.putTex("item/material_dust_steel", "items/material_dust_steel");
        map.putTex("item/material_dust_uranium", "items/material_dust_uranium");
        map.putTex("item/material_ingot_aluminum", "items/material_ingot_aluminium");
        map.putTex("item/material_ingot_constantan", "items/material_ingot_constantan");
        map.putTex("item/material_ingot_copper", "items/material_ingot_copper");
        map.putTex("item/material_ingot_electrum", "items/material_ingot_electrum");
        map.putTex("item/material_ingot_lead", "items/material_ingot_lead");
        map.putTex("item/material_ingot_nickel", "items/material_ingot_nickel");
        map.putTex("item/material_ingot_silver", "items/material_ingot_silver");
        map.putTex("item/material_ingot_steel", "items/material_ingot_steel");
        map.putTex("item/material_ingot_uranium", "items/material_ingot_uranium");
        map.putTex("item/material_nugget_aluminum", "items/material_nugget_aluminium");
        map.putTex("item/material_nugget_constantan", "items/material_nugget_constantan");
        map.putTex("item/material_nugget_copper", "items/material_nugget_copper");
        map.putTex("item/material_nugget_electrum", "items/material_nugget_electrum");
        map.putTex("item/material_nugget_iron", "items/material_nugget_iron");
        map.putTex("item/material_nugget_lead", "items/material_nugget_lead");
        map.putTex("item/material_nugget_netherite", "items/material_nugget_netherite");
        map.putTex("item/material_nugget_nickel", "items/material_nugget_nickel");
        map.putTex("item/material_nugget_silver", "items/material_nugget_silver");
        map.putTex("item/material_nugget_steel", "items/material_nugget_steel");
        map.putTex("item/material_nugget_uranium", "items/material_nugget_uranium");
        map.putTex("item/metal_plate_aluminum", "items/metal_plate_aluminium");
        map.putTex("item/metal_plate_constantan", "items/metal_plate_constantan");
        map.putTex("item/metal_plate_copper", "items/metal_plate_copper");
        map.putTex("item/metal_plate_electrum", "items/metal_plate_electrum");
        map.putTex("item/metal_plate_iron", "items/metal_plate_iron");
        map.putTex("item/metal_plate_lead", "items/metal_plate_lead");
        map.putTex("item/metal_plate_nickel", "items/metal_plate_nickel");
        map.putTex("item/metal_plate_silver", "items/metal_plate_silver");
        map.putTex("item/metal_plate_steel", "items/metal_plate_steel");
        map.putTex("item/metal_plate_uranium", "items/metal_plate_uranium");
        /*
        * Raw Ores... Maybe one day
        * */
        map.putTex("item/minecart_metalbarrel", "items/minecart_metalbarrel");
        map.putTex("item/minecart_reinforcedcrate", "items/minecart_reinforcedcrate");
        map.putTex("item/minecart_woodenbarrel", "items/minecart_woodenbarrel");
        map.putTex("item/minecart_woodencrate", "items/minecart_woodencrate");
        map.putTex("item/mold_bullet_casing", "items/mold_bullet_casing");
        map.putTex("item/mold_gear", "items/mold_gear");
        map.putTex("item/mold_packing_4", "items/mold_packing_4");
        map.putTex("item/mold_packing_9", "items/mold_packing_9");
        map.putTex("item/mold_plate", "items/mold_plate");
        map.putTex("item/mold_rod", "items/mold_rod");
        map.putTex("item/mold_unpacking", "items/mold_unpacking");
        map.putTex("item/mold_wire", "items/mold_wire");
        map.putTex("item/powerpack", "items/powerpack");
        map.putTex("item/railgun", "items/railgun");
        map.putTex("item/revolver_speedloader", "items/revolver_speedloader");
        map.putTex("item/rockcutter", "items/rockcutter");
        map.putTex("item/rockcutter_blade", "items/rockcutter_blade");
        map.putTex("item/sawblade", "items/sawblade");
        map.putTex("item/sawblade_blade", "items/sawblade_blade");
        map.putTex("item/seed_hemp", "items/seed_hemp");
        map.putTex("item/shader_0", "items/shader_0");
        map.putTex("item/shader_1", "items/shader_1");
        map.putTex("item/shader_2", "items/shader_2");
        map.putTex("item/shader_bag", "items/shader_bag");
        map.putTexNoPng("item/shader_bag.png.mcmeta", "items/shader_bag.png.mcmeta");
        map.putTex("item/shader_slot", "items/shader_slot");
        map.putTex("item/shield", "items/shield");
        map.putTex("item/skyhook", "items/skyhook");
        map.putTex("item/survey_tools", "items/survey_tools");
        map.putTex("item/tool_axe_steel", "items/tool_axe_steel");
        map.putTex("item/tool_hammer", "items/tool_hammer");
        map.putTex("item/tool_hoe_steel", "items/tool_hoe_steel");
        map.putTex("item/tool_manual", "items/tool_manual");
        map.putTex("item/tool_pickaxe_steel", "items/tool_pickaxe_steel");
        map.putTex("item/tool_screwdriver", "items/tool_screwdriver");
        map.putTex("item/tool_shovel_steel", "items/tool_shovel_steel");
        map.putTex("item/tool_sword_steel", "items/tool_sword_steel");
        map.putTex("item/tool_voltmeter", "items/tool_voltmeter");
        map.putTex("item/tool_wirecutter", "items/tool_wirecutter");
        map.putTex("item/toolbox", "items/toolbox");
        map.putTex("item/toolupgrade_buzzsaw_spareblades", "items/toolupgrade_buzzsaw_spareblades");
        map.putTex("item/toolupgrade_chemthrower_focus", "items/toolupgrade_chemthrower_focus");
        map.putTex("item/toolupgrade_chemthrower_multitank", "items/toolupgrade_chemthrower_multitank");
        map.putTex("item/toolupgrade_drill_capacity", "items/toolupgrade_drill_capacity");
        map.putTex("item/toolupgrade_drill_damage", "items/toolupgrade_drill_damage");
        map.putTex("item/toolupgrade_drill_fortune", "items/toolupgrade_drill_fortune");
        map.putTex("item/toolupgrade_drill_lube", "items/toolupgrade_drill_lube");
        map.putTex("item/toolupgrade_drill_waterproof", "items/toolupgrade_drill_waterproof");
        map.putTex("item/toolupgrade_powerpack_antenna", "items/toolupgrade_powerpack_antenna");
        map.putTex("item/toolupgrade_powerpack_induction", "items/toolupgrade_powerpack_induction");
        map.putTex("item/toolupgrade_powerpack_magnet", "items/toolupgrade_powerpack_magnet");
        map.putTex("item/toolupgrade_powerpack_tesla", "items/toolupgrade_powerpack_tesla");
        map.putTex("item/toolupgrade_railgun_capacitors", "items/toolupgrade_railgun_capacitors");
        map.putTex("item/toolupgrade_railgun_scope", "items/toolupgrade_railgun_scope");
        map.putTex("item/toolupgrade_revolver_bayonet", "items/toolupgrade_revolver_bayonet");
        map.putTex("item/toolupgrade_revolver_electro", "items/toolupgrade_revolver_electro");
        map.putTex("item/toolupgrade_revolver_magazine", "items/toolupgrade_revolver_magazine");
        map.putTex("item/toolupgrade_shield_flash", "items/toolupgrade_shield_flash");
        map.putTex("item/toolupgrade_shield_magnet", "items/toolupgrade_shield_magnet");
        map.putTex("item/toolupgrade_shield_shock", "items/toolupgrade_shield_shock");
        map.putTex("item/toolupgrade_skyhook_insulation", "items/toolupgrade_skyhook_insulation");
        map.putTex("item/toolupgrade_skyhook_mace", "items/toolupgrade_skyhook_mace");
        map.putTex("item/toolupgrade_skyhook_slope", "items/toolupgrade_skyhook_slope");
        map.putTex("item/white", "items/white");
        map.putTex("item/wirecoil_copper", "items/wirecoil_copper");
        map.putTex("item/wirecoil_copper_ins", "items/wirecoil_copper_ins");
        map.putTex("item/wirecoil_electrum", "items/wirecoil_electrum");
        map.putTex("item/wirecoil_electrum_ins", "items/wirecoil_electrum_ins");
        map.putTex("item/wirecoil_redstone", "items/wirecoil_redstone");
        map.putTex("item/wirecoil_steel", "items/wirecoil_steel");
        map.putTex("item/wirecoil_structure_rope", "items/wirecoil_structure_rope");
        map.putTex("item/wirecoil_structure_steel", "items/wirecoil_structure_steel");

        // GUI
        map.putTex("gui/workbench");

        AssetMoverAPI.fromCurseForgeMod("231951", "5620787", map);
        installBrokenPNGs();
    }

    /**
     * Installs broken textures from 1.12.2 instead
     **/
    @SideOnly(Side.CLIENT)
    private static void installBrokenPNGs() {
//        File textures = new File(Launch.minecraftHome, "assetmover/assets/immersiveengineering/textures");
    }

    private static void install(File path, String urlStr) {
        if (path.exists()) return;
        path.getParentFile().mkdirs();

        try {
            URL url = new URL(urlStr);
            OutputStream os = Files.newOutputStream(path.toPath());

            URLConnection connection = url.openConnection();
            connection.setReadTimeout(1000);
            connection.setConnectTimeout(1000);

            byte[] bytes = new byte[connection.getContentLength()];
            InputStream stream = connection.getInputStream();

            stream.read(bytes);
            os.write(bytes);

            os.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class TextureMap extends Object2ObjectOpenHashMap<String, String> {
        private void putTex(String s1, String s2) {
            s1 = "assets/immersiveengineering/textures/" + s1 + ".png";
            s2 = "assets/bpcatacombs/textures/" + s2 + ".png";
            put(s1, s2);
        }

        private void putTex(String name) {
            name = "assets/immersiveengineering/textures/" + name + ".png";
            String name2 = "assets/bpcatacombs/textures/" + name;
            put(name, name2);
        }

        private void putTexNoPng(String name, String name2) {
            name = "assets/immersiveengineering/textures/" + name;
            name2 = "assets/bpcatacombs/textures/" + name2;
            put(name, name2);
        }
    }
}
