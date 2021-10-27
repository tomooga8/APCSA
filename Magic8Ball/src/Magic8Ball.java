import java.util.Scanner;
import javax.swing.*;

public class Magic8Ball {
    public static void main(String[] args){
        JFrame frame = new JFrame();
        ImageIcon icon = new ImageIcon("/Users/tomohirooga/IdeaProjects/Magic8Ball/src/magic8ball.jpg");
        frame.add(new JLabel(icon));
        frame.pack();
        frame.setVisible(true);
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Ask a question: ");
        myScanner.nextLine();
        magic8Ball();
    }
    public static void magic8Ball(){
        int randNum = (int) (Math.random()*9 + 1);

        if (randNum == 1){
            System.out.println("BAHAHA \n \n \n \n...\n\n\n\n no");
        }
        if (randNum == 2){
            System.out.println("Concentrate and ask again");
        }
        if (randNum == 3){
            System.out.println("Cannot predict now");
        }
        if (randNum == 4){
            System.out.println("It is indeed a bones day");
        }
        if (randNum == 5){
            System.out.println("Signs point to yes");
        }
        if (randNum == 6){
            System.out.println("It is indeed not a bones day");
        }
        if (randNum == 7){
            System.out.println("Better not tell you now");
        }
        if (randNum == 8){
            System.out.println("no lol <3");
        }
        

    }
}
