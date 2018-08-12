package ru.pisarev;

import java.util.*;
import java.io.*;

public class Main
{
	public static void FileNew(char[][] s) throws IOException
	{
		File file=new File("/storage/emulated/0/AppProjects/XOGameII/file.txt");
		FileWriter fw=new FileWriter(file);
		FileReader fr=new FileReader(file);
		Scanner sc =new Scanner(fr);
		int count=0;
		for (int i=0;i < s.length;i++)
		{
			for (int j=0;j < s.length;j++)
			{
				count++;
				if (count % Field.size == 0)
				{
					fw.write(s[i][j] + "\n");
				}
				else
				{fw.write(s[i][j] + " ");}
			}
		}
		fw.close();
	}

	public static void main(String[] args) throws IOException
	{
		Field field=new Field();
	    Player player=new Player();
		Field.showField();

		do{
			player.stepO();
			Main.FileNew(field.cells);
			field.checkStatusGameX();
			field.showStatusField();
			player.stepX();
			Main.FileNew(field.cells);
			field.checkStatusGameO();
			field.showStatusField();
		}while(true);	


	}
}
