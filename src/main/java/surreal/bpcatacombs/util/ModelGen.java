package surreal.bpcatacombs.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ModelGen {

    public static void main(String[] args) {
        model("item/treated_stick", "item/material_stick_treated");
        model("item/iron_rod", "item/material_stick_iron");
        model("item/steel_rod", "item/material_stick_steel");
        model("item/aluminium_rod", "item/material_stick_aluminium");

        model("item/hemp_fiber", "item/material_hemp_fiber");
        model("item/tough_fabric", "item/material_hemp_fabric");
        model("item/ersatz_leather", "item/material_ersatz_leather");
        model("item/slag", "item/material_slag");

        model("item/iron_component", "item/material_component_iron");
        model("item/steel_component", "item/material_component_steel");
        model("item/electric_component", "item/material_component_electronic");
        model("item/adv_electric_component", "item/material_component_electronic_adv");

        model("item/coal_coke", "item/material_coal_coke");
        model("item/coke_dust", "item/material_dust_coke");
        model("item/graphite_dust", "item/material_dust_hop_graphite");
        model("item/graphite_ingot", "item/material_ingot_hop_graphite");

        model("item/copper_wire", "item/material_wire_copper");
        model("item/electrum_wire", "item/material_wire_electrum");
        model("item/aluminium_wire", "item/material_wire_aluminium");
        model("item/steel_wire", "item/material_wire_steel");
        model("item/lead_wire", "item/material_wire_lead");

        model("item/aluminium_ingot", "item/metal_ingot_aluminium");
        model("item/constantan_ingot", "item/metal_ingot_constantan");
        model("item/copper_ingot", "item/metal_ingot_copper");
        model("item/electrum_ingot", "item/metal_ingot_electrum");
        model("item/gold_ingot", "item/metal_ingot_gold");
        model("item/iron_ingot", "item/metal_ingot_iron");
        model("item/lead_ingot", "item/metal_ingot_lead");
        model("item/nickel_ingot", "item/metal_ingot_nickel");
        model("item/silver_ingot", "item/metal_ingot_silver");
        model("item/steel_ingot", "item/metal_ingot_steel");
        model("item/uranium_ingot", "item/metal_ingot_uranium");

        model("item/aluminium_nugget", "item/metal_nugget_aluminium");
        model("item/constantan_nugget", "item/metal_nugget_constantan");
        model("item/copper_nugget", "item/metal_nugget_copper");
        model("item/electrum_nugget", "item/metal_nugget_electrum");
        model("item/gold_nugget", "item/metal_nugget_gold");
        model("item/iron_nugget", "item/metal_nugget_iron");
        model("item/lead_nugget", "item/metal_nugget_lead");
        model("item/nickel_nugget", "item/metal_nugget_nickel");
        model("item/silver_nugget", "item/metal_nugget_silver");
        model("item/steel_nugget", "item/metal_nugget_steel");
        model("item/uranium_nugget", "item/metal_nugget_uranium");

        model("item/aluminium_plate", "item/metal_plate_aluminium");
        model("item/constantan_plate", "item/metal_plate_constantan");
        model("item/copper_plate", "item/metal_plate_copper");
        model("item/electrum_plate", "item/metal_plate_electrum");
        model("item/gold_plate", "item/metal_plate_gold");
        model("item/iron_plate", "item/metal_plate_iron");
        model("item/lead_plate", "item/metal_plate_lead");
        model("item/nickel_plate", "item/metal_plate_nickel");
        model("item/silver_plate", "item/metal_plate_silver");
        model("item/steel_plate", "item/metal_plate_steel");
        model("item/uranium_plate", "item/metal_plate_uranium");

        model("item/aluminium_dust", "item/metal_dust_aluminium");
        model("item/constantan_dust", "item/metal_dust_constantan");
        model("item/copper_dust", "item/metal_dust_copper");
        model("item/electrum_dust", "item/metal_dust_electrum");
        model("item/gold_dust", "item/metal_dust_gold");
        model("item/iron_dust", "item/metal_dust_iron");
        model("item/lead_dust", "item/metal_dust_lead");
        model("item/nickel_dust", "item/metal_dust_nickel");
        model("item/quartz_dust", "item/metal_dust_quartz");
        model("item/silver_dust", "item/metal_dust_silver");
        model("item/steel_dust", "item/metal_dust_steel");
        model("item/uranium_dust", "item/metal_dust_uranium");

        model("item/hammer", "item/tool_hammer");
        model("item/cutter", "item/tool_wirecutter");
        model("item/screwdriver", "item/tool_screwdriver");
        model("item/manual", "item/tool_manual");

        model("item/steel_pickaxe", "item/tool_pickaxe_steel");
        model("item/steel_axe", "item/tool_axe_steel");
        model("item/steel_shovel", "item/tool_shovel_steel");
        model("item/steel_hoe", "item/tool_hoe_steel");
        model("item/steel_sword", "item/tool_sword_steel");
    }

    private static void model(String path, String... textures) {
        File file = new File("src/main/resources/assets/bpcatacombs/models", path + ".json");
        file.getParentFile().mkdirs();

        Gson gson = new GsonBuilder().disableHtmlEscaping().setPrettyPrinting().create();
        JsonObject object = new JsonObject();
        JsonObject texturesObj = new JsonObject();

        object.addProperty("parent", "item/generated");

        for (int i = 0; i < textures.length; i++) {
            texturesObj.addProperty("layer" + i, "immersiveengineering:" + textures[i]);
        }

        object.add("textures", texturesObj);

        try {
            FileWriter writer = new FileWriter(file);
            writer.write(gson.toJson(object));
            writer.close();
        }
        catch (IOException ignored) {}
    }
}
