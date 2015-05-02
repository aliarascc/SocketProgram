package Model;

import java.util.List;

import View.AttackLetter;

public interface IUser {
	
	public String[][] getCurrentList();
	public int getScore();
	public void setScore(int score);
	public void playGivenLetter(List<AttackLetter> attackPoints);
	public boolean checkUserHasCurrentLetter(List<AttackLetter> attackList);

}
