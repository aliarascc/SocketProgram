package com.aa.server;

import java.net.Socket;
import java.util.Scanner;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JTextArea;

public class Server_StreamHandler extends Thread {
	private Scanner mScanner;
	private String mMessage;
	private JTextArea sMessageHandler;
	private JList<String> list;
	private DefaultListModel<String> model;
	private Socket client;

	public Server_StreamHandler(Socket client, JList<String> list, DefaultListModel<String> model) {
		this.list =list;
		this.model=model;
		this.client=client;

		try 
		{
			mScanner = new Scanner(client.getInputStream());
			model = new DefaultListModel<String>();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void run() {
		while (true) {
			System.out.println("message handler calisti");
			mMessage = mScanner.nextLine();
		    model.add(0,mMessage);
			System.out.println(mMessage);
		}
		
	}

}
