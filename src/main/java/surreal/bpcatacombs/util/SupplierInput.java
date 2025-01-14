package surreal.bpcatacombs.util;

@FunctionalInterface
public interface SupplierInput<I, O> {
    O get(I input);
}
