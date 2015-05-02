package View;

import Controller.Controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * GUI - View part of MVC
 * @author dmalbora, veyselo, asezgin
 *
 */

@SuppressWarnings("serial")
public class Viewer extends JPanel {

	JFrame frame;
	
	//Saves user information. Map to user list index
	int CURRENTUSER = 0;
	
	List<AttackLetter> attackList = new ArrayList<AttackLetter>();
	Controller controller = null;
	JTextField fieldList[][] = new JTextField[7][3];
	JLabel user_1_Label = new JLabel("x");
	JLabel user_2_Label = new JLabel("y");
	JLabel labelUserTurn;
	JLabel labelUser_1_Score;
	JLabel labelUser_2_Score;
	JLabel labelMessage = new JLabel("MESSAGE: ");
	JLabel indexLabelList[] = new JLabel[30]; // shows grid index

	int passCount = 0;
	
	public Viewer(Controller controller) 
	{
		this.controller = controller;		
		
		frame = new JFrame("Scrabble-CS534-AVD");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setSize(1024, 768);
		frame.setVisible(false);
		frame.add(this);
		this.setLayout(null);

		setUserTables();		
		setTextboxs();
		setButtons();		
	}
	
	public void start()
	{
		frame.setVisible(true);
	}

	/**
	 * shows some label which shows
	 */
	private void setUserTables()
	{
		String userTable = "Jimi (P1):";
		for(int i = 0; i < 7; i++) userTable += " [ " + controller.userList.get(0).getCurrentList()[i][0] +" ]"; 
		
		user_1_Label.setText(userTable);		
		user_1_Label.setBounds(520, 30, 400, 20);
		user_1_Label.setVisible(true);
		this.add(user_1_Label);
		
		userTable = "Hendrix (P2):";
		for(int i = 0; i < 7; i++) userTable += " [ " + controller.userList.get(1).getCurrentList()[i][0] +" ]"; 
		
		user_2_Label.setText(userTable);		
		user_2_Label.setBounds(520, 55, 400, 20);
		user_2_Label.setVisible(true);
		this.add(user_2_Label);
		

		
		labelMessage.setBounds(40, 500, 600, 30);
		labelMessage.setVisible(true);
		labelMessage.setForeground(Color.red);
		this.add(labelMessage);
	}
	
	/**
	 * prepare text box to enter letter
	 */
	private void setTextboxs()
	{
		JLabel label = new JLabel("Row");
		JLabel label1 = new JLabel("Column");
		JLabel label2 = new JLabel("Letter");
		labelUserTurn = new JLabel("Player " + (CURRENTUSER + 1) + " Turn");
		
		label.setBounds(560, 90, 100, 20);
		label1.setBounds(607, 90, 100, 20);
		label2.setBounds(676, 90, 100, 20);
		labelUserTurn.setBounds(595, 380, 200, 30);
		
		labelUser_1_Score = new JLabel("JIMI'S SCORE: 0");
		labelUser_2_Score = new JLabel("HENDRIX'S SCORE: 0");
		
		labelUser_1_Score.setBounds(580, 420, 200, 30);
		labelUser_2_Score.setBounds(580, 450, 200, 30);
		labelUser_1_Score.setForeground(Color.red);
		labelUser_2_Score.setForeground(Color.red);
		
		this.add(label);
		this.add(label1);
		this.add(label2);
		this.add(labelUserTurn);
		this.add(labelUser_1_Score);
		this.add(labelUser_2_Score);
		
		for (int i = 0; i < 7; i++) 
		{
			fieldList[i][0] = new JTextField(); // row
			fieldList[i][1] = new JTextField(); // column
			fieldList[i][2] = new JTextField(); // letter
			this.add(fieldList[i][0]);
			this.add(fieldList[i][1]);
			this.add(fieldList[i][2]);			
			
			fieldList[i][0].setBounds(550, 110 + 30 * i, 50, 30);
			fieldList[i][1].setBounds(600, 110 + 30 * i, 70, 30);
			fieldList[i][2].setBounds(670, 110 + 30 * i, 60, 30);

			fieldList[i][0].setText("");
			fieldList[i][1].setText("");
			fieldList[i][2].setText("");
		}
		
		// vertical number
		int indexer = 0;
		for(indexer = 0; indexer < 15; indexer++)
		{
			indexLabelList[indexer] = new JLabel("column");
			indexLabelList[indexer].setBounds(7, 37 + indexer*30, 25, 15);
			indexLabelList[indexer].setVisible(true);
			this.add(indexLabelList[indexer]);
			indexLabelList[indexer].setText(indexer + "");
		}
		// horizontal number
		for( ;indexer < 30; indexer ++)
		{
			indexLabelList[indexer] = new JLabel("row");
			indexLabelList[indexer].setText( (indexer - 15) + "");
			indexLabelList[indexer].setBounds(37 + (indexer-15)*30, 7, 25, 15);
			this.add(indexLabelList[indexer]);
		}
	}
	
	/**
	 * prepares buttons position and information
	 */
	
