package com.aa.client;

import java.net.InetAddress;
import java.net.Socket;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.aa.forms.frmBaslangic;

public class ClientSocketConnect {
	
	@SuppressWarnings("unused")
	private Socket client;
	
	public ClientSocketConnect(JTextField txtIp, JTextField txtPortBaglan)
	{
		if (txtIp.getText().equals("")||txtPortBaglan.getText().equals("")) {
			JOptionPane.showMessageDialog(new frmBaslangic().getContentPane(),"ip ve port bilgisi boþ olamaz...");
		}
		else
		{
			try 
			{
				InetAddress address = InetAddress.getByName(txtIp.getText());
				client=new Socket(address,Integer.parseInt(txtPortBaglan.getText()));
				System.out.println("client baðlandý...");
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
				System.out.println("client baðlanamadý...");
			}
		}

	}

}
