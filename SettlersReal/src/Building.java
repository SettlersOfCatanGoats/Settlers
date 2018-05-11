
public class Building {

  private int level;
  private Player owner;
  private Location location;
  
  public Building(Location loc, Player p) {
	owner = p;
    level = 0;
    location = loc;
  }
  
  public void upgrade() {
    if(level >= 3) {
      System.out.println("Cannot do");
      return;
    }
    level++;
  }
  
  public boolean isASettlement() { return level==1; }
  public boolean isACity() { return level==2; }
  
  //public void setOwner(Player owner) { this.owner = owner; }
  
  public Player getOwner() { return owner; }
  
  public void giveCard(TerrainHex.Resource resource) {
    for(int n = 0;n < level;n++) owner.addCard(resource);
  }
  
}
