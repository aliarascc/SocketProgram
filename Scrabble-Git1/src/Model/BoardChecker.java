package Model;

import View.AttackLetter;

import java.util.List;
import java.util.Vector;

public class BoardChecker {
	// saves last point of the given word from user
	private int lastPoint[][] = new int[1][2];
	// saves beginning point of the given word from user
	private int beginPoint[][] = new int[1][2];
	
	public int score = 0;
	public String currentValidString = "";
	Board board = null;
	Dictionary dataAccessObject = null; // to used to reach to data
	
	public BoardChecker()
	{
		board = Board.getInstance();
		dataAccessObject = new DictionaryImp();
	}
	
	public Board getBoard()
	{
		return board;
	}
	
	public String getCurrentValidString()
	{
		return currentValidString;
	}
	
	/**
	 * check is user used available letter for him/her
	 * @param attackList: letter information on the board
	 * @return true or false
	 */
	public boolean checkCanLetterPlaceGivenPosition(List<AttackLetter> attackList)
	{
		boolean result = true;
		for(int i = 0; i < attackList.size() && result; i++)
		{
			if ( board.getTable() [ attackList.get(i).row ] [ attackList.get(i).column ][ 1 ] != "" )
			{
				result = false;
			}
		}
		return result;
	}
	
	/**
	 * First attack must be on the middle of the table
	 * @param attackList: letter information on the board
	 * @return true or false
	 */
	public boolean isFirstAttackOnTheCenter(List<AttackLetter> attackList)
	{
		boolean result = false;
		for(int i = 0; i < attackList.size() && !result; i++)
		{
			if ( attackList.get(i).row == 7 && attackList.get(i).column == 7 )
			{
				result = true;
			}
		}
		return result;
	}
	
	/**
	 * every process is successful anymore we can put letter to board
	 * @param attackList letter information on the board
	 */
	public void applyLettersToBoard(List<AttackLetter> attackList)
	{
		int size = attackList.size();
		for(int i = 0; i < size; i++)
		{
			board.getTable()[attackList.get(i).row][attackList.get(i).column][1] = attackList.get(i).letter; 
		}
	}
	
	/**
	 * Every new entrance letter must be connected to already entered letter 
	 * @param attackList letter information on the board
	 * @return true or false
	 */
	public boolean isConnected(List<AttackLetter> attackList)
	{
		// check all letters. has connection already entered letter
		int size = attackList.size();
		for(int i = 0; i < size; i++)
		{
			boolean left = true;
			boolean right = true;
			boolean up = true;
			boolean down = true;
			
			// true means empty
			if(attackList.get(i).column - 1 >= 0)
				left = board.getTable()[attackList.get(i).row ][attackList.get(i).column - 1][1].equalsIgnoreCase("");
			
			if(attackList.get(i).column + 1 <= 14)
				right = board.getTable()[attackList.get(i).row ][attackList.get(i).column + 1][1].equalsIgnoreCase("");
			
			if(attackList.get(i).row - 1 >= 0)
				up = board.getTable()[attackList.get(i).row - 1][attackList.get(i).column ][1].equalsIgnoreCase("");
			
			if(attackList.get(i).row + 1 <= 14)
				down = board.getTable()[attackList.get(i).row + 1][attackList.get(i).column ][1].equalsIgnoreCase("");
			
			if(!left || !right || !up || !down)
				return true;
		}
		
		return false;
	}
	
	/**
	 * check is database contains this created word
	 * @param attackList letter information on the board
	 * @return true or false
	 */
	public boolean checkIsThereAnyValidString(List<AttackLetter> attackList)
	{
		boolean result = false;
		boolean isHor = isHorizontal(attackList);
		boolean isVert = isVertical(attackList);
		Vector<String> letterList = new Vector<String>();
		String createdLetterList = "";
		score = 0;
		
		if(isHor && isVert)
		{
			// one letter is used			
			// firstly get horizontal and check is there any suitable word
			letterList = getHorizontalLetterList(attackList);

			// check word
			createdLetterList = VectorToStr(letterList);
			result = dataAccessObject.isValidString(createdLetterList);
			
			if(result)
			{
				// calculate score
				score = calculateScore("h");
			}			
			else
			{
				letterList = getVerticalLetterList(attackList);
				//check word
				createdLetterList = VectorToStr(letterList);
				result = dataAccessObject.isValidString(createdLetterList);
				
				if(result)
					score = calculateScore("v");
			}
		}
		else if(isHor)
		{
			letterList = getHorizontalLetterList(attackList);
			createdLetterList = VectorToStr(letterList);
			result = dataAccessObject.isValidString(createdLetterList);
			if(result)
				score = calculateScore("h");
		}
		else if(isVert)
		{
			letterList = getVerticalLetterList(attackList);
			createdLetterList = VectorToStr(letterList);
			result = dataAccessObject.isValidString(createdLetterList);
			if(result)
				score = calculateScore("v");
		}
		
		currentValidString = createdLetterList;
		
		return result;
	}
	
	private String VectorToStr(Vector<String> v)
	{
		StringBuilder str = new StringBuilder();
		int size = v.size();
		for(int i = 0; i < size; i++)
		{
			str.append(v.get(i));
		}
		return str.toString();
	}
	
