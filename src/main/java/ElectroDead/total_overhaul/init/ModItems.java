package ElectroDead.total_overhaul.init;

import ElectroDead.total_overhaul.items.ItemButt;
import ElectroDead.total_overhaul.items.ItemOrange;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ModItems {

	//Items
	public static Item butt;
	public static Item orange;
	
	public static void init() {
		butt = new ItemButt();
		orange = new ItemOrange();
	}
	
	public static void registerRenders() {
		registerRender(butt);
		registerRender(orange);
	}
	
	@SubscribeEvent
	public void registerItems(RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(	
			butt,
			orange
		);
	}
	
	private static void registerRender(Item item) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(item.getUnlocalizedName(), "inventory"));
	}
}