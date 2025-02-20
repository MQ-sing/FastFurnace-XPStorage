package shadows.fastfurnace.block;

import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ContainerFurnace;
import net.minecraft.inventory.IInventory;

public class ContainerFastFurnace extends ContainerFurnace {

    public ContainerFastFurnace(InventoryPlayer p_i45794_1_, IInventory p_i45794_2_) {
        super(p_i45794_1_, p_i45794_2_);
        inventorySlots.set(2,new SlotFastFurnaceOutput(p_i45794_1_.player, p_i45794_2_, 2, 116, 35));
    }

}
