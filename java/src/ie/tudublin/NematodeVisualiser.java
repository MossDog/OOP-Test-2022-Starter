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

	ArrayList<Nematode> nems = new ArrayList<Nematode>(); //create list of Nematodes
	Table table;
	int nemNum;

	public void keyPressed()
	{		
		if (keyCode == LEFT && nemNum > 0)
		{
			nemNum--;
		}
		else if(keyCode == RIGHT && nemNum < nems.size() - 1){
			nemNum++;
		}
	}


	public void settings()
	{
		size(800, 800);
		fullScreen();
	}

	public void setup() 
	{
		colorMode(HSB, 360, 100, 100);
		background(0);
		smooth();
		loadNematodes();
		nemNum = 0;	
	}
	

	public void loadNematodes()
	{

		String line = "";  
		String splitBy = ",";  
		try   
		{  
			//parsing a CSV file into BufferedReader class constructor  
			BufferedReader br = new BufferedReader(new FileReader("data/nematodes.csv"));  
			while ((line = br.readLine()) != null){   //returns a Boolean value

				String[] terms = line.split(splitBy);    // use comma as separator
				if(terms[1].matches("-?\\d+")){
					//System.out.println(terms[1]);
					Nematode nem = new Nematode(terms[0], Integer.parseInt(terms[1]), terms[2], terms[3], terms[4], this);//construct nematodes to be stored
					nems.add(nem);//populate list
				}
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
		background(0);
		noFill();
		
		for(int i = 0; i < nems.get(nemNum).len; i++){
			
			stroke(map(i, 0, nems.get(nemNum).len, 0, 360), 100, 100);

			circle(width/2, height/3 + (i * 50), 50);

			//display nematode with correct length
			if(nems.get(nemNum).limbs.equals("1")){
				//System.out.println("'" + nems.get(nemNum).limbs + "'");
				line(width/2 + 25, height/3 + (i * 50), width/2 + 50, height/3 + (i * 50));
				line(width/2 - 25, height/3 + (i * 50), width/2 - 50, height/3 + (i * 50));
			}

			//apply gender effects
			if(nems.get(nemNum).gender.equals("m") && i == nems.get(nemNum).len - 1){
				line(width/2, height/3 + (i * 50) + 25, width/2, height/3 + (i * 50) + 50);
				circle(width/2, height/3 + (i * 50) + 55, 10);
			}
			else if(nems.get(nemNum).gender.equals("f") && i == nems.get(nemNum).len - 1){
				circle(width/2, height/3 + (i * 50), 10);
			}
			else if(nems.get(nemNum).gender.equals("h") && i == nems.get(nemNum).len - 1){
				line(width/2, height/3 + (i * 50) + 25, width/2, height/3 + (i * 50) + 50);
				circle(width/2, height/3 + (i * 50) + 55, 10);
				circle(width/2, height/3 + (i * 50), 10);
			}
			
			/* //display eyes (unfinished)
			if(nems.get(nemNum).eyes.equals("1") && i == 0){
				translate(0, 0);

				rotate(radians(-45));
				line(width/2 + 25, height/3 + (i * 50), width/2 + 50, height/3 + (i * 50));

				rotate(radians(315));
				line(width/2 - 25, height/3 + (i * 50), width/2 - 50, height/3 + (i * 50));
			} */
		}
	}
}
