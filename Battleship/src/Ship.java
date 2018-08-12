
import java.util.*;
public class Ship {
	private int x;
	private int y;
	static char point='.';
	static char deck='#';
	private int count=0;
	private int[]twoDeckCoordinates={0,0,0};
	private int[]threeDeckCoordinates={0,0,0};
	private int[]fourDeckCoordinates={0,0,0};
	Random random=new Random();

	void checkShips() {
		checkTwoDeckShip();
		checkThreeDeckShip();
		checkFourDeckShip();
	}

	void drawShips() {
		//fourDackShip();
		threeDeckShip();
		threeDeckShip();
		threeDeckShip();
		//twoDeckShip();
	}

	void checkEndGame() {
		Field field=new Field();
		if (count == 3) {
			field.showField();
			System.out.println("      Game over");
			do{

			}while(true);
		}
	}

	private void potopil(String tipeShip) {
		count++;
		System.out.println(" Потопил " + tipeShip);
	}

	private int[] fourDackShip() {
		int n=1 + random.nextInt(2);
		switch (n) {
			case 1:
				x =random.nextInt(6) + 4;
				y = 1 + random.nextInt(9);
				for (int i=1;i >= -4;i--) {
					for (int j=-1;j <= 1;j++) {
						if (Field.cells[x + i][y + j] == deck) {
							fourDackShip();
						}
					}
				}
				for (int i=0;i < 4;i++) {
					Field.cells[x--][y] = deck;
					fourDeckCoordinates[0] = x;
					fourDeckCoordinates[1] = y;
					fourDeckCoordinates[2] = n;
				}
				break;
			case 2:
				x = 1 + random.nextInt(9);
				y = random.nextInt(6) + 4;
				for (int i=1;i >= -4;i--) {
					for (int j=-1;j <= 1;j++) {
						if (Field.cells[x + j][y + i] == deck) {
							fourDackShip();
						}
					}
				}
				for (int i=0;i < 4;i++) {
					Field.cells[x][y--] = deck;
					fourDeckCoordinates[0] = x;
					fourDeckCoordinates[1] = y;
					fourDeckCoordinates[2] = n;
				}
				break;
		}
		return fourDeckCoordinates;
	}

	private int[] threeDeckShip() {
		int n = 1 + random.nextInt(2);
		
		switch (1) {
			case 1:
				x = 3+random.nextInt(7);
				y = 1 + random.nextInt(9);
				for (int i=1;i >= -3;i--) {
					for (int j=-1;j <= 1;j++) {
						if (Field.cells[x + i][y + j] == deck) {
							threeDeckShip();
						}
					}
				}
			
				for (int i=0;i < 3;i++) {
					Field.cells[x--][y] = deck;
					threeDeckCoordinates[0] = x;
					threeDeckCoordinates[1] = y;
					threeDeckCoordinates[2] = n;
				}
				break;
			case 2:
				x = 1+random.nextInt(9);
				y = random.nextInt(7) + 3;
				for (int i=1;i >= -3;i--) {
					for (int j=-1;j <= 1;j++) {
						if (Field.cells[x + j][y + i] == deck) {
							threeDeckShip();
						}
					}
				}
				System.out.println("3 палубный гор."+x+" "+y);
				for (int i=0;i < 3;i++) {
					Field.cells[x][y--] = deck;	
					threeDeckCoordinates[0] = x;
					threeDeckCoordinates[1] = y;
					threeDeckCoordinates[2] = n;
				}
				break;
		}
		return threeDeckCoordinates;
	}

	private int[] twoDeckShip() {

		int n = 1 + random.nextInt(2);
		switch (n) {
			case 1:
				if (Field.cells[x = random.nextInt(9) + 1][y = random.nextInt(10)] != point
					|| Field.cells[x - 1][y] != point) {
					twoDeckShip();
				} else
					for (int i=0;i < 2;i++) {
						Field.cells[x--][y] = deck;
						twoDeckCoordinates[0] = x;
						twoDeckCoordinates[1] = y;
						twoDeckCoordinates[2] = n;
					}

				break;
			case 2:
				if (Field.cells[x = random.nextInt(10)][y = random.nextInt(9) + 1] != point ||
					Field.cells[x][y - 1] != point) {
					twoDeckShip();
				} else 
					for (int i=0;i < 2;i++) {
						Field.cells[x][y--] = deck;	
						twoDeckCoordinates[0] = x;
						twoDeckCoordinates[1] = y;
						twoDeckCoordinates[2] = n;
					}
				break;
		}
		return twoDeckCoordinates;
	}

	private int checkTwoDeckShip() {
		int	 x=twoDeckCoordinates[0];
		int	y=twoDeckCoordinates[1];
		int h=twoDeckCoordinates[2];
		switch (h) {
			case 1:
				if (Field.cells[x + 1][y] == 'x' && Field.cells[x + 2][y] == 'x') {
					potopil("2 палубный");
					twoDeckCoordinates[2] = 0;
				}
				break;
			case 2:
				if (Field.cells[x][y + 1] == 'x' && Field.cells[x][y + 2] == 'x') {
					potopil("2 палубный");
					twoDeckCoordinates[2] = 0;
				}
				break;
		}
		return count;
	}

	private int checkThreeDeckShip() {
		int x=threeDeckCoordinates[0];
		int y=threeDeckCoordinates[1];
		int h=threeDeckCoordinates[2];
		switch (h) {
			case 1:
				if (Field.cells[x + 1][y] == 'x' && Field.cells[x + 2][y] == 'x' &&
					Field.cells[x + 3][y] == 'x') {
					potopil("3 ралубный");
					threeDeckCoordinates[2] = 0;
				}
				break;
			case 2:
				if (Field.cells[x][y + 1] == 'x' && Field.cells[x][y + 2] == 'x' &&
					Field.cells[x][y + 3] == 'x') {
					potopil("3 палубный");
					threeDeckCoordinates[2] = 0;
				}
				break;
		}
		return count;
	}

	private int checkFourDeckShip() {
		int x=fourDeckCoordinates[0];
		int y=fourDeckCoordinates[1];
		int h=fourDeckCoordinates[2];
		switch (h) {
			case 1:
				if (Field.cells[x + 1][y] == 'x' && Field.cells[x + 2][y] == 'x' &&
					Field.cells[x + 3][y] == 'x' && Field.cells[x + 4][y] == 'x') {
					potopil("4 палубный");
					fourDeckCoordinates[2] = 0;
				}
				break;
			case 2:
				if (Field.cells[x][y + 1] == 'x' && Field.cells[x][y + 2] == 'x' &&
					Field.cells[x][y + 3] == 'x' && Field.cells[x][y + 4] == 'x') {
					potopil("4 палубный");
					fourDeckCoordinates[2] = 0;
				}
				break;
		}
		return count;
	}
}
