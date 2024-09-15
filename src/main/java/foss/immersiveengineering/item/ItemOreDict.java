package foss.immersiveengineering.item;

import foss.immersiveengineering.api.oredict.OredictProvider;
import net.minecraft.item.Item;
import net.minecraftforge.oredict.OreDictionary;

public class ItemOreDict extends Item implements OredictProvider {

    private final String oreName;

    public ItemOreDict(String oreName) {
        this.oreName = oreName;
    }

    @Override
    public void registerOreEntries() {
        OreDictionary.registerOre(oreName, this);
    }
}
