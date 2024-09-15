package foss.immersiveengineering.item;

import com.google.common.collect.Multimap;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.*;
import net.minecraftforge.oredict.OreDictionary;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

public class ItemToolSteel {

    public static class Pickaxe extends ItemPickaxe {

        public Pickaxe() {
            super(ToolMaterial.DIAMOND);
            setMaxDamage(641);
            this.efficiency = 7F;
        }

        @Override
        public int getItemEnchantability(@Nonnull ItemStack stack) {
            return 10;
        }

        // Oh fuck, I hate Ore Dictionary. I can see how slow it is.
        @Override
        @ParametersAreNonnullByDefault
        public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
            if (repair.getItem() == IEItems.STEEL_INGOT) return true;
            int oreIngotSteel = OreDictionary.getOreID("ingotSteel");
            int[] stackOres = OreDictionary.getOreIDs(repair);
            for (int oreId : stackOres) {
                if (oreId == oreIngotSteel) return true;
            }
            return false;
        }
    }

    public static class Axe extends ItemAxe {

        public Axe() {
            super(ToolMaterial.DIAMOND);
            setMaxDamage(641);
            this.efficiency = 7F;
        }

        @Override
        public int getItemEnchantability(@Nonnull ItemStack stack) {
            return 10;
        }

        // Oh fuck, I hate Ore Dictionary. I can see how slow it is.
        @Override
        @ParametersAreNonnullByDefault
        public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
            if (repair.getItem() == IEItems.STEEL_INGOT) return true;
            int oreIngotSteel = OreDictionary.getOreID("ingotSteel");
            int[] stackOres = OreDictionary.getOreIDs(repair);
            for (int oreId : stackOres) {
                if (oreId == oreIngotSteel) return true;
            }
            return false;
        }
    }

    public static class Shovel extends ItemSpade {

        public Shovel() {
            super(ToolMaterial.DIAMOND);
            setMaxDamage(641);
            this.efficiency = 7F;
        }

        @Override
        public int getItemEnchantability() {
            return 10;
        }

        // Oh fuck, I hate Ore Dictionary. I can see how slow it is.
        @Override
        @ParametersAreNonnullByDefault
        public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
            if (repair.getItem() == IEItems.STEEL_INGOT) return true;
            int oreIngotSteel = OreDictionary.getOreID("ingotSteel");
            int[] stackOres = OreDictionary.getOreIDs(repair);
            for (int oreId : stackOres) {
                if (oreId == oreIngotSteel) return true;
            }
            return false;
        }
    }

    public static class Hoe extends ItemHoe {

        public Hoe() {
            super(ToolMaterial.DIAMOND);
            setMaxDamage(641);
        }

        @Override
        public int getItemEnchantability(@Nonnull ItemStack stack) {
            return 10;
        }

        // Oh fuck, I hate Ore Dictionary. I can see how slow it is.
        @Override
        @ParametersAreNonnullByDefault
        public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
            if (repair.getItem() == IEItems.STEEL_INGOT) return true;
            int oreIngotSteel = OreDictionary.getOreID("ingotSteel");
            int[] stackOres = OreDictionary.getOreIDs(repair);
            for (int oreId : stackOres) {
                if (oreId == oreIngotSteel) return true;
            }
            return false;
        }

        // They hardcoded attack speed. Kek.
        @Nonnull
        public Multimap<String, AttributeModifier> getItemAttributeModifiers(@Nonnull EntityEquipmentSlot equipmentSlot) {
            Multimap<String, AttributeModifier> multimap = super.getItemAttributeModifiers(equipmentSlot);
            multimap.removeAll(SharedMonsterAttributes.ATTACK_SPEED.getName());

            if (equipmentSlot == EntityEquipmentSlot.MAINHAND) {
                multimap.put(SharedMonsterAttributes.ATTACK_SPEED.getName(), new AttributeModifier(ATTACK_SPEED_MODIFIER, "Weapon modifier", 2.0F, 0));
            }

            return multimap;
        }
    }

    public static class Sword extends ItemSword {

        public Sword() {
            super(ToolMaterial.DIAMOND);
        }
    }
}
