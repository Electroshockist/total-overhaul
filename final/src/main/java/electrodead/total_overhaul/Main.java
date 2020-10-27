package electrodead.total_overhaul;

import electrodead.total_overhaul.handlers.CustomEventHandler;
import electrodead.total_overhaul.proxy.CommonProxy;
import electrodead.total_overhaul.util.Reference;
import electrodead.total_overhaul.visual_effects.VoidFog;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MOD_ID, name  = Reference.NAME, version = Reference.VERSION)
public class Main {
	@Instance
	public static Main instance;
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.COMMON_PROXY_CLASS)
	public static CommonProxy proxy;
	
	@EventHandler
	public static void PreInit(FMLPreInitializationEvent event){
		//GameRegistry.registerWorldGenerator(new WorldGen(), 3);		
		
	}
	
	@EventHandler
	public static void init(FMLInitializationEvent event){
		//ModRecipes.init();		
	}
	
	@EventHandler
	public static void PostInit(FMLPostInitializationEvent event){
		MinecraftForge.EVENT_BUS.register(new CustomEventHandler());
		MinecraftForge.EVENT_BUS.register(new VoidFog());
				
	}

}
