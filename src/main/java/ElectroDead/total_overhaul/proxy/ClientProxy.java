package ElectroDead.total_overhaul.proxy;

import ElectroDead.total_overhaul.init.ModBlocks;
import ElectroDead.total_overhaul.init.ModItems;

public class ClientProxy implements CommonProxy{

	@Override
	public void init() {
		ModItems.registerRenders();
		ModBlocks.registerRenders();
	}

}
