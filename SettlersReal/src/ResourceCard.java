
public class ResourceCard extends Card {

	private TerrainHex.Resource resource;

	public ResourceCard(TerrainHex.Resource r) {
		resource = r;
	}
	
	public boolean isResource(int r) {
		TerrainHex.Resource[] resources = TerrainHex.Resource.values();
		return resources[r]==resource;
	}
	
	public void play() {
		
	}
	
	public TerrainHex.Resource getResource(){
		return resource;
	}

}
