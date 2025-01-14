package surreal.bpcatacombs.internal.registration;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.registries.IForgeRegistryEntry;
import surreal.bpcatacombs.Tags;

import java.util.ArrayList;
import java.util.List;

/**
 * Registry classes objectified so we can discard the list after it's job is done.
 * @see RegistryManager
 **/
public abstract class Registry<T extends IForgeRegistryEntry<T>> {

    protected final List<T> list;

    public Registry(int startSize) {
        this.list = new ArrayList<>(startSize);
    }

    public Registry() {
        this(8);
    }

    protected void preInit(FMLPreInitializationEvent event) {}
    protected void init(FMLInitializationEvent event) {}
    protected void postInit(FMLPostInitializationEvent event) {}

    protected void register(T entry, String name) {
        this.register(entry, new ResourceLocation(Tags.MOD_ID, name));
    }

    protected void register(T entry, ResourceLocation name) {
        this.register(entry.setRegistryName(name));
    }

    protected void register(T entry) {
        this.list.add(entry);
    }

    protected void registerEntries(RegistryEvent.Register<T> event) {
        this.list.forEach(event.getRegistry()::register);
    }
}
