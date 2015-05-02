package com.aa.entity;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JTextField;

public class ScrabbleGameEnterEntity {
	private JList<String> list;
	private DefaultListModel<String> model;
	private JTextField ip;
	private JTextField kullaniciAdi;
	private JTextField portBaglan;
	private String gamername;
	
	public String getGamername() {
	return gamername;
    }

    public void setGamername(String gamername) {
	this.gamername = gamername;
    }

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

	public JTextField getPortBaglan() {
		return portBaglan;
	}

	public void setPortBaglan(JTextField portBaglan) {
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
