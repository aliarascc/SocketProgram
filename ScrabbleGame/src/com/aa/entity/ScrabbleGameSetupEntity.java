package com.aa.entity;

import javax.swing.JTextField;

public class ScrabbleGameSetupEntity {
	private JTextField oyunAlaniX;
	private JTextField oyunAlaniY;
	private JTextField kullanilmazBolgeSayisi;
	private JTextField kazanmaPuani;
	private JTextField toplamOyun;
	private JTextField sayi2x;
	private JTextField sayi3x;
	private JTextField portAc;
	private int QUEUELENGTH;

	public JTextField get_oyunAlaniX() {
		return oyunAlaniX;
	}

	public void set_oyunAlaniX(JTextField _oyunAlaniX) {
		this.oyunAlaniX = _oyunAlaniX;
	}

	public JTextField get_oyunAlaniY() {
		return oyunAlaniY;
	}

	public void set_oyunAlaniY(JTextField _oyunAlaniY) {
		this.oyunAlaniY = _oyunAlaniY;
	}

	public JTextField get_kullanilmazBolgeSayisi() {
		return kullanilmazBolgeSayisi;
	}

	public void set_kullanilmazBolgeSayisi(JTextField _kullanilmazBolgeSayisi) {
		this.kullanilmazBolgeSayisi = _kullanilmazBolgeSayisi;
	}

	public JTextField get_kazanmaPuani() {
		return kazanmaPuani;
	}

	public void set_kazanmaPuani(JTextField _kazanmaPuani) {
		this.kazanmaPuani = _kazanmaPuani;
	}

	public JTextField get_toplamOyun() {
		return toplamOyun;
	}

	public void set_toplamOyun(JTextField _toplamOyun) {
		this.toplamOyun = _toplamOyun;
	}

	public JTextField get_sayi2x() {
		return sayi2x;
	}

	public void set_sayi2x(JTextField _sayi2x) {
		this.sayi2x = _sayi2x;
	}

	public JTextField get_sayi3x() {
		return sayi3x;
	}

	public void set_sayi3x(JTextField _sayi3x) {
		this.sayi3x = _sayi3x;
	}

	public JTextField get_portAc() {
		return portAc;
	}

	public void set_portAc(JTextField _portAc) {
		this.portAc = _portAc;
	}

	public int getQUEUELENGTH() {
		return QUEUELENGTH;
	}

	public void setQUEUELENGTH(int qUEUELENGTH) {
		QUEUELENGTH = qUEUELENGTH;
	}

}
