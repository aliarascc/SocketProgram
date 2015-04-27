package com.aa.server;

import java.net.ServerSocket;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Server_SocketClose{
	private JFrame frame;
	public Server_SocketClose(ServerSocket socket)
	{
		
		System.out.println("socket closing...");
		try 
		{
			socket.close();
			System.out.println("socket has been closed!");
			JOptionPane.showMessageDialog(frame,"socket has been closed!");
		} 
		catch (Exception e) 
		{
			System.out.println("socket doesn't closed...  ERROR!! "+e);
			JOptionPane.showMessageDialog(frame,"socket doesn't closed...");
		}
		
	}
	
}