	/**
	 * is word entered horizontally
	 * @param attackList letter information on the board
	 * @return
	 */
	private boolean isHorizontal(List<AttackLetter> attackList)
	{
		boolean result = true;
		// check horizontal line
		for(int i = 0; i < attackList.size(); i++)
		{
			int currentRow = attackList.get(i).row;
			int nextRow = currentRow;
			
			if( i + 1 < attackList.size() )
				nextRow = attackList.get(i + 1).row;
			if (currentRow != nextRow)
			{
				result = false;
				break;
			}
		}
		return result;
	}
	
	/**
	 * is word entered vertically
	 * @param attackList letter information on the board
	 * @return
	 */
	private boolean isVertical(List<AttackLetter> attackList)
	{
		boolean result = true;
		// check vertical line			
		for(int i = 0; i < attackList.size(); i++)
		{
			int currentColumn = attackList.get(i).column;
			int nextColumn = currentColumn;
			
			if( i + 1 < attackList.size() )
				nextColumn = attackList.get(i + 1).column;
			if (currentColumn != nextColumn)
			{
				result = false;
				break;
			}
		}
		return result;
	}
	
	/**
	 * Calculate score according to given letter
	 * @param vertOrHor is words entered vertically or horizontally, 
	 * vertical "v"
	 * horizontal "h"
	 * @return current score current word
	 */
	private int calculateScore(String vertOrHor)
	{
		int score = 0;
		if(vertOrHor.equals("h"))
		{
			int beginColumn = beginPoint[0][1];
			int endColumn = lastPoint[0][1];
			int row = beginPoint[0][0];
			
			for(int i = beginColumn; i <= endColumn; i++)
			{
				int boardMark = Integer.parseInt( board.getTempTable()[row][i][0] );
				String letter = board.getTempTable()[row][i][1];
				int letterMark = Pouch.getInstance().getMarkForGivenLetter(letter);
				score += boardMark * letterMark;
			}
			
		}
		else if(vertOrHor.equals("v"))
		{
			int beginRow = beginPoint[0][0];
			int endRow = lastPoint[0][0];
			int column = beginPoint[0][1];
			
			for(int i = beginRow; i <= endRow; i++)
			{
				int boardMark = Integer.parseInt( board.getTempTable()[i][column][0] );
				String letter = board.getTempTable()[i][column][1];
				int letterMark = Pouch.getInstance().getMarkForGivenLetter(letter);
				score += boardMark * letterMark;
			}
		}
		return score;
	}
	
	/**
	 * if word is entered horizontally generate given word from temp table
	 * @param attackList
	 * @return
	 */
	private Vector<String> getHorizontalLetterList(List<AttackLetter> attackList)
	{
		Vector<String> letterList = new Vector<String>();
		// sync temporary table to check string validity
		board.syncTempTable();
		for(int i = 0; i < attackList.size(); i++)
		{
			// 0 mark
			// 1 letter
			board.getTempTable()[ attackList.get(i).row ] [ attackList.get(i).column ][ 1 ] = attackList.get(i).letter; 
		}
		
		int currentRow = -1;
		int currentColumn = -1;
		
		if(attackList.size() > 0)
		{
			currentRow = attackList.get(0).row;
			currentColumn = attackList.get(0).column;
		}
		
		// point to right
		for(int j = currentColumn; j != -1 && j < 15; j++)
		{
			String letter = board.getTempTable()[currentRow][j][1];
			if(letter != "")
			{
				lastPoint[0][0] = currentRow;
				lastPoint[0][1] = j;
				
				letterList.add(letter);
			}
			else
				break;
		}
		
		beginPoint[0][0] = currentRow;
		beginPoint[0][1] = currentColumn;
		
		// point to left
		for(int j = currentColumn-1; j >= 0; j-- )
		{
			String letter = board.getTempTable()[currentRow][j][1];
			if(letter != "")
			{
				beginPoint[0][0] = currentRow;
				beginPoint[0][1] = j;
				
				letterList.add(0,letter);
			}
			else
				break;
		}
		return letterList;
	}
		
	/**
	 * if words entered vertically create given word as a string
	 * @param attackList
	 * @return
	 */
	private Vector<String> getVerticalLetterList(List<AttackLetter> attackList)
	{
		Vector<String> letterList = new Vector<String>();
		// sync temporary table to check string validity
		board.syncTempTable();
		for(int i = 0; i < attackList.size(); i++)
		{
			board.getTempTable()[ attackList.get(i).row ] [ attackList.get(i).column ][ 1 ] = attackList.get(i).letter; 
		}
		
		int currentRow = -1;
		int currentColumn = -1;
		
		if(attackList.size() > 0)
		{
			currentRow = attackList.get(0).row;
			currentColumn = attackList.get(0).column;
		}
		
		// point to down
		for(int j = currentRow; j != -1 && j < 15; j++)
		{
			String letter = board.getTempTable()[j][currentColumn][1];
			if(letter != "")
			{
				lastPoint[0][0] = j;
				lastPoint[0][1] = currentColumn;
				
				letterList.add(letter);
			}
			else
				break;
		}
		
		beginPoint[0][0] = currentRow;
		beginPoint[0][1] = currentColumn;
		
		// point to up
		for(int j = currentRow-1; j >= 0; j-- )
		{
			String letter = board.getTempTable()[j][currentColumn][1];
			if(letter != "")
			{
				beginPoint[0][0] = j;
				beginPoint[0][1] = currentColumn;
				
				letterList.add(0,letter);
			}
			else
				break;
		}
		return letterList;
	}
}
