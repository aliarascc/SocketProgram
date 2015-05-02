package com.aa.logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
public class UniqueRandomNumbers {
	int x1,y1;
	public ArrayList<Integer> listX;
	public ArrayList<Integer> listY;
	public UniqueRandomNumbers(int x,int y)
	{
		listX = new ArrayList<Integer>();
		listY = new ArrayList<Integer>();
		for (int i = 0; i < x; i++) {
			listX.add(i);
		}
		for (int i = 0; i < y; i++) {
			listY.add(i);
		}
		Collections.shuffle(listX);
		Collections.shuffle(listY);
	}
	
	public int getUniqueX()
	{	
		x1=listX.get(0);
		listX.remove(0);
		return x1;
	}
	public int getUniqueY()
	{
		y1=listY.get(0);
		listY.remove(0);
		return y1;
	}
}
