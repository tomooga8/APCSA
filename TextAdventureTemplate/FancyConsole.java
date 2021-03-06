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
import java.util.Scanner;

import static javax.swing.BorderFactory.createEmptyBorder;

public class FancyConsole {
    JFrame window;
    JPanel titlePanel, titleShadowPanel, startButtonPanel, iconPanel; //title screen Jpanels
    JPanel imagePanel,imageTitlePanel, imageFramePanel;
    JLabel titleLabel, iconLabel, consoleImage;
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


        titlePanel.setVisible(false);
        titleShadowPanel.setVisible(false);
        startButtonPanel.setVisible(false);
        iconPanel.setVisible(false);

        imageFramePanel = new JPanel();
        imageFramePanel.setBackground(new Color(0,0,0,0));
        imageFramePanel.setBounds(16,16,496,393);
        imageFramePanel.setBorder(BorderFactory.createMatteBorder(10, 10, 10, 10, Color.white));

        imagePanel = new JPanel();
        imagePanel.setBounds(16,16,496,393);
        imagePanel.setBackground(new Color(0,0,0,0));
        consoleImage = new JLabel();
        imagePanel.add(consoleImage);

        consoleText = "";
        console = new JPanel();
        console.setBounds(16,425,496,200);
        console.setBackground(Color.white);
        taOut = new JTextArea(8,48);
        taOut.setFont(new Font("American Typewriter", Font.PLAIN, 10));
        taOut.setForeground(new Color(163, 94, 255));
        scrollPane = new JScrollPane(taOut);
        scrollPane.setBorder(createEmptyBorder());

        // to get the correct InputMap
        int condition = JTextArea.WHEN_FOCUSED;
        // get our maps for binding from the chatEnterArea JTextArea
        InputMap inputMap = taOut.getInputMap(condition);
        ActionMap actionMap = taOut.getActionMap();

        // the key stroke we want to capture
        KeyStroke enterStroke = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0);

        // tell input map that we are handling the enter key
        inputMap.put(enterStroke, enterStroke.toString());

        // tell action map just how we want to handle the enter key
        actionMap.put(enterStroke.toString(), new AbstractAction()
        {

            @Override
            public void actionPerformed(ActionEvent arg0)
            {
                // handle input (on enter key)
                String text = taOut.getText();
                String inputText;
                int currLength = text.length();
                int oldLength = consoleText.length();
                if (currLength > oldLength)
                {
                    inputText = text.substring(oldLength, currLength);
                }
                else
                {
                    inputText = null;
                }

                consoleText = text;

                inWriter.println(inputText);
            }
        });

        CaretListener caretListen = new CaretListener()
        {
            public void caretUpdate(CaretEvent caretEvent)
            {
                int caretPos = caretEvent.getDot();
                if (caretPos < consoleText.length())
                {
                    // prevent cursor from going into console output
                    taOut.setCaretPosition(consoleText.length());
                }
            }
        };

        taOut.addCaretListener(caretListen);


        new SwingWorker<Void, String>()
        {
            protected Void doInBackground() throws Exception
            {
                Scanner s = new Scanner(outPipe);
                while (s.hasNextLine())
                {
                    String line = s.nextLine();
                    publish(line);
                }
                return null;
            }
            @Override protected void process(java.util.List<String> chunks)
            {
                // Handle output
                for (String line : chunks)
                {
                    taOut.append("\n" + line);
                }

                consoleText = taOut.getText();
            }

        }.execute();

        console.add(scrollPane);
        window.add(imageFramePanel);
        window.add(imagePanel);
        window.add(console);

    }
    public class TitleScreenHandler implements ActionListener{
        public void actionPerformed(ActionEvent event){
            enterGameScreen();
        }
    }

    public void setImage(String newImage)
    {
        ImageIcon picture = new ImageIcon(this.getClass().getResource("forest.jpeg"));
        Image imgPicture = picture.getImage();
        Image scaledImgPicture = imgPicture.getScaledInstance(496,393, Image.SCALE_SMOOTH);
        ImageIcon scaledPicture = new ImageIcon(scaledImgPicture);

        consoleImage.setIcon(scaledPicture);
    }

}
