package com.aa.forms;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.aa.client.ClientSocketConnect;
import com.aa.dictionary.DictionaryList;
import com.aa.entity.ScrabbleGameSetupEntity;
import com.aa.server.ServerSocketOpen;

import javax.swing.JComboBox;

public class frmStart extends JFrame {

	private static final long serialVersionUID = 4762920613443636070L;
	private JPanel contentPane;
	private JTextField txtOyunAlaniX;
	private JTextField txtOyunAlaniY;
	private JLabel lblKullanlmazBlgeSays;
	private JTextField txtKullanilmazBolgeSayisi;
	private JLabel lblKazanmaPuan;
	private JTextField txtKazanmaPuani;
	private JLabel lblToplamOyun;
	private JTextField txtToplamOyun;
	private JLabel lbl2xSayisi;
	private JLabel lbl3xSayisi;
	private JTextField txt2xSayisi;
	private JTextField txt3xSayisi;
	private JLabel lblOyunaKatil;
	private JTextField txtIp;
	private JTextField txtPortAc;
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
	private JComboBox<String> cmbPortBaglan;
	private DictionaryList dictionary;
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmStart frame = new frmStart();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void initComponent() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 547, 357);
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
		lblOyunAlaniX.setBounds(6, 36, 139, 14);
		contentPane.add(lblOyunAlaniX);

		txtOyunAlaniX = new JTextField();
		txtOyunAlaniX.setBounds(166, 36, 113, 20);
		contentPane.add(txtOyunAlaniX);
		txtOyunAlaniX.setColumns(10);

		lblOyunAlaniY = new JLabel("Oyun Alan\u0131 Y:");
		lblOyunAlaniY.setBounds(6, 59, 139, 14);
		contentPane.add(lblOyunAlaniY);

		txtOyunAlaniY = new JTextField();
		txtOyunAlaniY.setColumns(10);
		txtOyunAlaniY.setBounds(166, 59, 113, 20);
		contentPane.add(txtOyunAlaniY);

		lblKullanlmazBlgeSays = new JLabel(
				"Kullan\u0131lmaz B\u00F6lge Say\u0131s\u0131:");
		lblKullanlmazBlgeSays.setBounds(6, 84, 155, 14);
		contentPane.add(lblKullanlmazBlgeSays);

		txtKullanilmazBolgeSayisi = new JTextField();
		txtKullanilmazBolgeSayisi.setBounds(166, 82, 113, 20);
		contentPane.add(txtKullanilmazBolgeSayisi);
		txtKullanilmazBolgeSayisi.setColumns(10);

		lblKazanmaPuan = new JLabel("Kazanma Puan\u0131:");
		lblKazanmaPuan.setBounds(6, 105, 139, 14);
		contentPane.add(lblKazanmaPuan);

		txtKazanmaPuani = new JTextField();
		txtKazanmaPuani.setBounds(166, 105, 113, 20);
		contentPane.add(txtKazanmaPuani);
		txtKazanmaPuani.setColumns(10);

		lblToplamOyun = new JLabel("Toplam Oyun:");
		lblToplamOyun.setBounds(302, 42, 114, 14);
		contentPane.add(lblToplamOyun);

		txtToplamOyun = new JTextField();
		txtToplamOyun.setBounds(407, 36, 116, 20);
		contentPane.add(txtToplamOyun);
		txtToplamOyun.setColumns(10);

		lbl2xSayisi = new JLabel("2x Say\u0131s\u0131:");
		lbl2xSayisi.setBounds(302, 65, 65, 14);
		contentPane.add(lbl2xSayisi);

		lbl3xSayisi = new JLabel("3x Say\u0131s\u0131:");
		lbl3xSayisi.setBounds(302, 88, 65, 14);
		contentPane.add(lbl3xSayisi);

		txt2xSayisi = new JTextField();
		txt2xSayisi.setBounds(407, 59, 116, 20);
		contentPane.add(txt2xSayisi);
		txt2xSayisi.setColumns(10);

		txt3xSayisi = new JTextField();
		txt3xSayisi.setBounds(407, 82, 116, 20);
		contentPane.add(txt3xSayisi);
		txt3xSayisi.setColumns(10);

		lblOyunaKatil = new JLabel("Oyuna Kat\u0131l");
		lblOyunaKatil.setForeground(Color.BLUE);
		lblOyunaKatil.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lblOyunaKatil.setBounds(238, 167, 89, 14);
		contentPane.add(lblOyunaKatil);

		btnOyunKur = new JButton("Oyun Kur");
		dictionary = new DictionaryList();
		btnOyunKur.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				try {
					ScrabbleGameSetupEntity oyunKur = new ScrabbleGameSetupEntity();
					//ScrabbleGameEnterEntity oyunBaglan = new ScrabbleGameEnterEntity();
					oyunKur.setPortAc(txtPortAc);
					oyunKur.setKazanmaPuani(txtKazanmaPuani);
					oyunKur.setKullanilmazBolgeSayisi(txtKullanilmazBolgeSayisi);
					oyunKur.setOyunAlaniX(txtOyunAlaniX);
					oyunKur.setOyunAlaniY(txtOyunAlaniY);
					oyunKur.setSayi2x(txt2xSayisi);
					oyunKur.setSayi3x(txt3xSayisi);
					oyunKur.setToplamOyun(txtToplamOyun);
					oyunKur.setQUEUELENGTH(10);
					oyunKur.setGamername("aliaras");
					cmbPortBaglan.addItem(txtPortAc.getText().toString());
					oyunKur.setDictionary(dictionary);
					
					@SuppressWarnings("unused")
					ServerSocketOpen serversocketAc = new ServerSocketOpen(oyunKur);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		});
		btnOyunKur.setFont(new Font("Showcard Gothic", Font.PLAIN, 11));
		btnOyunKur.setBounds(6, 133, 517, 23);
		contentPane.add(btnOyunKur);

		lblIp = new JLabel("IP:");
		lblIp.setBounds(166, 192, 100, 14);
		contentPane.add(lblIp);

		txtIp = new JTextField();
		txtIp.setBounds(278, 189, 99, 20);
		contentPane.add(txtIp);
		txtIp.setColumns(10);

		txtPortAc = new JTextField();
		txtPortAc.setColumns(10);
		txtPortAc.setBounds(407, 105, 116, 20);
		contentPane.add(txtPortAc);

		lblPortAc = new JLabel("Port:");
		lblPortAc.setBounds(302, 111, 46, 14);
		contentPane.add(lblPortAc);

		lblPortKatil = new JLabel("Port:");
		lblPortKatil.setBounds(166, 217, 100, 14);
		contentPane.add(lblPortKatil);

		lblKullaniciAdi = new JLabel("Kullan\u0131c\u0131 Ad\u0131:");
		lblKullaniciAdi.setBounds(166, 243, 100, 14);
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
					ClientSocketConnect clientConnet = new ClientSocketConnect(
							txtIp, cmbPortBaglan);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		btnOyunaKatil.setFont(new Font("Showcard Gothic", Font.PLAIN, 11));
		btnOyunaKatil.setBounds(6, 271, 517, 23);
		contentPane.add(btnOyunaKatil);
		
		cmbPortBaglan = new JComboBox<String>();
		cmbPortBaglan.setBounds(278, 214, 99, 20);
		contentPane.add(cmbPortBaglan);
	}

	public frmStart() {
		setTitle("Kelime Av\u0131 Oyunu Kurulum Ekran\u0131");
		initComponent();
	}
}
