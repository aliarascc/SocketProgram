package com.aa.server;

import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.DefaultListModel;
import javax.swing.JList;

public class Server_ClientHandler extends Thread {
	private Socket client;
	private ServerSocket socket;
	private JList<String> list;
	private DefaultListModel<String> model;
	
	public Server_ClientHandler(ServerSocket socket,JList<String> list, DefaultListModel<String> model)
	{
		this.socket = socket;		
		this.list = list;
		this.model = model;
	}
		
	@Override
	public void run() {
		super.run();
		System.out.println("client waiting...");
		try 
		{
			do
			{
			client = socket.accept();
			System.out.println("client connected!");
			Server_StreamHandler mHandler = new Server_StreamHandler(client, list, model);
			mHandler.start();
			}
			while(true);
		} 
		catch (Exception e) 
		{
			System.out.println("client doesn't accepted  ERROR! "+e);
		}
	}

}
