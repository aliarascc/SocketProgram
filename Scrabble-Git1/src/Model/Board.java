package Model;

/**
 * Contains board information.
 * Singleton
 * @author asezgin, dmalbora
 *
 */

public class Board {
	private static Board instance = null;
	private String[][][] table = null; // on GUI
	private String[][][] tempTable = null; // calculation process is done on tempTable.	
	
	private Board()
	{		
		//3. dimension contains mark and letter. 0. index->mark, 1. index->letter
		table = new String[15][15][2];//0 Mark //1 Letter
		tempTable = new String[15][15][2];
		initializeTable();
	}
	
	public static Board getInstance()
	{
		if (instance == null)
		{
			instance = new Board();
		}
		return instance;
	}

	public String[][][] getTable() 
	{
		return table;
	}
	
	public String[][][] getTempTable() 
	{
		return tempTable;
	}
	
	/**
	 * prepare mark
	 */
	public void initializeTable()
	{
		if(table != null)
		for(int i = 0; i < 15; i++)
		{
			for(int j = 0; j < 15; j++)
			{
				table[i][j][0] = "1"; // contains mark
				// empty string means that there is no letter in this field yet.
				table[i][j][1] = "";  // contains letter
			}
		}
		for(int i = 0; i < 15; i++)
		{
			table[i][i][0] = "2"; // contains mark
			table[i][14 - i][0] = "2"; // contains mark
		}
	}
	
	/**
	 * temp and real table are synchronized
	 */
	
	public void syncTempTable()
	{
		if(table != null)
		for(int i = 0; i < 15; i++)
		{
			for(int j = 0; j < 15; j++)
			{
				for(int k = 0; k < 2; k++)
				{
					tempTable[i][j][k] = table[i][j][k];
				}
			}
		}
	}
}
