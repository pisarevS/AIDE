

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Player player=new Player();
		Field field=new Field();
		Ship ship=new Ship();

		field.initialization();
		ship.drawShips();
		
		do{
			field.showField();	
			player.doshoot();
			ship.checkShips();
			ship.checkEndGame();
		}while(true);
	}
}
