package hw5;

import javax.swing.*;
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
    private JLabel playerGold;

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
        playerGold = new JLabel();
        playerDamage.setText("Your Maximum Damage is: "+player.damage);
        playerHealth.setText("Your current Health is: "+player.health);
        playerMaxHealth.setText("Your Maximum Health is: "+player.maxHealth);
        playerGold.setText("You have " + player.gold + " Gold.");

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
        panel.add(playerGold);
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
                   player.maxHealth += 10;
                   player.health += 10;
                   player.gold -= 2;
                   playerMaxHealth.setText("Your Maximum Health is: "+player.maxHealth);
                   playerGold.setText("You have " + player.gold +" Gold.");
                } else {
                   player.health = player.maxHealth;
                   player.gold -= 2;
                   playerHealth.setText("Your current Health is: "+player.health);
                   playerGold.setText("You have " + player.gold +" Gold.");
                }
            } else {
                text.setText("You do not have enough gold!");
            }
        }
        if (event.getSource() == secondButton) {
            if (player.gold >= 2) {
                text.setText(action2);
                player.damage += 2;
                player.gold -= 2;
                playerDamage.setText("Your Maximum Damage is: "+ player.damage);
                playerGold.setText("You have " + player.gold +" Gold.");
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
}

