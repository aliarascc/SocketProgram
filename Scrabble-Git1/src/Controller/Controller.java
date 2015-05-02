package Controller;

import Model.BoardChecker;
import Model.IUser;
import Model.UserFactory;
import View.AttackLetter;
import View.Viewer;

import java.util.ArrayList;
import java.util.List;

/** This is the controller part of the Model-View-Controller.
 * It is going to be a bridge between our View and Model.
 * @author asezgin, dmalbora, veyselo 
*/
public class Controller {

	private int turnCount = 0;
	private boolean tableContainsLetter = false; // flag to check whether any letter appears or not.
	
	public BoardChecker boardChecker = null; // this object is going to handle the process on the board.
	public Viewer viewer = null; // GUI
	public List<IUser> userList = null; // contains player info.
	public boolean gameIsOver = false; // flag to control when to end the game.
	public String message = "";  // message that is shown to user.
	
	public Controller()
	{
		boardChecker = new BoardChecker();
		userList = new ArrayList<IUser>();
		UserFactory userFactory = new UserFactory();
		userList.add(userFactory.getUser());
		userList.add(userFactory.getUser());
		viewer = new Viewer(this);
	}
	
	/**
	 * Show GUI
	 */
	public void start()
	{
		viewer.start(); 
	}
	
	/**
	 * After every attack called from viewer for current user
	 * @param user: current user
	 * @param attackList: word attack information
	 * @return is attack successful or not
	 */
	public boolean play(IUser user, List<AttackLetter> attackList)
	{
		boolean stepResult = true; // decider flag whether to pass the turn or not.
		
		if(turnCount == 0)
		{
			// one of the letter must be on the [7][7] position at the beginning.
			stepResult = boardChecker.isFirstAttackOnTheCenter(attackList);
			if(!stepResult)
				message = "One of the letter must be on the [7][7] position on the first turn";
			else
				turnCount++;
		}
		
		if(tableContainsLetter)
		{
			stepResult = boardChecker.isConnected(attackList);
			if(stepResult == false)
				message = "Given letters must be connected to occupied tiles!";
		}
		
		
		if(stepResult)
		{
			// check user has this letter
			stepResult = user.checkUserHasCurrentLetter(attackList);
			
			if(stepResult == false)
				message = "User does not have given letter(s)!";
		}
		
		if(stepResult)
		{
			// check is place of the letters are suitable
			stepResult = boardChecker.checkCanLetterPlaceGivenPosition(attackList);
			if(stepResult == false)
				message = "Given position is occupied by another letter!";
		}
		
		if(stepResult)
		{
			// Check all possible letters, is there any valid strings
			stepResult = boardChecker.checkIsThereAnyValidString(attackList); // score will calculate here
			if(stepResult == false)
				message = boardChecker.currentValidString.toString() + " is not a valid word according to the dictionary";
		}
		
		if(stepResult)
		{
			// Put the letters to the board
			boardChecker.applyLettersToBoard(attackList);
			tableContainsLetter = true;
			
			// Score already calculated			
			user.setScore( user.getScore() + boardChecker.score); // user's current score + gained
			boardChecker.score = 0; // make it 0 for the next turn
			user.playGivenLetter(attackList);
			
			// game is over if all tiles are occupied.
			gameIsOver = doesTableFinish(user);
			
			// Trigger viewer to draw table again with new format
			drawTable();
		}
		return stepResult;
	}
	
	/**
	 * Redraw the board to screen
	 */
	public void drawTable()
	{
		viewer.drawTable();
	}
	
	/**
	 * check user has any word to play. 
	 * @param user: current user
	 * @return If there is no word on the current user, returns true
	 */
	private boolean doesTableFinish(IUser user)
	{
		String table = "";
		for ( int i = 0; i < 7; i++)
		{
			table += user.getCurrentList()[i][0];
		}
		if(table.trim().equalsIgnoreCase(""))
			return true;
		return false;
	}
	
}
