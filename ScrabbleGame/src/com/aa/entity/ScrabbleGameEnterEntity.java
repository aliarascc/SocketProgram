package com.aa.entity;

import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JTextField;

public class ScrabbleGameEnterEntity {
	private JList<String> list;
	private DefaultListModel<String> model;
	private JTextField ip;
	private JTextField kullaniciAdi;
	private JComboBox<String> portBaglan;

	public JTextField getIp() {
		return ip;
	}

	public void setIp(JTextField ip) {
		this.ip = ip;
	}

	public JTextField getKullaniciAdi() {
		return kullaniciAdi;
	}

	public void setKullaniciAdi(JTextField kullaniciAdi) {
		this.kullaniciAdi = kullaniciAdi;
	}

	public JComboBox<String> getPortBaglan() {
		return portBaglan;
	}

	public void setPortBaglan(JComboBox<String> portBaglan) {
		this.portBaglan = portBaglan;
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

}
