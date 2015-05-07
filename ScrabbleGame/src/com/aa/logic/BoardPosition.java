package com.aa.logic;

import java.util.Collections;

import javax.swing.JButton;

import com.aa.entity.ScrabbleGameSetupEntity;

public class BoardPosition {
	private ScrabbleGameSetupEntity gameSetup;
	private JButton btn;
	public BoardPosition(ScrabbleGameSetupEntity gameSetup)
	{
		this.gameSetup=gameSetup;
		btn= new JButton();
		Collections.shuffle(this.gameSetup.getSpotList());
	}
	
	public JButton getUniqueSpot()
	{
		btn=gameSetup.getSpotList().get(0);
		gameSetup.getSpotList().remove(0);
		return btn;
	}

}
