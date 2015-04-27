package com.aa.server;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Server_SocketCreator extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtPort;
	private ServerSocket socket;
	private int PORT, QUEUELENGTH;
	private Server_SocketClose socketClose;
//private Socket client;
	private Server_ClientHandler s_cHandler;
	private JList<String> list;
	public DefaultListModel<String> model;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Server_SocketCreator frame = new Server_SocketCreator();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void initComponent() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 340, 230);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);

		JButton btnOpen = new JButton("open");
		btnOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				QUEUELENGTH = 100;
				PORT = Integer.parseInt(txtPort.getText());
				System.out.println("socket preparing...");
				try {
					socket = new ServerSocket(PORT, QUEUELENGTH);
					System.out.println("socket opening successful");
					Server_ClientHandler mClientHander = new Server_ClientHandler(
							socket, list, model);
					mClientHander.start();
					JOptionPane.showMessageDialog(getContentPane(),
							"socket has been opened!");
				} catch (Exception e) {
					System.out.println("fail " + e);
					JOptionPane.showMessageDialog(getContentPane(), "ERROR! "
							+ e);
				}
			}
		});
		panel.add(btnOpen);

		JButton btnClose = new JButton("close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				socketClose = new Server_SocketClose(socket);
			}
		});
		panel.add(btnClose);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.NORTH);

		JLabel lblPort = new JLabel("PORT");
		panel_1.add(lblPort);

		txtPort = new JTextField();
		panel_1.add(txtPort);
		txtPort.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		model = new DefaultListModel<String>();
		list = new JList<String>(model);
		scrollPane.setViewportView(list);

	}

	public Server_SocketCreator() {
		initComponent();

	}

}
