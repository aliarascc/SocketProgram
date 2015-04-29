package com.aa.server;

import java.net.ServerSocket;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.aa.entity.ScrabbleGameSetupEntity;
import com.aa.forms.frmGame;

public class ServerSocketOpen extends Thread {

	@SuppressWarnings("unused")
	private ServerSocket socket = null;

	public ServerSocketOpen(JTextField txtPortAc, int QUEUELENGTH) {
		try {
			socket = new ServerSocket(Integer.parseInt(txtPortAc.getText()),
					QUEUELENGTH);
			System.out.println("ServerSocket acildi...");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ServerSocket acilamadi...");
		}

	}

	@SuppressWarnings("deprecation")
	public ServerSocketOpen(ScrabbleGameSetupEntity oyunEntity) {
		try {
			if (oyunEntity.get_portAc().getText().length() > 5|| 
			   (oyunEntity.get_portAc().getText().toString().equals("")&& 
			    oyunEntity.get_oyunAlaniX().getText().toString().equals("")&&
			    oyunEntity.get_oyunAlaniY().getText().toString().equals(""))) 
			{
				JOptionPane.showMessageDialog(null,"port numarasi hatali girildi\nX ve/veya Y degerleri hatali girildi",
								"Hata", JOptionPane.ERROR_MESSAGE);
			} 
			else 
			{							
				socket = new ServerSocket(Integer.parseInt(oyunEntity.get_portAc().getText().toString()),oyunEntity.getQUEUELENGTH());
				System.out.println("ServerSocket acildi...");
				frmGame oyun = new frmGame(oyunEntity);
				oyun.show();
				System.out.println("oyun fromu yaratildi");
			}
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			System.out.println("ServerSocket acilamadi...");
		}
	}

	@Override
	public void run() {
	}

}
