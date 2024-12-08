package surreal.bpcatacombs.client.resource;

import com.cleanroommc.assetmover.AssetMoverAPI;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.minecraft.launchwrapper.Launch;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;

public class BPCTextures {

    @SideOnly(Side.CLIENT)
    public static void initTextures() {
        TextureMap map = new TextureMap();

        // Blocks
        map.putTex("block/wooden_device/workbench");
        map.putTex("block/multiblocks/autoworkbench_blueprint");

        map.putTex("block/wooden_decoration/treated_wood");

        // Items
        map.putTex("item/material_circuit_board");
        map.putTex("item/material_coal_coke");
        map.putTex("item/material_component_electronic");
        map.putTex("item/material_component_electronic_adv");
//        map.putTex("item/material_component_iron"); Not a proper PNG
        map.putTex("item/material_component_steel");
        map.putTex("item/material_dust_coke");
        map.putTex("item/material_dust_hop_graphite");
        map.putTex("item/material_dust_saltpeter");
        map.putTex("item/material_dust_sulfur");
        map.putTex("item/material_dust_wood");
        map.putTex("item/material_electron_tube");
        map.putTex("item/material_ersatz_leather");
        map.putTex("item/material_gunpart_barrel");
        map.putTex("item/material_gunpart_drum");
        map.putTex("item/material_gunpart_hammer");
        map.putTex("item/material_hemp_fabric");
        map.putTex("item/material_hemp_fiber");
        map.putTex("item/material_ingot_hop_graphite");
        map.putTex("item/material_light_bulb");
        map.putTex("item/material_plate_duroplast");
        map.putTex("item/material_slag");
        map.putTex("item/material_stick_aluminum", "item/material_stick_aluminium");
        map.putTex("item/material_stick_iron");
        // item/material_stick_netherite
        map.putTex("item/material_stick_steel");
        map.putTex("item/material_stick_treated");
        map.putTex("item/material_waterwheel_segment");
        map.putTex("item/material_windmill_blade");
        map.putTex("item/material_windmill_sail");
        map.putTex("item/material_wire_aluminum", "item/material_wire_aluminium");
        map.putTex("item/material_wire_copper");
        map.putTex("item/material_wire_electrum");
        map.putTex("item/material_wire_lead");
//        map.putTex("item/material_wire_steel"); Not a proper PNG
        map.putTex("item/material_wooden_grip");

        map.putTex("item/metal_dust_aluminum", "item/metal_dust_aluminium");
        map.putTex("item/metal_dust_constantan");
        map.putTex("item/metal_dust_copper");
        map.putTex("item/metal_dust_electrum");
        map.putTex("item/metal_dust_gold");
        map.putTex("item/metal_dust_iron");
        map.putTex("item/metal_dust_lead");
        map.putTex("item/metal_dust_nickel");
        map.putTex("item/metal_dust_quartz");
        map.putTex("item/metal_dust_silver");
        map.putTex("item/metal_dust_steel");
        map.putTex("item/metal_dust_uranium");

        map.putTex("item/metal_ingot_aluminum", "item/metal_ingot_aluminium");
        map.putTex("item/metal_ingot_constantan");
        map.putTex("item/metal_ingot_copper");
        map.putTex("item/metal_ingot_electrum");
        map.putTex("item/metal_ingot_lead");
        map.putTex("item/metal_ingot_nickel");
        map.putTex("item/metal_ingot_silver");
        map.putTex("item/metal_ingot_steel");
        map.putTex("item/metal_ingot_uranium");

        map.putTex("item/metal_nugget_aluminum", "item/metal_nugget_aluminium");
        map.putTex("item/metal_nugget_constantan");
        map.putTex("item/metal_nugget_copper");
        map.putTex("item/metal_nugget_electrum");
        map.putTex("item/metal_nugget_lead");
        map.putTex("item/metal_nugget_nickel");
        map.putTex("item/metal_nugget_silver");
        map.putTex("item/metal_nugget_steel");
        map.putTex("item/metal_nugget_uranium");

        map.putTex("item/metal_plate_aluminum", "item/metal_plate_aluminium");
        map.putTex("item/metal_plate_constantan");
        map.putTex("item/metal_plate_copper");
        map.putTex("item/metal_plate_electrum");
        map.putTex("item/metal_plate_gold");
        map.putTex("item/metal_plate_iron");
        map.putTex("item/metal_plate_lead");
        map.putTex("item/metal_plate_nickel");
        map.putTex("item/metal_plate_silver");
        map.putTex("item/metal_plate_steel");
        map.putTex("item/metal_plate_uranium");

        map.putTex("item/minecart_metalbarrel");
        map.putTex("item/minecart_reinforcedcrate");
        map.putTex("item/minecart_woodenbarrel");
        map.putTex("item/minecart_woodencrate");

        map.putTex("item/mold_bullet_casing");
        map.putTex("item/mold_gear");
        map.putTex("item/mold_packing_4");
        map.putTex("item/mold_packing_9");
        map.putTex("item/mold_plate");
        map.putTex("item/mold_rod");
        map.putTex("item/mold_unpacking");
        map.putTex("item/mold_wire");

        map.putTex("item/powerpack");
        map.putTex("item/railgun");
        map.putTex("item/revolver_speedloader");
        map.putTex("item/rockcutter");
        map.putTex("item/rockcutter_blade");
        map.putTex("item/sawblade");
        map.putTex("item/sawblade_blade");
        map.putTex("item/seed_hemp");
        map.putTex("item/shader_0");
        map.putTex("item/shader_1");
        map.putTex("item/shader_2");
        map.putTex("item/shader_bag");
//        map.putTexNoPng("item/shader_bag.png.mcmeta");
        map.putTex("item/shader_slot");
        map.putTex("item/shield");
        map.putTex("item/skyhook");
        map.putTex("item/survey_tools");

        map.putTex("item/tool_pickaxe_steel");
        map.putTex("item/tool_axe_steel");
        map.putTex("item/tool_shovel_steel");
        map.putTex("item/tool_hoe_steel");
        map.putTex("item/tool_sword_steel");

        map.putTex("item/tool_hammer");
        map.putTex("item/tool_manual");
        map.putTex("item/tool_screwdriver");
        map.putTex("item/tool_voltmeter");
        map.putTex("item/tool_wirecutter");

        map.putTex("item/toolbox");

        // CONTINUE ----- toolupgrade.*

        // GUI
        map.putTex("gui/workbench");

        AssetMoverAPI.fromCurseForgeMod("231951", "5488671", map);
        installBrokenPNGs();
    }

    /**
     * Installs broken textures from 1.12.2 instead
     **/
    @SideOnly(Side.CLIENT)
    private static void installBrokenPNGs() {
        File textures = new File(Launch.minecraftHome, "assetmover/assets/immersiveengineering/textures");

        install(new File(textures, "item/material_component_iron.png"), "https://raw.githubusercontent.com/BluSunrize/ImmersiveEngineering/1.13pre/src/main/resources/assets/immersiveengineering/textures/items/material_component_iron.png");
        install(new File(textures, "item/material_wire_steel.png"), "https://raw.githubusercontent.com/BluSunrize/ImmersiveEngineering/1.13pre/src/main/resources/assets/immersiveengineering/textures/items/material_wire_steel.png");
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
            s2 = "assets/immersiveengineering/textures/" + s2 + ".png";
            put(s1, s2);
        }

        private void putTex(String name) {
            name = "assets/immersiveengineering/textures/" + name + ".png";
            put(name, name);
        }

        private void putTexNoPng(String name) {
            name = "assets/immersiveengineering/textures/" + name;
            put(name, name);
        }
    }
}
