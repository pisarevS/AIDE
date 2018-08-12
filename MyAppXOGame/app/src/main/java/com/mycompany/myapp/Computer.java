package com.mycompany.myapp;
import android.app.*;
import android.widget.*;
import java.util.*;
import android.graphics.*;

public class Computer extends Activity {
    int count;
	Random rnd=new Random();
	public void step(Button button[][], String varX, String varO) {
		count=0;
        for (int i=0;i < button.length;i++) {
			for (int j=0;j < button.length;j++) {
				if (button[i][j].getText() != varX && button[i][j].getText() != varO) {
					count++;
				}
			}
		}
		if (count >1) {
			int x=rnd.nextInt(3);
			int y=rnd.nextInt(3);
			if (button[x][y].getText() != varX && button[x][y].getText() != varO) {
				button[x][y].setText(varO);
				button[x][y].setEnabled(false);
				button[x][y].setTextColor(Color.WHITE);
			}
			else {
				step(button, varX, varO);
			}
		}
	}
}
	
	

