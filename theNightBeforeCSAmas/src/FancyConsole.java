import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.plaf.basic.BasicSliderUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.*;
import java.util.Objects;
import java.util.Scanner;

import static javax.swing.BorderFactory.createEmptyBorder;

public class FancyConsole {
    JFrame window;
    JPanel titlePanel, titleShadowPanel, startButtonPanel, iconPanel; //title screen Jpanels
    JPanel imagePanel,imageTitlePanel, imageFramePanel;
    JLabel titleLabel, iconLabel;
    JLabel consoleImage = new JLabel();
    JLabel imgTitle = new JLabel("image.png");
    JButton startButton;
    JTextArea gameTextArea;

    //console stuff:
    JPanel console;
    TitleScreenHandler tsHandler = new TitleScreenHandler();
    String consoleText;
    JTextArea taOut;
    JScrollPane scrollPane;

    private final PipedInputStream inPipe = new PipedInputStream();
    private final PipedInputStream outPipe = new PipedInputStream();
    PrintWriter inWriter;

    //styling
    Font titleFont = new Font("American Typewriter", Font.BOLD, 40);
    Font normalFont = new Font("American Typewriter", Font.PLAIN, 30);
    Color lilac = new Color(225, 199, 255);
    Color darkerLilac = new Color(202, 164, 255);

    FancyConsole(){
        //making a frame for game
        window = new JFrame("The Night Before CSAmas");
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


        //setting the window to purple and not adding a layout
        window.getContentPane().setBackground(lilac);
        window.setLayout(null);

        //creating titlePanel and adding a titleLabel to it,
        titlePanel = new JPanel();
        titlePanel.setBounds(100, 100, 600, 150);
        titlePanel.setBackground(Color.white);
        titlePanel.setLayout(new BorderLayout());
        titleLabel = new JLabel("   The Night Before CSAmas!"); //trying to center using BorderLayout
        titleLabel.setForeground(lilac);                             //not clean --> find a solution later
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
    public void enterGameScreen() {
        //setting up input and output streams
        System.setIn(inPipe);
        try {
            System.setOut(new PrintStream(new PipedOutputStream(outPipe), true));
            inWriter = new PrintWriter(new PipedOutputStream(inPipe), true);
        } catch (IOException e) {
            System.out.println("Error: " + e);
            return;
        }

        titlePanel.setVisible(false);
        titleShadowPanel.setVisible(false);
        startButtonPanel.setVisible(false);
        iconPanel.setVisible(false);

        imageFramePanel = new JPanel();
        imageFramePanel.setBackground(new Color(0, 0, 0, 0));
        imageFramePanel.setBounds(16, 16, 496, 393);
        imageFramePanel.setBorder(BorderFactory.createMatteBorder(10, 10, 10, 10, Color.white));

        imagePanel = new JPanel();
        imagePanel.setBounds(16, 16, 496, 393);
        imagePanel.setBackground(new Color(0, 0, 0, 0));
        imagePanel.add(consoleImage);

        consoleText = "";
        console = new JPanel();
        console.setBounds(16, 425, 496, 200);
        console.setBackground(Color.white);
        taOut = new JTextArea(8, 48);
        taOut.setFont(new Font("American Typewriter", Font.PLAIN, 10));
        taOut.setForeground(new Color(163, 94, 255));
        scrollPane = new JScrollPane(taOut);
        scrollPane.setBorder(createEmptyBorder());

        console.add(scrollPane);
        window.add(imageFramePanel);
        window.add(imagePanel);
        window.add(console);


    }
    //implementing a console method
    private void updateTextArea(final String text) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                taOut.append(text);
            }
        });
    }

    private void redirectSystemStreams() {
        OutputStream out = new OutputStream() {
            @Override
            public void write(int b) throws IOException {
                updateTextArea(String.valueOf((char) b));
            }

            @Override
            public void write(byte[] b, int off, int len) throws IOException {
                updateTextArea(new String(b, off, len));
            }

            @Override
            public void write(byte[] b) throws IOException {
                write(b, 0, b.length);
            }
        };

        System.setOut(new PrintStream(out, true));
        System.setErr(new PrintStream(out, true));
    }

    public class TitleScreenHandler implements ActionListener{
        public void actionPerformed(ActionEvent event){
            enterGameScreen();
        }
    }

    public void setImage(String newImage)
    {
        ImageIcon imageIcon = new ImageIcon(this.getClass().getResource("forest.jpeg"));
        Image img = imageIcon.getImage();
        Image scaledImg = img.getScaledInstance(496,393,java.awt.Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImg);

        consoleImage.setIcon(scaledIcon);
    }

}
