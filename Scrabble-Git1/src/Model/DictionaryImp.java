package Model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DictionaryImp implements Dictionary {
	//holds all words in words.txt
	List<String> allWords = new ArrayList<String>();

	/**
	 * reads all words and contains these word on the allWords arraylist
	 */
	public DictionaryImp() {
		// Reads all word from file
		BufferedReader br = null;
		try {
			String sCurrentLine;
			br = new BufferedReader(new FileReader("words.txt"));

			while ((sCurrentLine = br.readLine()) != null) {
				System.out.println(sCurrentLine);
				allWords.add(sCurrentLine.toUpperCase());
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	/**
	 * check is given word included on the dictionary
	 * @param word: given word
	 * @return true or false
	 */
	public boolean isValidString(String word) 
	{
		boolean result = false;

		for (String curVal : allWords) 
		{
			if (curVal.equalsIgnoreCase(word))
			{
				result = true;
				break;
			}
		}

		return result;
	}

}
