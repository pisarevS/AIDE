
import java.security.*;
import java.util.*;
import org.xml.sax.*;

public class Field {
	public static final int SIZE=12;
	public static char[][] cells = new char[SIZE][SIZE];
    Ship ship=new Ship();

	void initialization() {
		cells[0][0] = ' ';  cells[0][1] = 'A';
		cells[1][0] = '0';  cells[0][2] = 'B';
		cells[2][0] = '1';  cells[0][3] = 'C';
		cells[3][0] = '2';  cells[0][4] = 'D';
		cells[4][0] = '3';  cells[0][5] = 'E';
		cells[5][0] = '4';  cells[0][6] = 'F';
		cells[6][0] = '5';  cells[0][7] = 'G';
		cells[7][0] = '6';  cells[0][8] = 'H';
		cells[8][0] = '7';  cells[0][9] = 'I';
		cells[9][0] = '8';  cells[0][10] = 'J';
		cells[10][0] = '9';

		for (int i=1;i < SIZE;i++) {
			for (int j=1;j < SIZE;j++) { 
				cells[i][j] = '.';
                cells[11][j] = ' ';
				cells[j][11] = ' ';
			}
		}
	}
	void showField() {
		for (int i=0;i < SIZE;i++) {
			for (int j=0;j < SIZE;j++) {
				System.out.print(cells[i][j] + " ");
			}
			System.out.println();
		}
	}
}
