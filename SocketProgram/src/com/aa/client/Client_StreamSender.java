package com.aa.client;

import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JTextArea;

public class Client_StreamSender extends Thread
{
	public Client_StreamSender(Socket client,JTextArea txtMessage)
	{
		try 
		{
			PrintWriter pWriter = new PrintWriter(client.getOutputStream(),true);
			pWriter.println(txtMessage.getText());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
