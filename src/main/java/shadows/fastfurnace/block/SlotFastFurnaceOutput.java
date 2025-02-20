package shadows.fastfurnace.block;

import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.SlotFurnaceOutput;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.FMLCommonHandler;
import shadows.fastfurnace.FastFurnace;

public class SlotFastFurnaceOutput extends SlotFurnaceOutput {

    public SlotFastFurnaceOutput(EntityPlayer p_i45793_1_, IInventory p_i45793_2_, int p_i45793_3_, int p_i45793_4_, int p_i45793_5_) {
        super(p_i45793_1_, p_i45793_2_, p_i45793_3_, p_i45793_4_, p_i45793_5_);
    }
    @Override
    protected void onCrafting(ItemStack p_75208_1_) {
        if (!this.player.world.isRemote) {
            final TileFastFurnace inv = (TileFastFurnace) this.inventory;
            int i = FastFurnace.getRandomXp(inv.xpStored);
            while(i > 0) {
                int k = EntityXPOrb.getXPSplit(i);
                i -= k;
                this.player.world.spawnEntity(new EntityXPOrb(this.player.world, this.player.posX, this.player.posY + (double)0.5F, this.player.posZ + (double)0.5F, k));
            }
            inv.xpStored=0;
        }
        this.removeCount = 0;
        FMLCommonHandler.instance().firePlayerSmeltedEvent(this.player, p_75208_1_);
    }
}
