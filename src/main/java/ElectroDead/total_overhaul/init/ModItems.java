package ElectroDead.total_overhaul.init;

import ElectroDead.total_overhaul.items.ItemButt;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ModItems {

	//Items
	public static Item butt;
	
	public static void init() {
		butt = new ItemButt();
	}
	
	public static void register() {
		
	}
	
	public static void registerRenders() {
		registerRender(butt);
	}
	
	private static void registerRender(Item item) {
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}
	
	
	@SubscribeEvent
	public void registerItems(RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(butt);
	}
}
