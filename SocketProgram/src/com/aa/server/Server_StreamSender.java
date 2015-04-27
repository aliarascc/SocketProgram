package com.aa.server;

import java.io.DataOutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Server_StreamSender
{
	private Socket client;
	private PrintWriter mSender;
	public Server_StreamSender(Socket client) 
	{
		this.client=client;
		try 
		{
			mSender = new PrintWriter(client.getOutputStream());
		} 
		catch (Exception e) 
		{
			e.printStackTrace();			
		}
		
	}
	
	public void sendMessage(Socket client, String mMessage)
	{
		PrintWriter pWriter = new PrintWriter(mSender);
		pWriter.println();
	}
	

}
