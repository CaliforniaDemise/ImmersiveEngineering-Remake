package surreal.bpcatacombs.client.resource;

import com.cleanroommc.assetmover.AssetMoverAPI;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BPCModels {

    @SideOnly(Side.CLIENT)
    public static void initModels() {
        ModelMap map = new ModelMap();

        // Blocks
        map.putModel("block/wooden_device/workbench.mtl");
        map.putModel("block/wooden_device/workbench.json.obj.ie", "block/wooden_device/workbench.obj");

        AssetMoverAPI.fromCurseForgeMod("231951", "5488671", map);
    }

    private static class ModelMap extends Object2ObjectOpenHashMap<String, String> {
        public void putModel(String s, String s2) {
           s =  "assets/immersiveengineering/models/" + s;
           s2 = "assets/immersiveengineering/models/" + s2;
           put(s, s2);
        }

        public void putModel(String name) {
            name = "assets/immersiveengineering/models/" + name;
            put(name, name);
        }
    }
}
