package com.aa.server;

import java.net.ServerSocket;

import javax.swing.JTextField;

import com.aa.forms.frmOyun;

public class ServerSocketOpen extends Thread {
	
	@SuppressWarnings("unused")
	private ServerSocket socket=null;

	public ServerSocketOpen(JTextField txtPortAc, int QUEUELENGTH) {
	try 
	{
		socket = new ServerSocket(Integer.parseInt(txtPortAc.getText()), QUEUELENGTH);
		@SuppressWarnings("unused")
		frmOyun oyunPenceresi = new frmOyun();
		System.out.println("ServerSocket açýldý...");
	}
	catch (Exception e) 
	{
		e.printStackTrace();
		System.out.println("ServerSocket açýlmadý...");
	}

	}
	
	@Override
	public void run() {
	}

}
