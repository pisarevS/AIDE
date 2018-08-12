package ru.pisarev;

import java.util.*;

public class Field
{

	static int size=5;
	static  char[][]cells=new char[size][size];

	static void showField()
	{ 
		for (int i=0;i < cells.length;i++)
		{
			for (int j=0;j < cells[i].length;j++)
			{
		    	System.out.print((cells[i][j] = '.')+" ");
			}	
			System.out.println();
		}
	}

    void showStatusField()
	{
		for (int i=0;i < cells.length;i++)
		{
			for (int j=0;j < cells[i].length;j++)
			{
				System.out.print((cells[i][j]) + " ");
			}
			System.out.println();
		}

		if (checkStatusGameO() == true)
		{
			System.out.println("WIN \"O\" GAMA OWER");
			Scanner sc= new Scanner(System.in);
			while (true) sc.nextLine();
		}

		if ((checkStatusGameX() == true))
		{
			System.out.println("WIN \"X\" GAMA OWER");
			Scanner sc= new Scanner(System.in);
			while (true) sc.nextLine();
		}

	}

	boolean checkStatusGameX()
	{
	    int rowCount=0;
		int columnCount=0;
		int xLeftRight=0;
		int yLeftRight=0;
		int diagonalCountLeftRightX=0;
		int xRightLeft=0;
		int yRightLeft=size - 1;
		int diagonalCountRightLeftX=0;
		
		
		//Check horizontal
		for (int i=0;i < cells.length;i++)
		{
			rowCount=0;
			for (int j=0;j < cells[i].length;j++)
			{
				if (cells[i][j] == '0')
				{
					rowCount++;
					if (rowCount == size)
					{
						return true;				 
					}
			   	}	
			}
		}
		
		//Check vertikal
		for (int i=0;i < cells.length;i++)
		{
			columnCount = 0;
			for (int j=0;j < cells.length;j++)
			{
				if (cells[j][i] == '0')
				{	
					columnCount++;
					if (columnCount == size)
					{
						return true;				 
					}
				}	
			}
		}
		//Check diagonal
		for (int i=0;i < cells.length;i++)
		{
			for (int j=0;j < cells[i].length;j++)
			{
				//Check diagonal Left-Right
				if (cells[xLeftRight][yLeftRight] == 'x')
				{
					xLeftRight++;
					yLeftRight++;
					diagonalCountLeftRightX++;
					if (diagonalCountLeftRightX == size)
					{
						return true;
					}
				}
				//Check diagonal Right-Left
				if (cells[xRightLeft][yRightLeft] == 'x')
				{
					xRightLeft++;
					yRightLeft--;
					diagonalCountRightLeftX++;
					if (diagonalCountRightLeftX == size)
					{
						return true;
					}
				} 
	        }
		}
		return false;
	}

	boolean checkStatusGameO()
	{
	    int rowCount=0;
		int columnCount=0;
		int xLeftRight=0;
		int yLeftRight=0;
		int diagonalCountLeftRightO=0;
		int xRightLeft=0;
		int yRightLeft=size - 1;
	    int diagonalCountRightLeftO=0;

		//Check horizontal
		for (int i=0;i < cells.length;i++)
		{
			rowCount=0;
			for (int j=0;j < cells[i].length;j++)
			{
				if (cells[i][j] == '0')
				{
					rowCount++;
					if (rowCount == size)
					{
						return true;				 
					}
			   	}	
			}
		}
		//Check vertikal
		for (int i=0;i < cells.length;i++)
		{
			columnCount = 0;
			for (int j=0;j < cells.length;j++)
			{
				if (cells[j][i] == '0')
				{	
					columnCount++;
					if (columnCount == size)
					{
						return true;				 
					}
				}	
			}
		}

		for (int i=0;i < cells.length;i++)
		{
			for (int j=0;j < cells[i].length;j++)
			{
				//Check diagonal Left-Right
				if (cells[xLeftRight][yLeftRight] == '0')
				{
					xLeftRight++;
					yLeftRight++;
					diagonalCountLeftRightO++;
					if (diagonalCountLeftRightO == size)
					{
						return true;
					}
				}
				//Check diagonal Right-Left
				if (cells[xRightLeft][yRightLeft] == '0')
				{
					xRightLeft++;
					yRightLeft--;
					diagonalCountRightLeftO++;
					if (diagonalCountRightLeftO == size)
					{
						return true;
					}
				} 
	        }
		}
		return false;
	}
}
