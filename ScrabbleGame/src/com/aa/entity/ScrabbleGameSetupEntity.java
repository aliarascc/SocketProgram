package com.aa.entity;

import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JTextField;

import com.aa.logic.DictionaryList;

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
	private JList<String> list;
	private DefaultListModel<String> model;
	private ArrayList<JButton> spotList;
	private DictionaryList dictionary;

	public ArrayList<JButton> getSpotList() {
		return spotList;
	}

	public void setSpotList(ArrayList<JButton> spotList) {
		this.spotList = spotList;
	}
	
	public DictionaryList getDictionary() {
		return dictionary;
	}

	public void setDictionary(DictionaryList dictionary) {
		this.dictionary = dictionary;
	}

	public JList<String> getList() {
		return list;
	}

	public void setList(JList<String> list) {
		this.list = list;
	}

	public DefaultListModel<String> getModel() {
		return model;
	}

	public void setModel(DefaultListModel<String> model) {
		this.model = model;
	}

	public JTextField getOyunAlaniX() {
		return oyunAlaniX;
	}

	public void setOyunAlaniX(JTextField _oyunAlaniX) {
		this.oyunAlaniX = _oyunAlaniX;
	}

	public JTextField getOyunAlaniY() {
		return oyunAlaniY;
	}

	public void setOyunAlaniY(JTextField _oyunAlaniY) {
		this.oyunAlaniY = _oyunAlaniY;
	}

	public JTextField getKullanilmazBolgeSayisi() {
		return kullanilmazBolgeSayisi;
	}

	public void setKullanilmazBolgeSayisi(JTextField _kullanilmazBolgeSayisi) {
		this.kullanilmazBolgeSayisi = _kullanilmazBolgeSayisi;
	}

	public JTextField getKazanmaPuani() {
		return kazanmaPuani;
	}

	public void setKazanmaPuani(JTextField _kazanmaPuani) {
		this.kazanmaPuani = _kazanmaPuani;
	}

	public JTextField getToplamOyun() {
		return toplamOyun;
	}

	public void setToplamOyun(JTextField _toplamOyun) {
		this.toplamOyun = _toplamOyun;
	}

	public JTextField getSayi2x() {
		return sayi2x;
	}

	public void setSayi2x(JTextField _sayi2x) {
		this.sayi2x = _sayi2x;
	}

	public JTextField getSayi3x() {
		return sayi3x;
	}

	public void setSayi3x(JTextField _sayi3x) {
		this.sayi3x = _sayi3x;
	}

	public JTextField getPortAc() {
		return portAc;
	}

	public void setPortAc(JTextField _portAc) {
		this.portAc = _portAc;
	}

	public int getQUEUELENGTH() {
		return QUEUELENGTH;
	}

	public void setQUEUELENGTH(int qUEUELENGTH) {
		QUEUELENGTH = qUEUELENGTH;
	}

}
