package com.aa.client;

import java.net.InetAddress;
import java.net.Socket;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.aa.entity.ScrabbleGameEnterEntity;
import com.aa.forms.frmStart;
import com.aa.logic.UsernameControl;

public class ClientSocketConnect {
	
	@SuppressWarnings("unused")
	private Socket client;
	private UsernameControl unamecontrol;
	
	public ClientSocketConnect(JTextField txtIp, JComboBox<String> txtPortBaglan)
	{
		if (txtIp.getText().equals("")||txtPortBaglan.getSelectedItem().toString().equals("")) {
			JOptionPane.showMessageDialog(new frmStart().getContentPane(),"ip ve port bilgisi bos olamaz...");
		}
		else
		{
			try 
			{
				InetAddress address = InetAddress.getByName(txtIp.getText());
				client=new Socket(address,Integer.parseInt(txtPortBaglan.getSelectedItem().toString()));
				System.out.println("client banlandi...");
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
				System.out.println("client baglanamadi...");
			}
		}

	}

	public ClientSocketConnect(ScrabbleGameEnterEntity gameEnter)
	{
		unamecontrol=new UsernameControl();

			if (!unamecontrol.controlUsername(gameEnter.getKullaniciAdi().getText().toString())) {
				unamecontrol.addUsername(gameEnter.getKullaniciAdi().getText().toString());
				System.out.println(unamecontrol.getUsernames());
			}
			else
			{
				System.out.println("olmadi");
			}
		
	}
	
}
