import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class TicTacToe implements ActionListener{

    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel title_panel = new JPanel();
    JPanel button_Panel = new JPanel();
    JLabel text_field = new JLabel();
    JButton[] buttons = new JButton[9];
    boolean player1_turn ;

    TicTacToe(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,800);
        frame.getContentPane().setBackground(new Color(0x111111));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        text_field.setBackground(new Color(0x2F2F2F));
        text_field.setForeground(new Color(0x1FA0FF));
        text_field.setFont(new Font("Ink Free",Font.BOLD,50));
        text_field.setHorizontalAlignment(JLabel.CENTER);
        text_field.setText("Tic_Tac_Toe");//HEAD
        text_field.setOpaque(true);

        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0,0,800,100);

        button_Panel.setLayout(new GridLayout(3,3));
        button_Panel.setBackground(new Color(0,0,0));

        for(int i=0;i<9;i++){
            buttons[i]=new JButton();
            button_Panel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli", Font.BOLD,100));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }

        title_panel.add(text_field);
        frame.add(title_panel,BorderLayout.NORTH);
        frame.add(button_Panel);
        firstTurn();

    }
    @Override
    public void actionPerformed(ActionEvent e){
        for(int i=0;i<9;i++){
            if(e.getSource()==buttons[i]){
                if(player1_turn){
                    if(buttons[i].getText()==""){
                        buttons[i].setForeground(new Color(0xA7FDCC));
                        buttons[i].setText("X");
                        player1_turn=false;
                        text_field.setText("O turn");
                        check();
                    }
                }
                else{
                    if(buttons[i].getText()==""){
                        buttons[i].setForeground(new Color(0x1FA0FF));
                        buttons[i].setText("O");
                        player1_turn=true;
                        text_field.setText("X turn");
                        check();
                    }
                }
            }
        }
    }
    public void firstTurn(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(random.nextInt(2)==0){
            player1_turn = true ;
            text_field.setText("X turn");
        }
        else{
            player1_turn = false ;
            text_field.setText("O turn");
        }
    }
    public void check(){
        //X horizontal
        if((buttons[0].getText()=="X") &&(buttons[1].getText()=="X")&&(buttons[2].getText()=="X")){
            xwins(0, 1, 2);
        }
        if((buttons[3].getText()=="X") &&(buttons[4].getText()=="X")&&(buttons[5].getText()=="X")){
            xwins(3, 4, 5);
        }
        if((buttons[6].getText()=="X") &&(buttons[7].getText()=="X")&&(buttons[8].getText()=="X")){
            xwins(6, 7, 8);
        }
        //X vertical
        if((buttons[0].getText()=="X") &&(buttons[3].getText()=="X")&&(buttons[6].getText()=="X")){
            xwins(0, 3, 6);
        }
        if((buttons[1].getText()=="X") &&(buttons[4].getText()=="X")&&(buttons[7].getText()=="X")){
            xwins(1, 4, 7);
        }
        if((buttons[2].getText()=="X") &&(buttons[5].getText()=="X")&&(buttons[8].getText()=="X")){
            xwins(2, 5, 8);
        }
        //X diagonal
        if((buttons[0].getText()=="X") &&(buttons[4].getText()=="X")&&(buttons[8].getText()=="X")){
            xwins(0, 4, 8);
        }
        if((buttons[2].getText()=="X") &&(buttons[4].getText()=="X")&&(buttons[6].getText()=="X")){
            xwins(2, 4, 6);
        }
        //O horizontal
        if((buttons[0].getText()=="O") &&(buttons[1].getText()=="O")&&(buttons[2].getText()=="O")){
            owins(0, 1, 2);
        }
        if((buttons[3].getText()=="O") &&(buttons[4].getText()=="O")&&(buttons[5].getText()=="O")){
            owins(3, 4, 5);
        }
        if((buttons[6].getText()=="O") &&(buttons[7].getText()=="O")&&(buttons[8].getText()=="O")){
            owins(6, 7, 8);
        }
        //O vertical
        if((buttons[0].getText()=="O") &&(buttons[3].getText()=="O")&&(buttons[6].getText()=="O")){
            owins(0, 3, 6);
        }
        if((buttons[1].getText()=="O") &&(buttons[4].getText()=="O")&&(buttons[7].getText()=="O")){
            owins(1, 4, 7);
        }
        if((buttons[2].getText()=="O") &&(buttons[5].getText()=="O")&&(buttons[8].getText()=="O")){
            owins(2, 5, 8);
        }
        //O diagonal
        if((buttons[0].getText()=="O") &&(buttons[4].getText()=="O")&&(buttons[8].getText()=="O")){
            owins(0, 4, 8);
        }
        if((buttons[2].getText()=="O") &&(buttons[4].getText()=="O")&&(buttons[6].getText()=="O")){
            owins(2, 4, 6);
        }
       
    }
    public void xwins(int a,int b,int c){
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);
        for(int i=0;i<9;i++){
            buttons[i].setEnabled(false);
        }
        text_field.setText("X Wins");
    }
    public void owins(int a,int b,int c){
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);
        for(int i=0;i<9;i++){
            buttons[i].setEnabled(false);
        }
        text_field.setText("O Wins");
    }
}
