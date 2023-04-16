package TicTacToe;

import javax.sound.sampled.*;
import java.io.*;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Music {

    void music() throws LineUnavailableException, IOException, UnsupportedAudioFileException {
        String response = null;
        while (response == null) {
            Scanner scanner = new Scanner(System.in);

            File file = new File("music.wav");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();

             response = scanner.next();
            if (response.equals("stop")){
                clip.stop();
            }
        }
    }
}
