package com.aa.logic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class DictionaryList extends ArrayList<String> {
	private static final long serialVersionUID = -5943257829449012676L;

	public DictionaryList() {
		try 
		{
			File dictionary = new File("dictionary.txt");
			BufferedReader reader = null;
			reader = new BufferedReader(new FileReader(dictionary));
			int i = 0;
			String row;
			do 
			{
				row = reader.readLine();
				this.add(row);
				i=i+1;

			} 
			while (row != null);
			reader.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public ArrayList<String> getAllWords()
	{
		return this;
	}

	public  void dictionaryRead() {
		

			System.out.println(this);

	}

}
