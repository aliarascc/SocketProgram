package com.aa.logic;
import java.util.ArrayList;


public class UsernameControl {
	public ArrayList<String> usernames;
	
	public UsernameControl()
	{
		usernames = new ArrayList<String>();
	}

	public void addUsername(String uname)
	{
		usernames.add(0, uname);
	}
	private void addUsername()
	{
		usernames.add(0,"ali");
		usernames.add(0,"aras");
		usernames.add(0,"nur");
		usernames.add(0,"nilay");
	}
	public boolean controlUsername(String uname)
	{
		usernames.contains(uname);
		return true;
	}
	public String getUsernames()
	{
			return usernames.get(0);
	}
	
	
	public static void main(String args[])
	{
		UsernameControl u = new UsernameControl();
		if (u.controlUsername("ali")) 
		{
			System.out.println("bu kullanici adi alinmis");
		}
		else
		{
			u.addUsername();
		}
		u.addUsername();
		System.out.println(u.getUsernames());
		
	}

}
