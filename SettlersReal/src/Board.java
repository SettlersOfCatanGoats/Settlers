import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Board {
	private Hex[][] hexArr = new Hex[7][];
	private int boardWidth;
	private int boardHeight;
	private int boardXLoc;
	private int hexWidth;
	private int hexHeight;
	private int gap;
	private ArrayList<DevelopmentCard> devCards = new ArrayList<DevelopmentCard>();

	public Board(int pw, int ph) {
		hexArr[0] = new Hex[4];
		hexArr[1] = new Hex[5];
		hexArr[2] = new Hex[6];
		hexArr[3] = new Hex[7];
		hexArr[4] = new Hex[6];
		hexArr[5] = new Hex[5];
		hexArr[6] = new Hex[4];
		
		boardWidth = pw/2;
		boardHeight = (3*ph)/4;
		boardXLoc = pw/4;
		hexWidth = boardWidth/7;
		hexHeight = (int)(2*(hexWidth/Math.sqrt(3)));
		gap = boardWidth - 7*hexWidth;
		
		setTileLocs();
	}
		
	public void setTileLocs() {
		int y = hexHeight/2;
		int x = boardXLoc;
		for(int r = 0; r < hexArr.length; r++) {
			if(hexArr[r].length == 4) {
				x = boardXLoc + gap/2 + 2*hexWidth;
			}
			else if(hexArr[r].length == 5) {
				x = boardXLoc + gap/2 + (3*hexWidth)/2;
			}
			else if(hexArr[r].length == 6) {
				x = boardXLoc + gap/2 + hexWidth;
			}
			else if(hexArr[r].length == 7) {
				x = boardXLoc + gap/2 + hexWidth/2;
			}
			for(int c = 0; c < hexArr[r].length; c++) {
				if(r == 0 || r == hexArr.length - 1 || c == 0 || c == hexArr[r].length - 1) {
					hexArr[r][c] = new OceanHex(OceanHex.Port.Sheep, x, y, hexWidth);
				}
				else {
					hexArr[r][c] = new TerrainHex(TerrainHex.Resource.Wheat, x, y, hexWidth, 5);
				}
				x += hexWidth;
			}
			y += (3*hexHeight)/4;
		}
	}
	
	public void draw(Graphics g) {
		g.setColor(new Color(153,255,255));
		g.fillRect(boardXLoc, 0, boardWidth, boardHeight);
		
		
		for(int r = 0; r < hexArr.length; r++) {
			for(int c = 0; c < hexArr[r].length; c++) {
				hexArr[r][c].draw(g);
			}
		}
	}
	
	public void makeDevCardDeck() {
		for (int k = 0; k < 28; k++) {
			devCards.add(new DevelopmentCard(DevelopmentCard.DevCardTypes.Knight));
		}
		for (int vp = 0; vp < 10; vp++) {
			devCards.add(new DevelopmentCard(DevelopmentCard.DevCardTypes.VictoryPoint));
		}
		for (int rb = 0; rb < 4; rb++) {
			devCards.add(new DevelopmentCard(DevelopmentCard.DevCardTypes.RoadBuilding));
		}
		for (int m = 0; m < 4; m++) {
			devCards.add(new DevelopmentCard(DevelopmentCard.DevCardTypes.Monopoly));
		}
		for (int yop = 0; yop < 4; yop++) {
			devCards.add(new DevelopmentCard(DevelopmentCard.DevCardTypes.YearOfPlenty));
		}

		ArrayList<DevelopmentCard> temp = new ArrayList<DevelopmentCard>();
		for (int i = 0; i < 50; i++) {
			int rand = (int) (Math.random() * 50);
			while (temp.contains(devCards.get(rand))) {
				rand = (int) (Math.random() * 50);
			}
			temp.add(devCards.get(rand));
		}
		devCards=temp;
	}
	
	public DevelopmentCard takeDevCard() {
		DevelopmentCard dc = devCards.get(0);
		devCards.remove(0);
		return dc;
	}

}

