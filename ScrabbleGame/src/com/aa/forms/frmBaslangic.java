package com.aa.forms;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.aa.client.ClientSocketConnect;
import com.aa.server.ServerSocketOpen;

public class frmBaslangic extends JFrame {

	private static final long serialVersionUID = 4762920613443636070L;
	private JPanel contentPane;
	private JTextField txtOyunAlaniX;
	private JTextField txtOyunAlaniY;
	private JLabel lblKullanlmazBlgeSays;
	private JTextField txtKullanilmazBolgeSayisi;
	private JLabel lblKazanmaPuan;
	private JTextField textField;
	private JLabel lblToplamOyun;
	private JTextField txtToplamOyun;
	private JLabel lbl2xSayisi;
	private JLabel lbl3xSayisi;
	private JTextField txt2xSayisi;
	private JTextField txt3xSayisi;
	private JLabel lblOyunaKatil;
	private JTextField txtIp;
	private JTextField txtPortAc;
	private JTextField txtPortBaglan;
	private JTextField txtKullaniciAdi;
	private JButton btnOyunKur;
	private JLabel lblIp;
	private JLabel lblPortAc;
	private JLabel lblOyunKurun;
	private JLabel lblOyunAlaniX;
	private JLabel lblOyunAlaniY;
	private JLabel lblPortKatil;
	private JLabel lblKullaniciAdi;
	private JButton btnOyunaKatil;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmBaslangic frame = new frmBaslangic();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void initComponent() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 529, 348);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblOyunKurun = new JLabel("Oyun Kurun");
		lblOyunKurun.setForeground(Color.BLUE);
		lblOyunKurun.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lblOyunKurun.setBounds(238, 11, 89, 14);
		contentPane.add(lblOyunKurun);

		lblOyunAlaniX = new JLabel("Oyun Alan\u0131 X:");
		lblOyunAlaniX.setBounds(32, 36, 81, 14);
		contentPane.add(lblOyunAlaniX);

		txtOyunAlaniX = new JTextField();
		txtOyunAlaniX.setBounds(157, 36, 105, 20);
		contentPane.add(txtOyunAlaniX);
		txtOyunAlaniX.setColumns(10);

		lblOyunAlaniY = new JLabel("Oyun Alan\u0131 Y:");
		lblOyunAlaniY.setBounds(32, 59, 81, 14);
		contentPane.add(lblOyunAlaniY);

		txtOyunAlaniY = new JTextField();
		txtOyunAlaniY.setColumns(10);
		txtOyunAlaniY.setBounds(157, 59, 105, 20);
		contentPane.add(txtOyunAlaniY);

		lblKullanlmazBlgeSays = new JLabel(
				"Kullan\u0131lmaz B\u00F6lge Say\u0131s\u0131:");
		lblKullanlmazBlgeSays.setBounds(32, 84, 155, 14);
		contentPane.add(lblKullanlmazBlgeSays);

		txtKullanilmazBolgeSayisi = new JTextField();
		txtKullanilmazBolgeSayisi.setBounds(157, 82, 105, 20);
		contentPane.add(txtKullanilmazBolgeSayisi);
		txtKullanilmazBolgeSayisi.setColumns(10);

		lblKazanmaPuan = new JLabel("Kazanma Puan\u0131:");
		lblKazanmaPuan.setBounds(32, 105, 114, 14);
		contentPane.add(lblKazanmaPuan);

		textField = new JTextField();
		textField.setBounds(157, 105, 105, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		lblToplamOyun = new JLabel("Toplam Oyun:");
		lblToplamOyun.setBounds(281, 39, 114, 14);
		contentPane.add(lblToplamOyun);

		txtToplamOyun = new JTextField();
		txtToplamOyun.setBounds(365, 36, 105, 20);
		contentPane.add(txtToplamOyun);
		txtToplamOyun.setColumns(10);

		lbl2xSayisi = new JLabel("2x Say\u0131s\u0131:");
		lbl2xSayisi.setBounds(281, 62, 65, 14);
		contentPane.add(lbl2xSayisi);

		lbl3xSayisi = new JLabel("3x Say\u0131s\u0131:");
		lbl3xSayisi.setBounds(281, 85, 65, 14);
		contentPane.add(lbl3xSayisi);

		txt2xSayisi = new JTextField();
		txt2xSayisi.setBounds(365, 59, 105, 20);
		contentPane.add(txt2xSayisi);
		txt2xSayisi.setColumns(10);

		txt3xSayisi = new JTextField();
		txt3xSayisi.setBounds(365, 82, 105, 20);
		contentPane.add(txt3xSayisi);
		txt3xSayisi.setColumns(10);

		lblOyunaKatil = new JLabel("Oyuna Kat\u0131l");
		lblOyunaKatil.setForeground(Color.BLUE);
		lblOyunaKatil.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lblOyunaKatil.setBounds(238, 167, 89, 14);
		contentPane.add(lblOyunaKatil);

		btnOyunKur = new JButton("Oyun Kur");
		btnOyunKur.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				if (txtPortAc.getText().length() > 5||txtPortAc.getText().equalsIgnoreCase("")) 
				{
					JOptionPane.showMessageDialog(getContentPane(), "port numarasý 5 basamaklýdan büyük olamaz...\nport numarasý boþ olamaz...");
				}
				else 
				{
					try 
					{
						@SuppressWarnings("unused")
						ServerSocketOpen serversocketAc = new ServerSocketOpen(txtPortAc,10);

					}
					catch (Exception e) 
					{
						e.printStackTrace();
					}
				}

			}
		});
		btnOyunKur.setFont(new Font("Showcard Gothic", Font.PLAIN, 11));
		btnOyunKur.setBounds(32, 133, 438, 23);
		contentPane.add(btnOyunKur);

		lblIp = new JLabel("IP:");
		lblIp.setBounds(188, 192, 14, 14);
		contentPane.add(lblIp);

		txtIp = new JTextField();
		txtIp.setBounds(278, 189, 99, 20);
		contentPane.add(txtIp);
		txtIp.setColumns(10);

		txtPortAc = new JTextField();
		txtPortAc.setColumns(10);
		txtPortAc.setBounds(365, 105, 105, 20);
		contentPane.add(txtPortAc);

		lblPortAc = new JLabel("Port:");
		lblPortAc.setBounds(281, 108, 46, 14);
		contentPane.add(lblPortAc);

		lblPortKatil = new JLabel("Port:");
		lblPortKatil.setBounds(188, 217, 46, 14);
		contentPane.add(lblPortKatil);

		txtPortBaglan = new JTextField();
		txtPortBaglan.setColumns(10);
		txtPortBaglan.setBounds(278, 214, 99, 20);
		contentPane.add(txtPortBaglan);

		lblKullaniciAdi = new JLabel("Kullan\u0131c\u0131 Ad\u0131:");
		lblKullaniciAdi.setBounds(188, 243, 80, 14);
		contentPane.add(lblKullaniciAdi);

		txtKullaniciAdi = new JTextField();
		txtKullaniciAdi.setBounds(278, 240, 99, 20);
		contentPane.add(txtKullaniciAdi);
		txtKullaniciAdi.setColumns(10);

		btnOyunaKatil = new JButton("Oyuna Kat\u0131l");
		btnOyunaKatil.addActionListener(new ActionListener() {
			@SuppressWarnings("unused")
			public void actionPerformed(ActionEvent arg0) {
				try {
					ClientSocketConnect clientConnet = new ClientSocketConnect(txtIp,txtPortBaglan);					
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		btnOyunaKatil.setFont(new Font("Showcard Gothic", Font.PLAIN, 11));
		btnOyunaKatil.setBounds(32, 271, 438, 23);
		contentPane.add(btnOyunaKatil);
	}

	public frmBaslangic() {
		setTitle("Kelime Av\u0131 Oyunu Kurulum Ekran\u0131");
		initComponent();
	}
}
