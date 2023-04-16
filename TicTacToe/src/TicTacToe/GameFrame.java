package TicTacToe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class GameFrame extends JFrame implements ActionListener{
    GamePanel panel;
    JButton reset;
    JButton quitGame;
    public GameFrame() {
        panel = new GamePanel();

        reset = new JButton("Restart");
        reset.setText("Restart");
        reset.addActionListener(this);
        reset.setFont(new Font("Serif", Font.PLAIN, 20));
        reset.setBounds(113,570,100,30);

        quitGame = new JButton("Quit");
        quitGame.setText("Quit");
        quitGame.addActionListener(this);
        quitGame.setFont(new Font("Serif", Font.PLAIN, 20));
        quitGame.setBounds(226,570,100,30);

        this.setTitle("Tic Tac Toe");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(450, 630);

        this.getContentPane().setBackground(Color.BLACK);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.add(panel.infoPanel);
        this.add(panel.buttonPanel);
        this.add(reset);
        this.add(quitGame);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == reset) {
            this.remove(panel.buttonPanel);
            this.remove(panel.infoPanel);
            panel = new GamePanel();
            this.add(panel.infoPanel);
            this.add(panel.buttonPanel);
            SwingUtilities.updateComponentTreeUI(this);
        }else if (e.getSource() == quitGame) {
            System.exit(0);
        }
    }
}



