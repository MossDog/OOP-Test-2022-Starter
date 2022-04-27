package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;
import java.io.*;  
import java.util.Scanner;
import java.io.BufferedReader;  
import java.io.FileReader;  
import java.io.IOException;  

public class NematodeVisualiser extends PApplet
{

	Table table;

	public void keyPressed()
	{		
		if (keyCode == LEFT)
		{
		}		
	}


	public void settings()
	{
		size(800, 800);
	}

	public void setup() 
	{
		colorMode(HSB);
		background(0);
		smooth();
		loadNematodes();			
	}
	

	public void loadNematodes()
	{

		String line = "";  
		String splitBy = ",";  
		try   
		{  
		//parsing a CSV file into BufferedReader class constructor  
		BufferedReader br = new BufferedReader(new FileReader("data/nematodes.csv"));  
		while ((line = br.readLine()) != null)   //returns a Boolean value  
		{  
		String[] terms = line.split(splitBy);    // use comma as separator  
		ArrayList<Nematode> nems = new ArrayList<Nematode>();
		Nematode nem;
		nem = new Nematode(terms[0], terms[1], terms[2], terms[3], terms[4], this);
		nems.add(nem);
		System.out.println(nems.get(0).name);
		}  
		}   
		catch (IOException e)
		{  
		e.printStackTrace();  
		}

		

		/* table = new Table();
  
		table.addColumn("number", Table.INT);
		table.addColumn("mass", Table.FLOAT);
		table.addColumn("name", Table.STRING);
		
		TableRow row = table.addRow();
		row.setInt("number", 8);
		row.setFloat("mass", 15.9994f);
		row.setString("name", "Oxygen");
		
		println(row.getInt("number"));   // Prints 8
		println(row.getFloat("mass"));   // Prints 15.9994
		println(row.getString("name"));  // Prints "Oxygen */

		
	}


	public void draw()
	{	
	}
}
