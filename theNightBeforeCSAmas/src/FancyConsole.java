import javax.swing.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.*;
import java.util.Scanner;

import static javax.swing.BorderFactory.createEmptyBorder;

public class FancyConsole extends JFrame{
    //All of my panels and everything that goes in a JFrame
    JFrame window, gameWindow;
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

    //input and output streams for console part
    private final PipedInputStream inPipe = new PipedInputStream();
    private final PipedInputStream outPipe = new PipedInputStream();
    PrintWriter inWriter;

    //styling
    Font titleFont = new Font("American Typewriter", Font.BOLD, 40);
    Font normalFont = new Font("American Typewriter", Font.PLAIN, 30);
    Color lilac = new Color(225, 199, 255);
    Color darkerLilac = new Color(202, 164, 255);

    FancyConsole(){
        //setting up input and output streams
        System.setIn(inPipe);
        try {
            System.setOut(new PrintStream(new PipedOutputStream(outPipe), true));
            inWriter = new PrintWriter(new PipedOutputStream(inPipe), true);
        } catch (IOException e) {
            System.out.println("Error: " + e);
            return;
        }
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

        //adds a stylistic shadow to the main titlePanel
        titleShadowPanel = new JPanel();
        titleShadowPanel.setBounds(125,125, 600, 150);
        titleShadowPanel.setBackground(darkerLilac);
        window.add(titleShadowPanel);

        //button pannel
        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(300, 500, 200, 50);
        startButtonPanel.setBackground(lilac);

        //button placed in button pannel
        startButton = new JButton("start");
        startButton.setBackground(Color.white);
        startButton.setForeground(lilac);
        startButton.setFont(normalFont);
        startButton.addActionListener(tsHandler);

        //startButton added to button pannel and pannel added to window
        startButtonPanel.add(startButton);
        window.add(startButtonPanel);

        iconPanel = new JPanel();
        iconPanel.setBounds(300, 300, 200, 200);
        iconPanel.setBackground(lilac);

        //sets icon for title page to priya
        ImageIcon priya = new ImageIcon(this.getClass().getResource("priya.png"));
        Image imagePriya = priya.getImage();
        Image scaledImagePriya = imagePriya.getScaledInstance(200,210, Image.SCALE_SMOOTH);
        ImageIcon scaledPriya = new ImageIcon(scaledImagePriya);
        iconLabel = new JLabel();
        iconLabel.setIcon(scaledPriya);
        iconPanel.add(iconLabel);
        window.add(iconPanel);

        window.setVisible(true); //sets the entire window visible


    }
    public void enterGameScreen() {
        //new window
        //creating all the styling and panels for console and image
        gameWindow = new JFrame();
        gameWindow.setLayout(null);
        gameWindow.getContentPane().setBackground(lilac);

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
        console.setBounds(16, 425, 496, 125);
        console.setBackground(Color.white);
        taOut = new JTextArea(8, 40);
        taOut.setFont(new Font("American Typewriter", Font.PLAIN, 12));
        taOut.setForeground(new Color(163, 94, 255));
        scrollPane = new JScrollPane(taOut);
        scrollPane.setBorder(createEmptyBorder());
        console.add(scrollPane);

        gameWindow.add(imageFramePanel);
        gameWindow.add(imagePanel);
        gameWindow.add(console);

        // to get the correct InputMap
        int condition = JTextArea.WHEN_FOCUSED;
        // get our maps for binding from the chatEnterArea JTextArea
        InputMap inputMap = taOut.getInputMap(condition);
        ActionMap actionMap = taOut.getActionMap();

        // the keystroke we want to capture
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

        gameWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        gameWindow.setVisible(true);
        gameWindow.setSize(800,600);

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
    }

    //on button click the title window gets disposed and the gamescreen window pops up
    public class TitleScreenHandler implements ActionListener{
        public void actionPerformed(ActionEvent event){
            window.dispose();
            enterGameScreen();
        }
    }

    public void setImage(String newImage)
    {
        ImageIcon imageIcon = new ImageIcon(this.getClass().getResource(newImage));
        Image img = imageIcon.getImage();
        Image scaledImg = img.getScaledInstance(496,393,java.awt.Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImg);

        consoleImage.setIcon(scaledIcon);
    }

}
