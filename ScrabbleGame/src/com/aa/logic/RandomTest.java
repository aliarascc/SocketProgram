package com.aa.logic;

public class RandomTest {

	public static void main(String[] args) {
		
		UniqueRandomNumbers random=new UniqueRandomNumbers(16,16);
		for (int i = 0; i < 16; i++) {
			System.out.println("["+random.getUniqueX()+"]"+","+"["+random.getUniqueY()+"]");
		}

	}

}
