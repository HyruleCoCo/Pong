package package01;

import javax.swing.*;
import javax.swing.plaf.basic.BasicMenuUI.ChangeHandler;

import package01.Game.ChoiceHandler;

import java.awt.*;

public class UI {
    
    JFrame window;
    JPanel titleNamePanel, startButtonPanel, controlChoicePanel, controlButtonPanel, difficultyChoicePanel, difficultyButtonPanel;
    JLabel titleNameLabel, controlChoiceLabel, difficultyChoiceLabel;
    JButton p1Button, p2Button, mouseButton, keyboardButton, easyButton, hardButton;
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
    Font titleFont2 = new Font("Times New Roman", Font.PLAIN, 45);
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 26);

    public void createUI(ChoiceHandler cHandle){
        // Window
        window = new JFrame("Pong");
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);

        // Title Screen
        createTitleScreen(cHandle);

        createControlUI(cHandle);

        createDificultyUI(cHandle);

        window.setVisible(true);
    }

    public void createTitleScreen(ChoiceHandler cHandle){
        // Title
        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(100, 100, 600, 200);
        titleNamePanel.setBackground(Color.black);
        titleNameLabel = new JLabel("PONG");
        titleNameLabel.setForeground(Color.white);
        titleNameLabel.setFont(titleFont);
        titleNamePanel.add(titleNameLabel);

        // Start Button
        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(100, 300, 600, 100);
        startButtonPanel.setBackground(Color.black);
        startButtonPanel.setLayout(new GridLayout(1, 2));

        p1Button = new JButton("1 PLAYER");
        p1Button.setBackground(Color.black);
        p1Button.setForeground(Color.white);
        p1Button.setFont(normalFont);
        p1Button.setFocusPainted(false);
        p1Button.addActionListener(cHandle);
        p1Button.setActionCommand("1p");
        startButtonPanel.add(p1Button);

        p2Button = new JButton("2 PLAYER");
        p2Button.setBackground(Color.black);
        p2Button.setForeground(Color.white);
        p2Button.setFont(normalFont);
        p2Button.setFocusPainted(false);
        p2Button.addActionListener(cHandle);
        p2Button.setActionCommand("2p");
        startButtonPanel.add(p2Button);

        window.add(titleNamePanel);
        window.add(startButtonPanel);
    }

    public void createControlUI(ChoiceHandler cHandle){
        controlChoicePanel = new JPanel();
        controlChoicePanel.setBounds(75, 100, 650, 200);
        controlChoicePanel.setBackground(Color.black);
        controlChoiceLabel = new JLabel("CHOOSE YOUR CONTROLS");
        controlChoiceLabel.setForeground(Color.white);
        controlChoiceLabel.setFont(titleFont2);
        controlChoicePanel.add(controlChoiceLabel);

        controlButtonPanel = new JPanel();
        controlButtonPanel.setBounds(100, 300, 600, 100);
        controlButtonPanel.setBackground(Color.black);
        controlButtonPanel.setLayout(new GridLayout(1, 2));

        mouseButton = new JButton("MOUSE"); 
        mouseButton.setBackground(Color.black);
        mouseButton.setForeground(Color.white);
        mouseButton.setFont(normalFont);
        mouseButton.setFocusPainted(false);
        mouseButton.addActionListener(cHandle);
        mouseButton.setActionCommand("mouse");
        controlButtonPanel.add(mouseButton);

        keyboardButton = new JButton("KEYBOARD"); 
        keyboardButton.setBackground(Color.black);
        keyboardButton.setForeground(Color.white);
        keyboardButton.setFont(normalFont);
        keyboardButton.setFocusPainted(false);
        keyboardButton.addActionListener(cHandle);
        keyboardButton.setActionCommand("keyboard");
        controlButtonPanel.add(keyboardButton);

        window.add(controlChoicePanel);
        window.add(controlButtonPanel);
    }

    public void createDificultyUI(ChoiceHandler cHandle){
        difficultyChoicePanel = new JPanel();
        difficultyChoicePanel.setBounds(75, 100, 650, 200);
        difficultyChoicePanel.setBackground(Color.black);
        difficultyChoiceLabel = new JLabel("CHOOSE YOUR DIFFICULTY");
        difficultyChoiceLabel.setForeground(Color.white);
        difficultyChoiceLabel.setFont(titleFont2);
        difficultyChoicePanel.add(difficultyChoiceLabel);

        difficultyButtonPanel = new JPanel();
        difficultyButtonPanel.setBounds(100, 300, 600, 100);
        difficultyButtonPanel.setBackground(Color.black);
        difficultyButtonPanel.setLayout(new GridLayout(1, 2));

        easyButton = new JButton("EASY"); 
        easyButton.setBackground(Color.black);
        easyButton.setForeground(Color.white);
        easyButton.setFont(normalFont);
        easyButton.setFocusPainted(false);
        easyButton.addActionListener(cHandle);
        easyButton.setActionCommand("easy");
        difficultyButtonPanel.add(easyButton);

        hardButton = new JButton("HARD"); 
        hardButton.setBackground(Color.black);
        hardButton.setForeground(Color.white);
        hardButton.setFont(normalFont);
        hardButton.setFocusPainted(false);
        hardButton.addActionListener(cHandle);
        hardButton.setActionCommand("hard");
        difficultyButtonPanel.add(hardButton);

        window.add(difficultyChoicePanel);
        window.add(difficultyButtonPanel);

    }
}
