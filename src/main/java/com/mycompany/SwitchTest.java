package com.mycompany;

public class SwitchTest {

	public static void main(String[] args) {
		int type = 2;
		switch (type) {
			case 1:
			case 2:
			case 3:
				System.out.println("we are in three");
			case 4:
			case 5:
				break;
			default:
				break;
		}

	}

}
