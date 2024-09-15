package foss.immersiveengineering.api.client.model;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;

import java.util.Objects;

/**
 * Used for registering models.
 * Can be used on items and blocks.
 **/
public interface ModelProvider {
    default void registerModels() {
        throw new AssertionError("Model provider isn't item or block");
    }
}
