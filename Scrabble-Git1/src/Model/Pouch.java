package Model;

import java.util.Random;

/**
 * Letter bag, letter marks, letter frequencies.
 * @author veyselo
 *
 */

public class Pouch {
	
	private static Pouch instance = new Pouch();
	String[][] letterInfo = new String[26][3];

	private Pouch() {
		letterInfo[0][0] = "A"; // Name
		letterInfo[0][1] = "9";// Count
		letterInfo[0][2] = "1"; // Mark

		letterInfo[1][0] = "B"; // Name
		letterInfo[1][1] = "2"; // Count
		letterInfo[1][2] = "3"; // Mark

		letterInfo[2][0] = "C"; // Name
		letterInfo[2][1] = "2"; // Count
		letterInfo[2][2] = "3"; // Mark

		letterInfo[3][0] = "D"; // Name
		letterInfo[3][1] = "4"; // Count
		letterInfo[3][2] = "2"; // Mark

		letterInfo[4][0] = "E"; // Name
		letterInfo[4][1] = "12"; // Count
		letterInfo[4][2] = "1"; // Mark

		letterInfo[5][0] = "F"; // Name
		letterInfo[5][1] = "2"; // Count
		letterInfo[5][2] = "4"; // Mark

		letterInfo[6][0] = "G"; // Name
		letterInfo[6][1] = "3"; // Count
		letterInfo[6][2] = "2"; // Mark

		letterInfo[7][0] = "H"; // Name
		letterInfo[7][1] = "2"; // Count
		letterInfo[7][2] = "4"; // Mark

		letterInfo[8][0] = "I"; // Name
		letterInfo[8][1] = "9"; // Count
		letterInfo[8][2] = "1"; // Mark

		letterInfo[9][0] = "J"; // Name
		letterInfo[9][1] = "1"; // Count
		letterInfo[9][2] = "8"; // Mark

		letterInfo[10][0] = "K"; // Name
		letterInfo[10][1] = "1"; // Count
		letterInfo[10][2] = "5"; // Mark

		letterInfo[11][0] = "L"; // Name
		letterInfo[11][1] = "4"; // Count
		letterInfo[11][2] = "1"; // Mark

		letterInfo[12][0] = "M"; // Name
		letterInfo[12][1] = "2"; // Count
		letterInfo[12][2] = "3"; // Mark

		letterInfo[13][0] = "N"; // Name
		letterInfo[13][1] = "6"; // Count
		letterInfo[13][2] = "1"; // Mark

		letterInfo[14][0] = "O"; // Name
		letterInfo[14][1] = "8"; // Count
		letterInfo[14][2] = "1"; // Mark

		letterInfo[15][0] = "P"; // Name
		letterInfo[15][1] = "2"; // Count
		letterInfo[15][2] = "3"; // Mark

		letterInfo[16][0] = "Q"; // Name
		letterInfo[16][1] = "1"; // Count
		letterInfo[16][2] = "10"; // Mark

		letterInfo[17][0] = "S"; // Name
		letterInfo[17][1] = "4"; // Count
		letterInfo[17][2] = "1"; // Mark

		letterInfo[18][0] = "T"; // Name
		letterInfo[18][1] = "6"; // Count
		letterInfo[18][2] = "1"; // Mark

		letterInfo[19][0] = "U"; // Name
		letterInfo[19][1] = "4"; // Count
		letterInfo[19][2] = "1"; // Mark

		letterInfo[20][0] = "V"; // Name
		letterInfo[20][1] = "2"; // Count
		letterInfo[20][2] = "4"; // Mark

		letterInfo[21][0] = "W"; // Name
		letterInfo[21][1] = "2"; // Count
		letterInfo[21][2] = "4"; // Mark

		letterInfo[22][0] = "X"; // Name
		letterInfo[22][1] = "1"; // Count
		letterInfo[22][2] = "8"; // Mark

		letterInfo[23][0] = "Y"; // Name
		letterInfo[23][1] = "2"; // Count
		letterInfo[23][2] = "4"; // Mark

		letterInfo[24][0] = "Z"; // Name
		letterInfo[24][1] = "1"; // Count
		letterInfo[24][2] = "10"; // Mark

		letterInfo[25][0] = "R"; // Name
		letterInfo[25][1] = "6"; // Count
		letterInfo[25][2] = "1"; // Mark
	}

	public static Pouch getInstance() {
		return instance;
	}

	/**
	 * Generate random letters from current pouch. 
	 * @return If all letters are used returns empty string, otherwise random letter
	 */
	public String[] getRandomLetter() 
	{
		int random = 0;
		while (true) {
			Random r = new Random();
			random = r.nextInt(25);

			if (Integer.parseInt(letterInfo[random][1]) >= 1) {
				letterInfo[random][1] = (Integer
						.parseInt(letterInfo[random][1]) - 1) + "";
				break;
			} else {
				boolean found = false;
				// iterate all list and find letter
				for (int i = 0; i < 26; i++) {
					if (Integer.parseInt(letterInfo[(random + 1 + i) % 26][1]) >= 1) {
						letterInfo[random][1] = (Integer
								.parseInt(letterInfo[random][1]) - 1) + "";
						found = true;
						break;
					}
				}
				if (!found) {
					String temp[][] = new String[1][3];
					temp[1][0] = "";// name
					temp[2][0] = "";// count
					temp[3][0] = "";// mark
					return temp[0];
				}
			}
		}
		return letterInfo[random];
	}

	/**
	 * Check mark of the given letter from current datalist
	 * @param letter
	 * @return
	 */
	public int getMarkForGivenLetter(String letter) {
		int result = 0;
		for (int i = 0; i < 26; i++) {
			if (letterInfo[i][0].equalsIgnoreCase(letter)) {
				result = Integer.parseInt(letterInfo[i][2]);
			}
		}
		return result;
	}
}
