package hw5;

import acm.graphics.GCanvas;
import acm.graphics.GImage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Jenny on 3/26/14.
 */
public class InteractionForm extends JFrame implements ActionListener {

    private JButton firstButton;
    private JButton secondButton;
    private JButton exitButton;
    private JLabel text;
    private JPanel panel;
    private JPanel buttonPanel;
    private String action1;
    private String action2;
    private JLabel image;
    private Game game;
    private Player player;
    private String imageName;
    private JLabel playerHealth;
    private JLabel playerMaxHealth;
    private JLabel playerDamage;
    private Helper helper;

/*
     if(key.equals("n")){
            InteractionForm inter = new InteractionForm("Protein Powder", "Steroids",
                    "Protein Powder increased you maximum health!",
                    "The Steroids increased you maximum damage!", "gnomePic.png", this, player);
            inter.setVisible(true);
            }

     */
//public InteractionForm(String string1, String string2, String action1, String action2, String imageName, Game game, Player player)

    public InteractionForm(Helper helper, Game game, Player player) {
        setSize(400, 400);
        this.game = game;
        this.player = player;
        this.helper = helper;
        if (helper.description.equals("Phoenix")){
            this.imageName = "pheonixPic.png";
            firstButton = new JButton("Heal");
            secondButton = new JButton("filler");
            this.action1 = "You healed to maximum health!";
            this.action2 = "filler";
        } else if (helper.description.equals("Gnome")){
            this.imageName = "gnomePic.png";
            firstButton = new JButton("Protein Powder");
            secondButton = new JButton("Steroids");
            this.action1 = "Protein Powder increased you maximum health!";
            this.action2 = "The Steroids increased you maximum damage!";
        }

        panel = new JPanel();
        buttonPanel = new JPanel();
        firstButton.addActionListener(this);
        secondButton.addActionListener(this);
        exitButton = new JButton("Exit");
        exitButton.addActionListener(this);
        text = new JLabel();
        ImageIcon image2 = new ImageIcon("RPG/images/" + imageName);
        image = new JLabel(image2);
        playerDamage = new JLabel();
        playerMaxHealth = new JLabel();
        playerHealth = new JLabel();
        playerDamage.setText("Your Maximum Damage is: "+player.damage);
        playerHealth.setText("Your current Health is: "+player.health);
        playerMaxHealth.setText("Your Maximum Health is: "+player.maxHealth);

        this.add(panel);
        panel.add(image);
        panel.add(text);
        if (imageName.equalsIgnoreCase("gnomePic.png")) {
            panel.add(playerDamage);
            panel.add(playerMaxHealth);
            text.setText("I'll sell you protein powder and steroids for 2 gold each!");
        } else {
            panel.add(playerHealth);
            text.setText("I'll heal you completely 2 gold!");
        }
        panel.add(buttonPanel);
        buttonPanel.add(firstButton);
        if (imageName.equalsIgnoreCase("gnomePic.png")) {
            buttonPanel.add(secondButton);
        }
        buttonPanel.add(exitButton);
    }

    Timer timer = new Timer(2000, this);

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == firstButton) {
            if (player.gold >= 2) {
                text.setText(action1);
                if (helper.description.equals("Gnome")) {
                   player.maxHealth += 2;
                } else {
                   player.health = player.maxHealth;
                }
            } else {
                text.setText("You do not have enough gold!");
            }
        }
        if (event.getSource() == secondButton) {
            if (player.gold >= 2) {
                text.setText(action2);
                player.damage += 1;
            } else {
                text.setText("You do not have enough gold!");
            }
        }
        if (event.getSource() == exitButton) {
            game.untouched = true;
            text.setText("Thank you! Come again!");
            timer.start();
        }
        if (event.getSource() == timer) {
            timer.stop();
            this.setVisible(false);
        }
    }

/*
    public InteractionForm(String string1, String string2, String action1, String action2, String imageName, Game game, Player player) {
        setSize(400, 400);
        this.game = game;
        this.player = player;
        this.imageName = imageName;
        this.action1 = action1;
        this.action2 = action2;
        panel = new JPanel();
        buttonPanel = new JPanel();
        firstButton = new JButton(string1);
        firstButton.addActionListener(this);
        secondButton = new JButton(string2);
        secondButton.addActionListener(this);
        exitButton = new JButton("Exit");
        exitButton.addActionListener(this);
        text = new JLabel();
        ImageIcon image2 = new ImageIcon("RPG/images/" + imageName);
        image = new JLabel(image2);
        playerDamage = new JLabel();
        playerMaxHealth = new JLabel();
        playerHealth = new JLabel();
        playerDamage.setText("Your Maximum Damage is: "+player.damage);
        playerHealth.setText("Your current Health is: "+player.health);
        playerMaxHealth.setText("Your Maximum Health is: "+player.maxHealth);

        this.add(panel);
        panel.add(image);
        panel.add(text);
        if (imageName.equalsIgnoreCase("gnomePic.png")) {
            panel.add(playerDamage);
            panel.add(playerMaxHealth);
            text.setText("I'll sell you protein powder and steroids for 2 gold each!");
        } else {
            panel.add(playerHealth);
            text.setText("I'll heal you completely 2 gold!");
        }
        panel.add(buttonPanel);
        buttonPanel.add(firstButton);
        if (imageName.equalsIgnoreCase("gnomePic.png")) {
            buttonPanel.add(secondButton);
        }
        buttonPanel.add(exitButton);
    }

    Timer timer = new Timer(2000, this);

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == firstButton) {
            if (player.gold >= 2) {
                text.setText(action1);
                if (imageName.equalsIgnoreCase("gnomePic.png")) {
                   player.maxHealth += 2;
                } else {
                   player.health = player.maxHealth;
                }
            } else {
                text.setText("You do not have enough gold!");
            }
        }
        if (event.getSource() == secondButton) {
            if (player.gold >= 2) {
                text.setText(action2);
                player.damage += 1;
            } else {
                text.setText("You do not have enough gold!");
            }
        }
        if (event.getSource() == exitButton) {
            game.untouched = true;
            text.setText("Thank you! Come again!");
            timer.start();
        }
        if (event.getSource() == timer) {
            timer.stop();
            this.setVisible(false);
        }
    }

     */
}

