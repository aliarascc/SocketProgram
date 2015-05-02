package com.aa.forms;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import net.miginfocom.swing.MigLayout;

import com.aa.entity.ScrabbleGameSetupEntity;
import com.aa.logic.ElectionLojic;
import com.aa.logic.UniqueRandomNumbers;

public class frmGame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private int X, Y, row, column;;
	private GridLayout gridLayout;
	private JPanel panel_table;
	private JPanel panel_info;
	private JLabel lblOyunBilgileri;
	private JLabel lblOyunAlan;
	private JLabel lblKullanlamazBlgeSays;
	private JLabel lblKazanmaPuan;
	private JLabel lblToplamOyun_;
	private JLabel lbl2xSays;
	private JLabel lbl3xSays;
	private JLabel lblOyuncuListesi;
	private JList<String> list;
	private DefaultListModel<String> oyuncuModel;
	private JPanel panel_play;
	private JLabel lblKelimeniziAaYazn;
	private JTextField txtWord;
	private JButton btnTemizle;
	private JButton btnGonder;
	private JLabel lblOyunAlani;
	private JLabel lblKullanilamazbolgesayisi;
	private JLabel lblKazanmapuani;
	private JLabel lblToplamOyun;
	private JLabel lbl2xSayisi;
	private JLabel lbl3xSayisi;
	private JTextField[][] spot;
	private UniqueRandomNumbers uniqueRandom;
	private ArrayList<JTextField> spotList;
	private ElectionLojic election;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmGame frame = new frmGame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void initComponent() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 520);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		panel_table = new JPanel();
		contentPane.add(panel_table, BorderLayout.NORTH);
		panel_table.setLayout(new GridLayout(1, 0, 0, 0));

		panel_info = new JPanel();
		contentPane.add(panel_info, BorderLayout.WEST);
		panel_info.setLayout(new MigLayout("", "[grow][]",
				"[][][][][][][][][][grow]"));

		lblOyunBilgileri = new JLabel("Oyun Bilgileri");
		lblOyunBilgileri.setFont(new Font("Consolas", Font.BOLD, 11));
		lblOyunBilgileri.setForeground(Color.BLUE);
		lblOyunBilgileri.setBackground(Color.GRAY);
		panel_info.add(lblOyunBilgileri, "cell 0 0");

		lblOyunAlan = new JLabel("Oyun Alan\u0131:");
		panel_info.add(lblOyunAlan, "cell 0 1");

		lblOyunAlani = new JLabel("");
		panel_info.add(lblOyunAlani, "cell 1 1");

		lblKullanlamazBlgeSays = new JLabel(
				"Kullan\u0131lamaz B\u00F6lge Say\u0131s\u0131:");
		lblKullanlamazBlgeSays.setForeground(Color.RED);
		panel_info.add(lblKullanlamazBlgeSays, "cell 0 2");

		lblKullanilamazbolgesayisi = new JLabel("");
		panel_info.add(lblKullanilamazbolgesayisi, "cell 1 2");

		lblKazanmaPuan = new JLabel("Kazanma Puan\u0131:");
		panel_info.add(lblKazanmaPuan, "cell 0 3");

		lblKazanmapuani = new JLabel("");
		panel_info.add(lblKazanmapuani, "cell 1 3");

		lblToplamOyun_ = new JLabel("Toplam Oyun:");
		panel_info.add(lblToplamOyun_, "cell 0 4");

		lblToplamOyun = new JLabel("");
		panel_info.add(lblToplamOyun, "cell 1 4");

		lbl2xSays = new JLabel("2x Say\u0131s\u0131:");
		lbl2xSays.setForeground(Color.YELLOW);
		lbl2xSays.setLabelFor(lbl2xSays);
		panel_info.add(lbl2xSays, "cell 0 5");

		lbl2xSayisi = new JLabel("");
		panel_info.add(lbl2xSayisi, "cell 1 5");

		lbl3xSays = new JLabel("3x Say\u0131s\u0131:");
		lbl3xSays.setForeground(Color.GREEN);
		panel_info.add(lbl3xSays, "cell 0 6");

		lbl3xSayisi = new JLabel("");
		panel_info.add(lbl3xSayisi, "cell 1 6");

		lblOyuncuListesi = new JLabel("Oyuncu Listesi");
		lblOyuncuListesi.setFont(new Font("Consolas", Font.BOLD, 11));
		lblOyuncuListesi.setForeground(Color.BLUE);
		lblOyuncuListesi.setBackground(Color.GRAY);
		panel_info.add(lblOyuncuListesi, "cell 0 8");

		oyuncuModel = new DefaultListModel<String>();
		list = new JList<String>(oyuncuModel);
		panel_info.add(list, "cell 0 9 2 1,grow");

		panel_play = new JPanel();
		contentPane.add(panel_play, BorderLayout.SOUTH);
		panel_play.setLayout(new MigLayout("", "[grow]", "[][]"));

		lblKelimeniziAaYazn = new JLabel(
				"Kelimenizi a\u015Fa\u011F\u0131 yaz\u0131n ve sonra ilk harften ba\u015Flayarak yerle\u015Ftiriniz");
		lblKelimeniziAaYazn.setForeground(Color.BLUE);
		panel_play.add(lblKelimeniziAaYazn, "cell 0 0");

		txtWord = new JTextField();
		panel_play.add(txtWord, "flowx,cell 0 1,growx");
		txtWord.setColumns(10);

		btnTemizle = new JButton("Temizle");
		panel_play.add(btnTemizle, "cell 0 1");

		btnGonder = new JButton("G\u00F6nder");
		panel_play.add(btnGonder, "cell 0 1");

	}

	public frmGame() {
		initComponent();

	}

	public frmGame(ScrabbleGameSetupEntity oyunEntity) {
		if (!oyunEntity.getOyunAlaniX().getText().equals("")&& !oyunEntity.getOyunAlaniY().getText().equals("")) 
		{
			X = Integer.parseInt(oyunEntity.getOyunAlaniX().getText());
			Y = Integer.parseInt(oyunEntity.getOyunAlaniY().getText());

			gridLayout = new GridLayout(X, Y, 0, 0);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 640, 520);
			contentPane = new JPanel();
			contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
			setContentPane(contentPane);
			contentPane.setLayout(new BorderLayout(0, 0));

			panel_table = new JPanel();
			contentPane.add(panel_table, BorderLayout.CENTER);
			panel_table.setLayout(gridLayout);

			panel_info = new JPanel();
			contentPane.add(panel_info, BorderLayout.WEST);
			panel_info.setLayout(new MigLayout("", "[grow][]",
					"[][][][][][][][][][grow]"));

			lblOyunBilgileri = new JLabel("Oyun Bilgileri");
			lblOyunBilgileri.setForeground(Color.BLUE);
			lblOyunBilgileri.setBackground(Color.GRAY);
			panel_info.add(lblOyunBilgileri, "cell 0 0");

			lblOyunAlan = new JLabel("Oyun Alan\u0131:");
			panel_info.add(lblOyunAlan, "cell 0 1");

			lblOyunAlani = new JLabel("");
			panel_info.add(lblOyunAlani, "cell 1 1");

			lblKullanlamazBlgeSays = new JLabel(
					"Kullan\u0131lamaz B\u00F6lge Say\u0131s\u0131:");
			panel_info.add(lblKullanlamazBlgeSays, "cell 0 2");

			lblKullanilamazbolgesayisi = new JLabel("");
			panel_info.add(lblKullanilamazbolgesayisi, "cell 1 2");

			lblKazanmaPuan = new JLabel("Kazanma Puan\u0131:");
			panel_info.add(lblKazanmaPuan, "cell 0 3");

			lblKazanmapuani = new JLabel("");
			panel_info.add(lblKazanmapuani, "cell 1 3");

			lblToplamOyun_ = new JLabel("Toplam Oyun:");
			panel_info.add(lblToplamOyun_, "cell 0 4");

			lblToplamOyun = new JLabel("");
			panel_info.add(lblToplamOyun, "cell 1 4");

			lbl2xSays = new JLabel("2x Say\u0131s\u0131:");
			lbl2xSays.setForeground(Color.YELLOW);
			lbl2xSays.setLabelFor(lbl2xSays);
			panel_info.add(lbl2xSays, "cell 0 5");

			lbl2xSayisi = new JLabel("");
			panel_info.add(lbl2xSayisi, "cell 1 5");

			lbl3xSays = new JLabel("3x Say\u0131s\u0131:");
			lbl3xSays.setForeground(Color.GREEN);
			panel_info.add(lbl3xSays, "cell 0 6");

			lbl3xSayisi = new JLabel("");
			panel_info.add(lbl3xSayisi, "cell 1 6");

			lblOyuncuListesi = new JLabel("Oyuncu Listesi");
			lblOyuncuListesi.setForeground(Color.BLUE);
			lblOyuncuListesi.setBackground(Color.GRAY);
			panel_info.add(lblOyuncuListesi, "cell 0 8");

			oyuncuModel = new DefaultListModel<String>();
			oyuncuModel.add(0, oyunEntity.getGamername().toString());
			list = new JList<String>(oyuncuModel);
			panel_info.add(list, "cell 0 9 2 1,grow");

			panel_play = new JPanel();
			contentPane.add(panel_play, BorderLayout.SOUTH);
			panel_play.setLayout(new MigLayout("", "[grow]", "[][]"));

			lblKelimeniziAaYazn = new JLabel(
					"Kelimenizi a\u015Fa\u011F\u0131 yaz\u0131n ve sonra ilk harften ba\u015Flayarak yerle\u015Ftiriniz");
			lblKelimeniziAaYazn.setForeground(Color.BLUE);
			panel_play.add(lblKelimeniziAaYazn, "cell 0 0");

			txtWord = new JTextField();
			panel_play.add(txtWord, "flowx,cell 0 1,growx");
			txtWord.setColumns(10);

			btnTemizle = new JButton("Temizle");
			panel_play.add(btnTemizle, "cell 0 1");

			btnGonder = new JButton("G\u00F6nder");
			panel_play.add(btnGonder, "cell 0 1");

			spot = new JTextField[gridLayout.getRows()][gridLayout.getColumns()];
			spotList = new ArrayList<JTextField>();

			lblKazanmapuani.setText(oyunEntity.getKazanmaPuani().getText().toString());
			lbl2xSayisi.setText(oyunEntity.getSayi2x().getText().toString());
			lbl3xSayisi.setText(oyunEntity.getSayi3x().getText().toString());
			lblKullanilamazbolgesayisi.setText(oyunEntity.getKullanilmazBolgeSayisi().getText().toString());
			lblOyunAlani.setText(oyunEntity.getOyunAlaniX().getText().toString()+ "x" + oyunEntity.getOyunAlaniY().getText().toString());
			lblToplamOyun.setText(oyunEntity.getToplamOyun().getText().toString());

			oyunEntity.getDictionary();
			uniqueRandom = new UniqueRandomNumbers(X,Y);

			for (int i = 0; i < gridLayout.getColumns(); i++) {
				for (int j = 0; j < gridLayout.getRows(); j++) {
					spot[i][j] = new JTextField(i + "," + j);
					spotList.add(spot[i][j]);
					oyunEntity.setSpotList(spotList);
					panel_table.add(spot[i][j]);
				}
			}
			election = new ElectionLojic(oyunEntity);

			for (int k = 0; k < Integer.parseInt(oyunEntity.getKullanilmazBolgeSayisi().getText()); k++) 
			{
				election.getUniqueSpot().setVisible(false);;
			}

			for (int i = 0; i < Integer.parseInt(oyunEntity.getSayi2x().getText()); i++) {
				//row = uniqueRandom.getUniqueX();
				//column = uniqueRandom.getUniqueY();
				//spot[row][column].setBackground(Color.yellow);
				election.getUniqueSpot().setBackground(Color.yellow);

			}
			for (int i = 0; i < Integer.parseInt(oyunEntity.getSayi3x().getText()); i++) {
				//row = uniqueRandom.getUniqueX();
				//column = uniqueRandom.getUniqueY();
				//spot[row][column].setBackground(Color.green);
				election.getUniqueSpot().setBackground(Color.green);
			}

		} else {
			JOptionPane.showMessageDialog(null, "X ve/veya Y degeri hatali",
					"Hata", JOptionPane.ERROR_MESSAGE);
		}
	}

}