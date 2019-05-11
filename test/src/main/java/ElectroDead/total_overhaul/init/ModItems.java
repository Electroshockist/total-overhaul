package ElectroDead.total_overhaul.init;

import ElectroDead.total_overhaul.items.ItemButt;
import ElectroDead.total_overhaul.items.ItemOrange;
import ElectroDead.total_overhaul.items.ItemTissue;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ModItems {

	//Items
	public static Item butt;
	public static Item orange;
	public static Item tissue;	
	
	public static void init() {
		butt = new ItemButt();
		orange = new ItemOrange();
		tissue = new ItemTissue();
	}
	
	public static void registerRenders() {
		registerRender(butt);
		registerRender(orange);
		registerRender(tissue);
	}
	
	@SubscribeEvent
	public void registerItems(RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(	
			butt,
			orange,
			tissue
		);
	}
	
	private static void registerRender(Item item) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}
}