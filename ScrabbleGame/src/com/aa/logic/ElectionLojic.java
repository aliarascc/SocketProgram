package com.aa.logic;

import java.util.Collections;

import javax.swing.JTextField;

import com.aa.entity.ScrabbleGameSetupEntity;

public class ElectionLojic {
	private ScrabbleGameSetupEntity gameSetup;
	private JTextField txt;
	public ElectionLojic(ScrabbleGameSetupEntity gameSetup)
	{
		this.gameSetup=gameSetup;
		txt= new JTextField();
		Collections.shuffle(this.gameSetup.getSpotList());
	}
	
	public JTextField getUniqueSpot()
	{
		txt=gameSetup.getSpotList().get(0);
		gameSetup.getSpotList().remove(0);
		return txt;
	}

}
