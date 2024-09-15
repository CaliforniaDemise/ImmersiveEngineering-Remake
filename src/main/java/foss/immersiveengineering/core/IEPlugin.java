package foss.immersiveengineering.core;

import com.google.common.collect.ImmutableList;
import com.google.common.eventbus.EventBus;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.minecraftforge.fml.common.DummyModContainer;
import net.minecraftforge.fml.common.LoadController;
import net.minecraftforge.fml.common.ModMetadata;
import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;

import javax.annotation.Nullable;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;

@IFMLLoadingPlugin.Name("ImmersiveEngineering")
@IFMLLoadingPlugin.MCVersion("1.12.2")
@IFMLLoadingPlugin.SortingIndex(Integer.MAX_VALUE - 100)
public class IEPlugin implements IFMLLoadingPlugin {
    @Override
    public String[] getASMTransformerClass() {
        return null;
    }

    @Override
    public String getModContainerClass() {
        return null;
       // return "foss.immersiveengineering.core.IEPlugin$ModContainer";
    }

    @Nullable
    @Override
    public String getSetupClass() {
        return null;
    }

    @Override
    public void injectData(Map<String, Object> data) {

    }

    @Override
    public String getAccessTransformerClass() {
        return null;
    }

    @SuppressWarnings("unused")
    public static class ModContainer extends DummyModContainer {

        public ModContainer() {
            super(new ModMetadata());
            ModMetadata metadata = getMetadata();
            handleModInfo(metadata);
        }

        @Override
        public boolean registerBus(EventBus bus, LoadController controller) {
            bus.register(this);
            return true;
        }

        private static void handleModInfo(ModMetadata metadata) {
            InputStream stream = IEPlugin.class.getResourceAsStream("./mcmod.info");
            assert stream != null;
            InputStreamReader reader = new InputStreamReader(stream);

            Gson gson = new Gson();
            JsonObject object = gson.fromJson(reader, JsonObject.class);

            metadata.modId = object.get("modid").getAsString();
            metadata.name = object.get("name").getAsString();
            metadata.description = object.get("description").getAsString();
            metadata.version = object.get("version").getAsString();
            metadata.url = object.get("url").getAsString();
            metadata.updateJSON = object.get("updateUrl").getAsString();
            ImmutableList.Builder<String> builder = new ImmutableList.Builder<>();
            for (JsonElement element : object.getAsJsonArray("authorList")) {
                builder.add(element.getAsString());
            }
            metadata.authorList = builder.build();
            metadata.logoFile = object.get("logoFile").getAsString();
        }
    }
}
