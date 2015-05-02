package Model;

import java.util.List;

import View.AttackLetter;

/**
 * Data structure for user
 * @author dmalbora
 *
 */

public class User implements IUser {

	private int id;
	private String name;
	private int score;
	
	// Name
	// Count
	// Mark
	private String[][] letterList = new String[7][3];
	
	public User(int id, String name)
	{
		this.id = id;
		this.name = name;
		this.score = 0;
		fullListToSeven();
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	@Override
	public String[][] getCurrentList()
	{
		return letterList;
	}
	
	// randomize the player's hand.
	public void fullListToSeven()
	{		
		for(int i = 0; i < 7; i++)
		{
			if(letterList[i][0] == null)
				letterList[i] = Pouch.getInstance().getRandomLetter();
		}
	}
	
	// get another random letter instead of played letter, attackPoints mean player's input as row, column, letter
	public void playGivenLetter(List<AttackLetter> attackPoints)
	{
		// attacked letter will be in the letter list
		int size = attackPoints.size();
		
		for(int i = 0; i < size; i++)
		{
			for(int j = 0; j < 7; j++)
			{
				if ( letterList[j][0].equalsIgnoreCase(attackPoints.get(i).letter) )
				{
					letterList[j] = Pouch.getInstance().getRandomLetter();
					break;
				}
			}
		}
	}
	
        // check if the user input is matching with user attack letters.
	public boolean checkUserHasCurrentLetter(List<AttackLetter> attackPoints)
	{
		int size = attackPoints.size();
		
		String letterListStr = "";
		boolean result = true;
				
		for(int i = 0; i < 7; i++)
		{
			letterListStr += letterList[i][0].toUpperCase();
		}
		
		for(int i = 0; i < size && result; i++)
		{
			boolean res = letterListStr.contains(attackPoints.get(i).letter.toUpperCase());
			if(!res)
			{
				result = false;
			}
			
		}
		return result;
	}
	
}
