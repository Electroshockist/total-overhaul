package ElectroDead.total_overhaul.init;

import ElectroDead.total_overhaul.blocks.BlockGray;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ModBlocks {
	
	public static Block gray;
	
	public static void init() {
		gray = new BlockGray();
	}
	
	public static void registerRenders() {
		registerRender(gray);
	}
	
	@SubscribeEvent
	public void registerBlocks(RegistryEvent.Register<Block> event) {
		event.getRegistry().registerAll(	
			gray
		);
	}
	
	//blocks still need to be registered by both name and to an item. so far it dosent work but it will run
	
	private static void registerRender(Block block) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));
	}
}

