package ElectroDead.total_overhaul.blocks;

import ElectroDead.total_overhaul.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockGray extends Block{
	public BlockGray() {
		super(Material.ROCK);
		setUnlocalizedName(Reference.TO_Blocks.GRAY.getUnlocalizedName());
		setRegistryName(Reference.TO_Blocks.GRAY.getRegistryName());
	}
}
