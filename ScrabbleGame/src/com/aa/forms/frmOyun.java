package com.aa.forms;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import com.aa.entity.ScrabbleGameOyunKurEntity;

import java.awt.BorderLayout;

public class frmOyun extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private int X, Y;
	private GridLayout gridLayout;
	private JPanel panel;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmOyun frame = new frmOyun();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void initComponent() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 520, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(1, 0, 0, 0));

		JButton btnHamle = new JButton("hamle");
		contentPane.add(btnHamle, BorderLayout.SOUTH);

	}

	public frmOyun() {
		initComponent();

	}

	public frmOyun(ScrabbleGameOyunKurEntity oyunEntity) {
		if (oyunEntity.get_portAc().equals("")
				|| oyunEntity.get_portAc().getText().length() > 5) {


		} else {
			if (!oyunEntity.get_oyunAlaniX().getText().equals("")
					&& !oyunEntity.get_oyunAlaniY().getText().equals("")) {
				X = Integer.parseInt(oyunEntity.get_oyunAlaniX().getText());
				Y = Integer.parseInt(oyunEntity.get_oyunAlaniY().getText());
				gridLayout = new GridLayout(X, Y, 0, 0);

				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				setBounds(100, 100, 450, 300);
				contentPane = new JPanel();
				contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
				setContentPane(contentPane);
				contentPane.setLayout(new BorderLayout(0, 0));
				panel = new JPanel();
				panel.setLayout(gridLayout);

				for (int i = 0; i < gridLayout.getColumns(); i++) {
					panel.add(new JButton("C" + i));
					for (int j = 0; j < gridLayout.getRows() - 1; j++) {
						panel.add(new JButton("R" + j));
					}
				}
				contentPane.add(panel, BorderLayout.NORTH);
				contentPane.add(new JButton("hamle"), BorderLayout.SOUTH);
			} else {
				JOptionPane.showMessageDialog(null,
						"X ve/veya Y degeri hatali", "Hata",
						JOptionPane.ERROR_MESSAGE);
			}
		}

	}

}
