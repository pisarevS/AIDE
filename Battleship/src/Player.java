
import java.util.*;
import org.xml.sax.*;public class Player {


	public int x=0;
	public int y=0;
	Ship ship=new Ship();
	Scanner sc=new Scanner(System.in);

	void doshoot() {
		System.out.print("Введите координату - ");
		String str=sc.nextLine();
		char[] myStr=str.toCharArray();

		char c=myStr[0];
		String d=String.valueOf(c).toUpperCase();
		switch (d) {
			case"A":
				y = 1;
				break;
			case"B":
				y = 2;
				break;
			case"C":
				y = 3;
				break;
			case"D":
				y = 4;
				break;
			case"E":
				y = 5;
				break;
			case"F":
				y = 6;
				break;
			case"G":
				y = 7;
				break;
			case"H":
				y = 8;
				break;
			case"I":
				y = 9;
				break;
			case"J":
				y = 10;
				break;
		}
		char cx=myStr[1];
		x = Character.getNumericValue(cx);
		x++;

		if (Field.cells[x][y] != Ship.deck) {
			Field.cells[x][y] = 'x';
			System.out.println("      Промах");
		} else if (Field.cells[x][y] == Ship.deck) {
			Field.cells[x][y] = 'x';
			System.out.println("      Попал");
		}
	}
}



	
