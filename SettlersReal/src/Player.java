import java.util.ArrayList;

public class Player {
	private int setsLeft = 5;
	private int citiesLeft = 4;
	private int roadsLeft = 15;
	private int points;
	private ArrayList<ResourceCard> resourceCards;
	private ArrayList<DevelopmentCard> devCards;
	private ArrayList<Location> settlementLoc;
	private ArrayList<Location> cityLoc;
	private ArrayList<Location> roadLoc;

	public Player() {

	}

	public void addCard(ResourceCard rc) {
		resourceCards.add(rc);
	}

	public void buildRoad() {
		if (canBuildRoad()) {
			removeCardOfType(TerrainHex.Resource.Brick);
			removeCardOfType(TerrainHex.Resource.Wood);
			roadsLeft--;
		}
	}

	public void buildSettlement() {
		if (canBuildSettlement()) {
			removeCardOfType(TerrainHex.Resource.Brick);
			removeCardOfType(TerrainHex.Resource.Wood);
			removeCardOfType(TerrainHex.Resource.Wheat);
			removeCardOfType(TerrainHex.Resource.Sheep);
			setsLeft--;
		}
	}

	public void buildCity() {
		if (canBuildCity()) {
			removeCardOfType(TerrainHex.Resource.Rock);
			removeCardOfType(TerrainHex.Resource.Rock);
			removeCardOfType(TerrainHex.Resource.Rock);
			removeCardOfType(TerrainHex.Resource.Wheat);
			removeCardOfType(TerrainHex.Resource.Wheat);
			citiesLeft--;
		}
	}

	public void buyDevCard() {
		if (canBuyDevCard()) {
			removeCardOfType(TerrainHex.Resource.Rock);
			removeCardOfType(TerrainHex.Resource.Wheat);
			removeCardOfType(TerrainHex.Resource.Sheep);
			devCards.add(new DevelopmentCard());
		}
	}

	public boolean canBuildRoad() {
		return (findNumOfCardsOfType(TerrainHex.Resource.Brick) == 1
				&& findNumOfCardsOfType(TerrainHex.Resource.Wood) == 1);
	}

	public boolean canBuildSettlement() {
		return (findNumOfCardsOfType(TerrainHex.Resource.Brick) == 1
				&& findNumOfCardsOfType(TerrainHex.Resource.Wood) == 1
				&& findNumOfCardsOfType(TerrainHex.Resource.Wheat) == 1
				&& findNumOfCardsOfType(TerrainHex.Resource.Sheep) == 1);
	}

	public boolean canBuildCity() {
		return (findNumOfCardsOfType(TerrainHex.Resource.Rock) == 3
				&& findNumOfCardsOfType(TerrainHex.Resource.Wheat) == 2);
	}

	public boolean canBuyDevCard() {
		return (findNumOfCardsOfType(TerrainHex.Resource.Rock) == 1
				&& findNumOfCardsOfType(TerrainHex.Resource.Wheat) == 1
				&& findNumOfCardsOfType(TerrainHex.Resource.Sheep) == 1);
	}

	private int findNumOfCardsOfType(TerrainHex.Resource r) {
		int num = 0;
		for (ResourceCard rc : resourceCards) {
			if (rc.getResource().equals(r)) {
				num++;
			}
		}
		return num;
	}

	private void removeCardOfType(TerrainHex.Resource r) {
		for (int i = 0; i < resourceCards.size(); i++) {
			if (resourceCards.get(i).getResource().equals(r)) {
				resourceCards.remove(i);
				return;
			}
		}
	}
}
