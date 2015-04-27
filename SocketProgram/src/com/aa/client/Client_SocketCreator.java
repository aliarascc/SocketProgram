package com.aa.client;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Client_SocketCreator extends JFrame {

	protected static InetAddress ADDRESS;
	protected static int PORT;
	private JPanel contentPane;
	private JTextField txtPort;
	private JTextField txtIp;
	private JPanel panel_1;
	private JButton btnConnect;
	private JButton btnSendMessage;
	private JTextArea txtrClientmessage;
	private Socket client;
	private Client_StreamSender cSender; 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Client_SocketCreator frame = new Client_SocketCreator();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	private void initComponent() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 402, 199);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);

		JLabel lblPort = new JLabel("Port:");
		panel.add(lblPort);

		txtPort = new JTextField();
		panel.add(txtPort);
		txtPort.setColumns(10);

		JLabel lblIp = new JLabel("IP");
		panel.add(lblIp);

		txtIp = new JTextField();
		panel.add(txtIp);
		txtIp.setColumns(10);

		panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);

		btnConnect = new JButton("Connect");
		btnConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try 
				{
					ADDRESS = InetAddress.getByName(txtIp.getText());
					PORT = Integer.parseInt(txtPort.getText());
					client = new Socket(ADDRESS, PORT);
					System.out.println("client ip ve portu aldi");

				} 
				catch (Exception e2) 
				{
					e2.printStackTrace();
				}

			}
		});
		panel_1.add(btnConnect);

		
		btnSendMessage = new JButton("Send Message");
		btnSendMessage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try 
				{
					
					cSender = new Client_StreamSender(client,txtrClientmessage);	
					
				} catch (Exception e2) {
					e2.printStackTrace();
				}

			}
		});
		panel_1.add(btnSendMessage);

		txtrClientmessage = new JTextArea();
		contentPane.add(txtrClientmessage, BorderLayout.CENTER);

	}

	public Client_SocketCreator() {
		try {

		} catch (Exception e) {
			e.printStackTrace();
		}

		initComponent();

	}

}
