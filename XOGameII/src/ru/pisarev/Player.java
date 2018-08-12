package ru.pisarev;

import java.util.*;
import java.security.cert.*;
import java.util.stream.*;

public class Player
{
	private int rowX;
	private int columnX;
	private int rowO;
	private int columnO;
    Scanner sc=new Scanner(System.in);
	Field field=new Field();
	Random random=new Random();
	

	

	public void setColumnO(int columnO)
	{
		if (columnO > Field.cells.length - 1) {
			while (columnO > Field.cells.length - 1) {
				System.out.println("Outside field");	
				System.out.print("Enter the number column - ");
				columnO = sc.nextInt() - 1;
			}	
		}
		this.columnO = columnO;
	}

	public void setRowO(int rowO)
	{ 	
	    if (rowO > Field.cells.length - 1) {
			while (rowO > Field.cells.length - 1) {
				System.out.println("Outside field");
				System.out.print("Enter the number row - ");
				rowO = sc.nextInt() - 1;
			}	
		}
		this.rowO = rowO;
	}

	public void setColumnX(int columnX)
	{	
		if (columnX > Field.cells.length - 1) {
			while (columnX > Field.cells.length - 1) {
				System.out.println("Outside field");	
				System.out.print("Enter the number column - ");
				columnX = sc.nextInt() - 1;
			}
		}
		this.columnX = columnX;
	}

	public void setRowX(int rowX)
	{ 
	    if (rowX > Field.cells.length - 1) {
			while (rowX > Field.cells.length - 1) {
				System.out.println("Outside field");
				System.out.print("Enter the number row - ");
				rowX = sc.nextInt() - 1;
			}
	    }
		this.rowX = rowX;
	}

	void stepX()
	{
		System.out.println("Player \"x\" is your turn");
		
		rowX= random.nextInt(field.cells.length);
		columnX= random.nextInt(field.cells.length);
		if((field.cells[rowX][columnX]=='x')||(field.cells[rowX][columnX]=='0')){
			do{
				rowX= random.nextInt(field.cells.length);
				columnX= random.nextInt(field.cells.length);
			}while((field.cells[rowX][columnX]=='x')||(field.cells[rowX][columnX]=='0'));
		}
		int r=rowX; r++;
		int c=columnX; c++;
		System.out.println("Enter the number row -" +r);
		System.out.println("Enter the number column - "+c);
	
			
		
		if (Field.cells[rowX][columnX] == 'x') {
			System.out.println("You shot early here");
			stepX();
		}
		if (Field.cells[rowX][columnX] == '0') {
			System.out.println("The cell is not empty");
			stepX();
		}
		else {
			Field.cells[rowX][columnX] = 'x'; 
		}
	}

	void stepO()
	{
        System.out.println("Player \"0\" is your turn");
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter the number row - ");
		try {
			setRowO(sc.nextInt() - 1);
		}
		catch (Exception e) {

			System.out.println("Invalid character");
			sc.nextLine();
			System.out.print("Enter the number row - ");
			try {
				setRowO(sc.nextInt() - 1);
			}
			catch (Exception b) {
				System.out.println("Invalid character");
				System.out.println("You are a stupid player\n       GAMA OVER");
				while (true) sc.nextLine();
			}
		}
		System.out.print("Enter the number column - ");
		try {
			setColumnO(sc.nextInt() - 1);
		}
		catch (Exception e) {
			System.out.println("Invalid character");
			sc.nextLine();
			System.out.print("Enter the number column - ");
			try {
				setColumnO(sc.nextInt() - 1);
			}
			catch (Exception b) {
				System.out.println("Invalid character");
				System.out.println("You are a stupid player\n       GAMA OVER");
				while (true) sc.nextLine();
			}
		}
		if (Field.cells[rowO][columnO] == '0') {
			System.out.println("You shot early here");
			stepO();
		}
		if (Field.cells[rowO][columnO] == 'x') {
			System.out.println("The cell is not empty");
			stepO();
		}
		else {
			Field.cells[rowO][columnO] = '0';
		}
	}
}
	
