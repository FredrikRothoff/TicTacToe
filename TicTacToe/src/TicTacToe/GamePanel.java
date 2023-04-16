package TicTacToe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
public class GamePanel extends JPanel implements ActionListener {
    boolean turn;
    JPanel infoPanel;
    JPanel buttonPanel;
    JButton[] buttons;
    ArrayList<JButton> buttonList;
    public JLabel infoLabel;
    public GamePanel() {

        infoPanel = new JPanel();
        infoPanel.setBounds(0, 0, 450, 120);
        infoPanel.setBackground(Color.BLACK);

        buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        buttonPanel.setBounds(0, 120, 450, 450);
        buttonPanel.setBackground(Color.BLACK);

        infoLabel = new JLabel("", SwingConstants.CENTER);
        infoLabel.setBackground(Color.BLACK);
        infoLabel.setOpaque(true);
        infoLabel.setPreferredSize(new Dimension(450, 120));
        infoLabel.setText("X Starts");
        infoLabel.setFont(new Font("Serif", Font.BOLD, 48));
        infoLabel.setForeground(Color.GREEN);
        infoLabel.setBorder(BorderFactory.createLineBorder(Color.magenta, 3));
        infoPanel.add(infoLabel);

        buttonList = new ArrayList<>();
        buttons = new JButton[9];
        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton("");
            buttons[i].setPreferredSize(new Dimension(150, 150));
            buttons[i].setFont(new Font("Serif", Font.PLAIN, 150));
            buttons[i].setBorder(BorderFactory.createLineBorder(Color.magenta, 2));
            buttons[i].setForeground(Color.WHITE);
            buttons[i].addActionListener(this);
            buttonList.add(buttons[i]);
            buttonPanel.add(buttons[i]);
        }
    }
    public Boolean playerTurns() {
        if (turn == false) {
            turn = true;
            return true;
        } else if (turn == true) {
            turn = false;
            return false;
        }
        return null;
    }
    public Boolean checkDraw() {
            if (buttons[0].getText().isEmpty() == false && buttons[1].getText().isEmpty() == false
                    && buttons[2].getText().isEmpty() == false && buttons[3].getText().isEmpty() == false
                    && buttons[4].getText().isEmpty() == false && buttons[5].getText().isEmpty() == false
                    && buttons[6].getText().isEmpty() == false && buttons[7].getText().isEmpty() == false
                    && buttons[8].getText().isEmpty() == false){
                infoLabel.setText("Oavgjort");
                return true;
            }
            return false;
    }
    public boolean checkWinner() {
        boolean winner = false;
        if (buttons[0].getText().equals("X")
                && buttons[1].getText().equals("X")
                && buttons[2].getText().equals("X")) {
            infoLabel.setText("X is the winner");
            winner = true;
        } else if (buttons[3].getText().equals("X")
                && buttons[4].getText().equals("X")
                && buttons[5].getText().equals("X")) {
            infoLabel.setText("X is the winner");
            winner = true;
        } else if (buttons[6].getText().equals("X")
                && buttons[7].getText().equals("X")
                && buttons[8].getText().equals("X")) {
            infoLabel.setText("X is the winner");
            winner = true;
        } else if (buttons[0].getText().equals("X")
                && buttons[3].getText().equals("X")
                && buttons[6].getText().equals("X")) {
            infoLabel.setText("X is the winner");
            winner = true;
        } else if (buttons[1].getText().equals("X")
                && buttons[4].getText().equals("X")
                && buttons[7].getText().equals("X")) {
            infoLabel.setText("X is the winner");
            winner = true;
        } else if (buttons[2].getText().equals("X")
                && buttons[6].getText().equals("X")
                && buttons[8].getText().equals("X")) {
            infoLabel.setText("X is the winner");
            winner = true;
        } else if (buttons[0].getText().equals("X")
                && buttons[4].getText().equals("X")
                && buttons[8].getText().equals("X")) {
            infoLabel.setText("X is the winner");
            winner = true;
        } else if (buttons[2].getText().equals("X")
                && buttons[4].getText().equals("X")
                && buttons[6].getText().equals("X")) {
            infoLabel.setText("X is the winner");
            winner = true;

        } else if (buttons[0].getText().equals("O")
                && buttons[1].getText().equals("O")
                && buttons[2].getText().equals("O")) {
            infoLabel.setText("O is the winner");
            winner = true;
        } else if (buttons[3].getText().equals("O")
                && buttons[4].getText().equals("O")
                && buttons[5].getText().equals("O")) {
            infoLabel.setText("O is the winner");
            winner = true;
        } else if (buttons[6].getText().equals("O")
                && buttons[7].getText().equals("O")
                && buttons[8].getText().equals("O")) {
            infoLabel.setText("O is the winner");
            winner = true;
        } else if (buttons[0].getText().equals("O")
                && buttons[3].getText().equals("O")
                && buttons[6].getText().equals("O")) {
            infoLabel.setText("O is the winner");
            winner = true;
        } else if (buttons[1].getText().equals("O")
                && buttons[4].getText().equals("O")
                && buttons[7].getText().equals("O")) {
            infoLabel.setText("O is the winner");
            winner = true;
        } else if (buttons[2].getText().equals("O")
                && buttons[5].getText().equals("O")
                && buttons[8].getText().equals("O")) {
            infoLabel.setText("O is the winner");
            winner = true;
        } else if (buttons[0].getText().equals("O")
                && buttons[4].getText().equals("O")
                && buttons[8].getText().equals("O")) {
            infoLabel.setText("O is the winner");
            winner = true;
        } else if (buttons[2].getText().equals("O")
                && buttons[4].getText().equals("O")
                && buttons[6].getText().equals("O")) {
            infoLabel.setText("O is the winner");
            winner = true;
        }
        return winner;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
         if (checkWinner() || checkDraw()) {
            for (int i = 0; i < 9; i++) {
                buttons[i].setEnabled(false);
            }
        } else if (((JButton) e.getSource()).getText().equals("X")
                || ((JButton) e.getSource()).getText().equals("O") ) {
            infoLabel.setText("Plats upptagen");
        } else if (e.getSource() instanceof JButton && playerTurns()) {
            infoLabel.setText("Your turn: O");
            ((JButton) e.getSource()).setText("X");
            ((JButton) e.getSource()).setForeground(new Color(255, 50, 110));
            ((JButton) e.getSource()).setForeground(Color.RED);
        } else if (e.getSource() instanceof JButton) {
            infoLabel.setText("Your turn: X");
            ((JButton) e.getSource()).setText("O");
            ((JButton) e.getSource()).setForeground(new Color(20, 90, 240));
        }
            checkWinner();
            checkDraw();
    }
}
