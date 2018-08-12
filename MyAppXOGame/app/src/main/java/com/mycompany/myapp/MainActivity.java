package com.mycompany.myapp;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.view.View.*;
import android.view.View.OnClickListener;
import java.util.*;
import android.graphics.*;

public class MainActivity extends Activity implements OnClickListener {
	private String textButton;
	private static final int SIZE=3;
	private static final String varX="x";
	private static final String varO="0";
	private int countComputer=0;
	private int countDraw=0;
	private int countDrawCheck=5;
    private Toast toast;
	private CheckStatusGame checkStatusGame=new CheckStatusGame();
    private Button button[][]= new Button[SIZE][SIZE];
    private Computer computer=new Computer();
	private int xCount=0;
	private int oCount=0;
	private int draw=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
		getActionBar().hide();
		for (int i=0;i < button.length;i++) {
			for (int j=0;j < button.length;j++) {
				String buttonID="Button_" + i + j;
				int resID=getResources().getIdentifier(buttonID, "id", getPackageName());
				button[i][j] = (Button)findViewById(resID);	
				button[i][j].setOnClickListener(this);
			}
		}	 
	}

	@Override
	public void onClick(View p1) {
		TextView idPlayerX=(TextView)findViewById(R.id.idPlayerX);
		TextView idPlayerO=(TextView)findViewById(R.id.idPlayerO);
		TextView idDraw=(TextView)findViewById(R.id.idDraw);
		//User step
		for (int i=0;i < button.length;i++) {
			for (int j=0;j < button.length;j++) {
				String buttonID="Button_" + i + j;
				int resID=getResources().getIdentifier(buttonID, "id", getPackageName());
				button[i][j] = (Button)findViewById(resID);		
				textButton = varX;
				if (p1.getId() == resID) {
					button[i][j].setText(textButton);
					button[i][j].setEnabled(false);
					button[i][j].setTextColor(Color.BLACK);
				}
			}
		}
		//Computer step
		if(checkStatusGame.isHorizontalCoincided(button,textButton)==false&&
		checkStatusGame.isVerticalCoincided(button,textButton)==false&&
		checkStatusGame.isDioganalCoincided(button,textButton)==false)
		computer.step(button, varX, varO);
		
		int t = 0;
		while (t < 2) {
			t++;
			if (t == 1) {textButton = varX;}
			else {textButton = varO;}
			//Check horizontal
			if (checkStatusGame.isHorizontalCoincided(button, textButton)) {
				message(textButton, " ВЫЙГРАЛ");
				if(textButton==varX){
					xCount++;
				}else if(textButton==varO){
					oCount++;
				}
				countDrawCheck = 0;
			}
			//Check vertical
			if (checkStatusGame.isVerticalCoincided(button, textButton)) {
				message(textButton, " ВЫЙГРАЛ");
				if(textButton==varX){
					xCount++;
				}else if(textButton==varO){
					oCount++;
				}
				countDrawCheck = 0;
			}
			//Check diagonal
			if (checkStatusGame.isDioganalCoincided(button, textButton)) {
				message(textButton, " ВЫЙГРАЛ");
				if(textButton==varX){
					xCount++;
				}else if(textButton==varO){
					oCount++;
				}
				countDrawCheck = 0;
			}
		}
		//Check Draw
		countDraw++;
		if (checkStatusGame.isDraw(countDraw, countDrawCheck)) {
			message("", "НИЧЬЯ");
			draw++;
		}
		idPlayerX.setText(String.valueOf(xCount));
		idPlayerO.setText(String.valueOf(oCount));
		idDraw.setText(String.valueOf(draw));
	}

	public void message(String a, String b) {
		toast = Toast.makeText(getApplicationContext(), a.toUpperCase() + b, Toast.LENGTH_SHORT);
		toast.show();
	}

	public void onClickRestart(View v) {
		for (int i=0;i < button.length;i++) {
			for (int j=0;j < button.length;j++) {
				button[i][j].setText(" ");
				button[i][j].setEnabled(true);
				countDraw = 0;
				countDrawCheck = 5;
				countComputer = 0;

			}
		}
	}
}
