import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicSliderUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class TextAdventure {
    JFrame window;
    JPanel titlePanel, titleShadowPanel, startButtonPanel, iconPanel, mainGameTextPanel;
    JLabel titleLabel, iconLabel;
    JButton startButton;
    JTextArea gameTextArea;
    TitleScreenHandler tsHandler = new TitleScreenHandler();


    private final PipedInputStream inPipe = new PipedInputStream();
    private final PipedInputStream outPipe = new PipedInputStream();
    PrintWriter inWriter;

    //styling
    Font titleFont = new Font("American Typewriter", Font.BOLD, 40);
    Font normalFont = new Font("American Typewriter", Font.PLAIN, 30);
    Color lilac = new Color(225, 199, 255);
    Color darkerLilac = new Color(202, 164, 255);

    TextAdventure(){

        //setting up input and output streams
        System.setIn(inPipe);
        try
        {
            System.setOut(new PrintStream(new PipedOutputStream(outPipe), true));
            inWriter = new PrintWriter(new PipedOutputStream(inPipe), true);
        }
        catch(IOException e)
        {
            System.out.println("Error: " + e);
            return;
        }

        //making a frame for game
        window = new JFrame("The Night Before CSAmas");
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        //setting the window to purple and not adding a layout
        window.getContentPane().setBackground(lilac);
        window.setLayout(null);

        //creating titlePanel and adding a titleLabel to it,
        titlePanel = new JPanel();
        titlePanel.setBounds(100, 100, 600, 150);
        titlePanel.setBackground(Color.white);
        titlePanel.setLayout(new BorderLayout());
        titleLabel = new JLabel("   The Night Before CSAmas!"); //trying to center using BorderLayout
        titleLabel.setForeground(lilac);                                //not clean --> find a solution later
        titleLabel.setFont(titleFont);
        titlePanel.add(titleLabel, BorderLayout.CENTER);
        window.add(titlePanel);

        titleShadowPanel = new JPanel();
        titleShadowPanel.setBounds(125,125, 600, 150);
        titleShadowPanel.setBackground(darkerLilac);
        window.add(titleShadowPanel);

        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(300, 500, 200, 50);
        startButtonPanel.setBackground(lilac);


        startButton = new JButton("start");
        startButton.setBackground(Color.white);
        startButton.setForeground(lilac);
        startButton.setFont(normalFont);
        startButton.addActionListener(tsHandler);

        startButtonPanel.add(startButton);
        window.add(startButtonPanel);

        iconPanel = new JPanel();
        iconPanel.setBounds(300, 300, 200, 200);
        iconPanel.setBackground(lilac);


        ImageIcon priya = new ImageIcon(this.getClass().getResource("priya.png"));
        Image imagePriya = priya.getImage();
        Image scaledImagePriya = imagePriya.getScaledInstance(200,210, Image.SCALE_SMOOTH);
        ImageIcon scaledPriya = new ImageIcon(scaledImagePriya);
        iconLabel = new JLabel();
        iconLabel.setIcon(scaledPriya);
        iconPanel.add(iconLabel);
        window.add(iconPanel);

        window.setVisible(true);


    }
    public void enterGameScreen(){
        titlePanel.setVisible(false);
        titleShadowPanel.setVisible(false);
        startButtonPanel.setVisible(false);
        iconPanel.setVisible(false);

        mainGameTextPanel = new JPanel();
        mainGameTextPanel.setBounds(100,100,600,250);
        mainGameTextPanel.setBackground(Color.white);

        gameTextArea = new JTextArea("Hey you!");
        gameTextArea.setBounds(100,100,600,250);
        gameTextArea.setBackground(lilac);
        gameTextArea.setForeground(Color.white);
        gameTextArea.setFont(normalFont);
        gameTextArea.setLineWrap(true);
        mainGameTextPanel.add(gameTextArea);
        window.add(mainGameTextPanel);
    }
    public class TitleScreenHandler implements ActionListener{
        public void actionPerformed(ActionEvent event){
            enterGameScreen();
        }
    }
}
