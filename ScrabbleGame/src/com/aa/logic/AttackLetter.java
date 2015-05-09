package com.aa.logic;

import java.util.ArrayList;

import com.aa.entity.EnterEntity;
import com.aa.entity.SetupEntity;

public class AttackLetter {
	SetupEntity gameSetup;
	EnterEntity gameEnter;
	ArrayList<String> dictionary;
	public AttackLetter(SetupEntity gameSetup, EnterEntity gameEnter)
	{
		this.gameSetup=gameSetup;
		this.gameEnter=gameEnter;
	}
	public boolean onAttack(String letter)
	{
		dictionary=gameSetup.getDictionary();
		for (int i = 0; i < dictionary.size(); i++) 
		{
			if (dictionary.get(i).equals(letter)) 
			{
				return true;
			}
			
		}
		return true;
	}

}