	private void setButtons()
	{
		JButton okButton = new JButton("PLAY");
		JButton passButton = new JButton("PASS");
		
		this.add(okButton);
		this.add(passButton);
		
		okButton.setBounds(530, 340, 100, 30);
		passButton.setBounds(640, 340, 100, 30);
		
		okButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				System.out.println("OK Button clicked.");
				play();
			}
		});
		
		passButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				CURRENTUSER = (CURRENTUSER + 1) % 2;
				labelUserTurn.setText("Player " + (CURRENTUSER + 1) + " Turn");
				passCount++;
				if(passCount == 6)
				{
					String result = GameResultStr();
					JOptionPane.showMessageDialog(null, result, "RESULT",JOptionPane.INFORMATION_MESSAGE);
					okButton.setEnabled(false);
					passButton.setEnabled(false);
				}
				clearTextBoxes();
			}
		});
	}
	
	/**
	 * Prepare score string when games finished
	 * @return
	 */
	private String GameResultStr()
	{
		String result = "";
		if(controller.userList.get(0).getScore() > controller.userList.get(1).getScore())
			result = "Sequentially 3 pass. User_1 WINNER";
		else if(controller.userList.get(1).getScore() > controller.userList.get(0).getScore())
			result = "Sequentially 3 pass. User_2 WINNER";
		else
			result = "Sequentially 3 pass. GAME IS DRAW";
		
		return result;
	}
	
	/**
	 * Draw table to panel
	 */
	public void paintComponent(Graphics g) 
	{
		int x = 34, y = 30;
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		// Reset your starting y value here

		// draw rows
		for (int i = 1; i <= 16; i++) {
			g.drawLine(30, 30 * i, 480, 30 * i);
		}
		
		// draw columns
		for (int i = 1; i <= 16; i++) {
			g.drawLine(30 * i, 30, 30 * i, 480);
		}

		y = 53;
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 15; j++) {
				if (controller.boardChecker.getBoard().getTable()[i][j][1] == "") 
				{
					g.setFont(new Font("TimesRoman", Font.PLAIN, 12));
					if(controller.boardChecker.getBoard().getTable()[i][j][0].equals("1"))
						g2.setColor(Color.YELLOW.darker());
					else
						g2.setColor(Color.BLUE);
					g2.drawString(controller.boardChecker.getBoard().getTable()[i][j][0].toUpperCase(), x, y);
				} else {
					g.setFont(new Font("TimesRoman", Font.PLAIN, 25));
					g2.setColor(Color.RED);
					g2.drawString(controller.boardChecker.getBoard().getTable()[i][j][1].toUpperCase(), x, y);
				}
				x += 30;
			}
			y += 30;
			x = 32;
		}
		setUserTables();
	}

	/**
	 * called when user play a word
	 */
	
	public void play() 
	{
		for (int i = 0; i < 7; i++) 
		{
			if (!fieldList[i][0].getText().trim().equalsIgnoreCase("") && 
					!fieldList[i][1].getText().trim().equalsIgnoreCase("") && 
					!fieldList[i][2].getText().trim().equalsIgnoreCase("")) 
			{
				try 
				{
					AttackLetter attackLetter = new AttackLetter();
					attackLetter.row = Integer.parseInt(fieldList[i][0].getText().trim());
					attackLetter.column = Integer.parseInt(fieldList[i][1].getText().trim());
					attackLetter.letter = fieldList[i][2].getText().trim();
					
					if( (attackLetter.row < 0 || attackLetter.row > 14) ||
							attackLetter.column < 0 || attackLetter.column > 14)
						throw new Exception();
					
					attackList.add(attackLetter);
				}
				catch (Exception e) 
				{
					JOptionPane.showMessageDialog(null,"Row and Column must be integer value between [0-14]","ERROR",JOptionPane.WARNING_MESSAGE);
					attackList.clear();
					break;
				}
			}
		}
		if(attackList.size() > 0)
		{
			boolean result = controller.play(controller.userList.get(CURRENTUSER), attackList);
			if(result)
			{
				labelMessage.setText("MESSAGE: ");
				controller.message = "";
				clearTextBoxes();
				
				if(CURRENTUSER == 0)
					labelUser_1_Score.setText("JIMI'S SCORE: " + controller.userList.get(CURRENTUSER).getScore());
				else 
					labelUser_2_Score.setText("HENDRIX'S SCORE: " + controller.userList.get(CURRENTUSER).getScore());
				
				CURRENTUSER = (CURRENTUSER + 1) % 2;
				labelUserTurn.setText("USER " + (CURRENTUSER + 1) + " TURN");
				passCount = 0;
				if ( controller.gameIsOver )
				{
					String endRes = GameResultStr();
					JOptionPane.showMessageDialog(null,endRes,"GAME IS OVER",JOptionPane.INFORMATION_MESSAGE);
				}
			}
			else
				labelMessage.setText("MESSAGE: " + controller.message);
			attackList.clear();
			repaint();
		}
	}

	private void clearTextBoxes()
	{
		for (int i = 0; i < 7; i++) 
		{
			fieldList[i][0].setText("");
			fieldList[i][1].setText("");
			fieldList[i][2].setText("");
		}
	}
	public void drawTable() 
	{
		repaint();
	}
	
}
