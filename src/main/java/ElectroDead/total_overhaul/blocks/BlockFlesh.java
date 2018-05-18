package ElectroDead.total_overhaul.blocks;

import ElectroDead.total_overhaul.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockFlesh extends Block {

	public BlockFlesh() {
		super(Material.SPONGE);	
		setUnlocalizedName(Reference.TO_Items.BUTT.getUnlocalizedName());
		setRegistryName(Reference.TO_Items.BUTT.getRegistryName());
	}
}
