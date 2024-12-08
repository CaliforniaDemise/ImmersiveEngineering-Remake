package surreal.bpcatacombs.api.client.model;

/**
 * Used for registering models.
 * Can be used on items and blocks.
 **/
public interface ModelProvider {
    default void registerModels() {
        throw new AssertionError("Model provider isn't item or block");
    }
}
