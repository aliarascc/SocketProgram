package com.aa.server;

import java.net.ServerSocket;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.aa.entity.EnterEntity;
import com.aa.entity.SetupEntity;
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
	public ServerSocketOpen(SetupEntity oyunEntity, EnterEntity oyunSetup) {
		try {
			if (oyunEntity.getPortAc().getText().length() > 5|| 
			   (oyunEntity.getPortAc().getText().toString().equals("")&& 
			    oyunEntity.getOyunAlaniX().getText().toString().equals("")&&
			    oyunEntity.getOyunAlaniY().getText().toString().equals(""))) 
			{
				JOptionPane.showMessageDialog(null,"port numarasi hatali girildi\nX ve/veya Y degerleri hatali girildi",
								"Hata", JOptionPane.ERROR_MESSAGE);
			} 
			else 
			{							
				socket = new ServerSocket(Integer.parseInt(oyunEntity.getPortAc().getText().toString()),oyunEntity.getQUEUELENGTH());
				System.out.println("ServerSocket acildi...");
				frmGame oyun = new frmGame(oyunEntity, oyunSetup);
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
