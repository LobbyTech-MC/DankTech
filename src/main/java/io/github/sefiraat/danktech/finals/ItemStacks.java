package io.github.sefiraat.danktech.finals;

import io.github.sefiraat.danktech.DankTech;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import static io.github.sefiraat.danktech.finals.ItemDetails.getDankCellName;
import static io.github.sefiraat.danktech.finals.ItemDetails.getDankNameBold;
import static io.github.sefiraat.danktech.finals.Materials.getDankCellMaterial;
import static io.github.sefiraat.danktech.finals.Materials.getDankMaterial;

public class ItemStacks {

    private ItemStacks() {
        throw new IllegalStateException("Utility class");
    }

    public static ItemStack getCell(int level, DankTech plugin) {
        ItemStack cell = new ItemStack(getDankCellMaterial(level));
        ItemMeta m = cell.getItemMeta();
        m.setDisplayName(getDankCellName(level));
        PersistentDataContainer c = m.getPersistentDataContainer();
        NamespacedKey key = new NamespacedKey(plugin,"dank");
        c.set(key, PersistentDataType.INTEGER, 1);
        cell.setItemMeta(m);
        return cell;
    }

    public static ItemStack getShallowDank(int level) {
        ItemStack dank = new ItemStack(getDankMaterial(level));
        ItemMeta m = dank.getItemMeta();
        m.setDisplayName(getDankNameBold(level));
        dank.setItemMeta(m);
        return dank;
    }

}
