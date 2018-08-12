package com.mycompany.myapp;
import android.support.v7.view.menu.*;
import android.app.*;
import android.widget.*;
import android.view.*;
import android.content.*;

public class CheckStatusGame extends Activity
{
	public boolean isHorizontalCoincided(Button button[][],String textButton){
			for (int i=0;i < button.length;i++) {
				int count=0;
				for (int j=0;j < button.length;j++) {
					if (button[i][j].getText() == textButton) {
						count++;
						if (count == button.length) {			
							for (int g=0;g < button.length;g++) {
								for (int k=0;k < button.length;k++) {
									button[g][k].setEnabled(false);
								}
							}
							return true;
						}
					}
				}	
			}
		
		return false;
	}
	public boolean isVerticalCoincided(Button button[][],String textButton){
		for (int i=0;i < button.length;i++) {
			int count=0;
			for (int j=0;j < button.length;j++) {
				if (button[j][i].getText() == textButton) {
					count++;
					if (count == button.length) {		
						for (int g=0;g < button.length;g++) {
							for (int k=0;k < button.length;k++) {
								button[g][k].setEnabled(false);
							}
						}
						return true;
					}
				}
			}	
		}
		return false;
	}
	
	public boolean isDioganalCoincided(Button button[][],String textButton){
		//Check diagonal Left-Right
		if (button[0][0].getText() == textButton && button[1][1].getText() == textButton && button[2][2].getText() == textButton) {
			for (int g=0;g < button.length;g++) {
				for (int k=0;k < button.length;k++) {
					button[g][k].setEnabled(false);
			    }
			}
			return true;
		}
		
		//Check diagonal Right-Left
		if (button[0][2].getText() == textButton && button[1][1].getText() == textButton && button[2][0].getText() == textButton) {
			for (int g=0;g < button.length;g++) {
				for (int k=0;k < button.length;k++) {
					button[g][k].setEnabled(false);
				}
			}
			return true;
		}
		return false;
	}

	public boolean isDraw(int n,int b){
		if(n==b){
			return true;
		}else{
			return false;
		}
	}
}
