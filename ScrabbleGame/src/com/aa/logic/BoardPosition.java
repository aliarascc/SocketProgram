package com.aa.logic;

import java.util.Collections;

import javax.swing.JButton;

import com.aa.entity.SetupEntity;

public class BoardPosition {
	private SetupEntity gameSetup;
	private JButton btn;
	public BoardPosition(SetupEntity gameSetup)
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
