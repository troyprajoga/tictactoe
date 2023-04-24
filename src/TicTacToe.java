import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.Border;

public class TicTacToe implements ActionListener{
    //Making the frame, title, buttons, and text for the game
    JFrame frame = new JFrame();
    JPanel title = new JPanel();
    JPanel button = new JPanel();
    JLabel text = new JLabel();
    JButton[] buttons = new JButton[9];
    boolean playerOneTurn;
    TicTacToe(){//This is tictactoe game/board
        //this makes the frame of tictactoe
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,700);
        frame.getContentPane().setBackground(new Color(0,0,0));
        frame.setVisible(true);

        //this makes the label on the top of the tictactoe
        text.setBackground(new Color(255,255,255));
        text.setForeground(new Color(0,200,200));
        text.setFont(new Font("Times New Roman",Font.BOLD,50));
        text.setHorizontalAlignment(JLabel.CENTER);
        text.setOpaque(true);

        //create grid for buttons
        button.setLayout(new GridLayout(3,3));
        button.setBackground(new Color(150,150,255));

        for(int i = 0; i < 9; i ++)
        {
            //create 9 buttons with action listeners
            buttons[i] = new JButton();
            button.add(buttons[i]);
            buttons[i].setFont(new Font("Times New Roman",Font.BOLD,100));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }

        //combine the frame, buttons, and the text label
        title.add(text);
        frame.add(title,BorderLayout.NORTH);
        frame.add(button);

        //Start the game
        firstTurn();
    }
    public void firstTurn()
    {
        //X starts
        playerOneTurn = true;
        text.setText("X turn");
    }
    public void checkWin()//This checks the winner of the game
    {
        //Check X Wins
        for(int i = 0; i < 3; i++)
        {
            //Check rows
            int j = i * 3;
            if((buttons[j].getText() == "X") && (buttons[j+1].getText() == "X") && (buttons[j+2].getText() == "X")){
                xWins(j,j+1,j+2);
            }
        }
        for(int i = 0; i < 3; i++)
        {
            //Check columns
            if((buttons[i].getText() == "X") && (buttons[i+3].getText() == "X") && (buttons[i+6].getText() == "X")){
                xWins(i,i+3,i+6);
            }
        }
        //Check diagonals
        if((buttons[0].getText() == "X") && (buttons[4].getText() == "X") && (buttons[8].getText() == "X")){
            xWins(0,4,8);
        }
        if((buttons[2].getText() == "X") && (buttons[4].getText() == "X") && (buttons[6].getText() == "X")){
            xWins(2,4,6);
        }
        //O wins
        for(int i = 0; i < 3; i++)
        {
            //check rows
            int j = i * 3;
            if((buttons[j].getText() == "O") && (buttons[j+1].getText() == "O") && (buttons[j+2].getText() == "O")){
                oWins(j,j+1,j+2);
            }
        }
        for(int i = 0; i < 3; i++)
        {
            //check columns
            if((buttons[i].getText() == "O") && (buttons[i+3].getText() == "O") && (buttons[i+6].getText() == "O")){
                oWins(i,i+3,i+6);
            }
        }
        //check diagonals
        if((buttons[0].getText() == "O") && (buttons[4].getText() == "O") && (buttons[8].getText() == "O")){
            oWins(0,4,8);
        }
        if((buttons[2].getText() == "O") && (buttons[4].getText() == "O") && (buttons[6].getText() == "O")){
            oWins(2,4,6);
        }
    }
    public void xWins(int a, int b, int c)
    {
        //X wins then set color of winning tiles to green and say "X wins"
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);
        for(int i = 0; i < 9; i++)
        {
            buttons[i].setEnabled(false);
        }
        text.setText("X Wins");
    }
    public void oWins(int a, int b, int c)
    {
        //O wins then set color of winning tiles to green and say "O wins"
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);
        for(int i = 0; i < 9; i++)
        {
            buttons[i].setEnabled(false);
        }
        text.setText("O Wins");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        //Make button X or O depending on which player turn
        for(int i = 0; i < 9; i++)
        {
            if(e.getSource()==buttons[i])
            {
                if(playerOneTurn)
                {
                    if(buttons[i].getText()=="")
                    {
                        buttons[i].setText("X");
                        playerOneTurn = false;
                        text.setText("O turn");
                        checkWin();
                    }
                }
                else
                {
                    if(buttons[i].getText()=="")
                    {
                        buttons[i].setText("O");
                        playerOneTurn = true;
                        text.setText("X turn");
                        checkWin();
                    }
                }
            }
        }
    }
}
