package com.aa.entity;

import javax.swing.JTextField;

public class ScrabbleGameOyunKurEntity {
	private JTextField _oyunAlaniX;
	private JTextField _oyunAlaniY;
	private JTextField _kullanilmazBolgeSayisi;
	private JTextField _kazanmaPuani;
	private JTextField _toplamOyun;
	private JTextField _sayi2x;
	private JTextField _sayi3x;
	private JTextField _portAc;
	private int QUEUELENGTH;

	public JTextField get_oyunAlaniX() {
		return _oyunAlaniX;
	}

	public void set_oyunAlaniX(JTextField _oyunAlaniX) {
		this._oyunAlaniX = _oyunAlaniX;
	}

	public JTextField get_oyunAlaniY() {
		return _oyunAlaniY;
	}

	public void set_oyunAlaniY(JTextField _oyunAlaniY) {
		this._oyunAlaniY = _oyunAlaniY;
	}

	public JTextField get_kullanilmazBolgeSayisi() {
		return _kullanilmazBolgeSayisi;
	}

	public void set_kullanilmazBolgeSayisi(JTextField _kullanilmazBolgeSayisi) {
		this._kullanilmazBolgeSayisi = _kullanilmazBolgeSayisi;
	}

	public JTextField get_kazanmaPuani() {
		return _kazanmaPuani;
	}

	public void set_kazanmaPuani(JTextField _kazanmaPuani) {
		this._kazanmaPuani = _kazanmaPuani;
	}

	public JTextField get_toplamOyun() {
		return _toplamOyun;
	}

	public void set_toplamOyun(JTextField _toplamOyun) {
		this._toplamOyun = _toplamOyun;
	}

	public JTextField get_sayi2x() {
		return _sayi2x;
	}

	public void set_sayi2x(JTextField _sayi2x) {
		this._sayi2x = _sayi2x;
	}

	public JTextField get_sayi3x() {
		return _sayi3x;
	}

	public void set_sayi3x(JTextField _sayi3x) {
		this._sayi3x = _sayi3x;
	}

	public JTextField get_portAc() {
		return _portAc;
	}

	public void set_portAc(JTextField _portAc) {
		this._portAc = _portAc;
	}

	public int getQUEUELENGTH() {
		return QUEUELENGTH;
	}

	public void setQUEUELENGTH(int qUEUELENGTH) {
		QUEUELENGTH = qUEUELENGTH;
	}

}
