package ElectroDead.total_overhaul;

public class Reference {
	
	public static final String MOD_ID = "to";
	public static final String NAME = "Total Overhaul";
	//Mod version.bugfix version
	public static final String VERSION = "1.0";
	public static final String ACCEPTED_VERSION = "[1.12]";
	
	public static final String CLIENT_PROXY_CLASS = "ElectroDead.total_overhaul.proxy.ClientProxy";
	public static final String SERVER_PROXY_CLASS = "ElectroDead.total_overhaul.proxy.ServerProxy";

	public static enum TO_Items{
		BUTT("butt", "itembutt"),
		ORANGE("orange", "itemorange");
		
		private String unlocalizedName;
		private String registryName;
		
		TO_Items(String unlocalizedName, String registryName){
			this.unlocalizedName = unlocalizedName;
			this.registryName = registryName;
		}
		
		public String getUnlocalizedName() {
			return unlocalizedName;
		}
		
		public String getRegistryName() {
			return registryName;
		}
	}
	
	public static enum TO_Blocks{
		ANYTHING("anything", "blockanything");
		private String unlocalizedName;
		private String registryName;
		
		TO_Blocks(String unlocalizedName, String registryName){
			this.unlocalizedName = unlocalizedName;
			this.registryName = registryName;
		}
		
		public String getUnlocalizedName() {
			return unlocalizedName;
		}
		
		public String getRegistryName() {
			return registryName;
		}
	}
	
}
