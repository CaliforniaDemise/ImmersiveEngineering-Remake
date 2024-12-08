package surreal.bpcatacombs.client;

import net.minecraftforge.fml.relauncher.SideOnly;
import surreal.bpcatacombs.client.resource.BPCModels;
import surreal.bpcatacombs.client.resource.BPCTextures;
import surreal.bpcatacombs.item.BPCItems;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.fml.common.event.FMLConstructionEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;

@SuppressWarnings("unused")
@SideOnly(Side.CLIENT)
public class ClientHandler {

    public static void construction(FMLConstructionEvent event) {
        BPCTextures.initTextures();
        BPCModels.initModels();
    }

    public static void preInit(FMLPreInitializationEvent event) {
        OBJLoader.INSTANCE.addDomain("immersiveengineering");
    }

    public static void init(FMLInitializationEvent event) {
    }

    public static void registerModels(ModelRegistryEvent event) {
        BPCItems.registerModels(event);
    }
}