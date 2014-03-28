package hw5;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

/**
 * Created by Jenny on 3/25/14.
 */
public class CombatForm extends JFrame implements ActionListener {

    private JButton fastAttackButton;
    private JButton heavyAttackButton;
    private JButton mediumAttackButton;
    private JLabel text;
    private JLabel playerHealth;
    private JLabel monsterHealth;
    private JPanel panel;
    private JPanel buttonPanel;
    private Monster monster;
    private Player player;
    private JLabel image;
    private Game game;
    private boolean combat;



    public CombatForm(Monster monster, Player player, Game game) {
        setSize(400, 400);
        this.game = game;
        panel = new JPanel();
        buttonPanel = new JPanel();
        fastAttackButton = new JButton("Fast Attack");
        fastAttackButton.addActionListener(this);
        mediumAttackButton = new JButton("Medium Attack");
        mediumAttackButton.addActionListener(this);
        heavyAttackButton = new JButton("Run Away");
        heavyAttackButton.addActionListener(this);
        text = new JLabel();
        this.monster = monster;
        this.player = player;
        ImageIcon image2 = new ImageIcon("RPG/images/"+monster.imageName);
        image = new JLabel(image2);
        monsterHealth = new JLabel();
        playerHealth = new JLabel();
        monsterHealth.setText("The monster's current health is: " + monster.endurance + "/" );
        playerHealth.setText("Your current health is: " + player.health + "/" + player.maxHealth);

        this.add(panel);
        panel.add(image);
        panel.add(text);
        panel.add(monsterHealth);
        panel.add(playerHealth);
        panel.add(buttonPanel);
        buttonPanel.add(fastAttackButton);
        buttonPanel.add(mediumAttackButton);
        buttonPanel.add(heavyAttackButton);

        if (!combat){
            game.untouched = true;
            this.setVisible(false);
        }
    }

    Timer timer = new Timer(2000,this);

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == fastAttackButton) {
            text.setText("You made a fast attack!");
        }
        if (event.getSource() == mediumAttackButton) {
            text.setText("You made a medium attack!");
        }
        if (event.getSource() == heavyAttackButton) {
            text.setText("You made a heavy attack!");
        }
        if(event.getSource() == timer)
        {
            timer.stop();
            this.setVisible(false);
        }
        combatRound();
    }

    private void combatRound() {
        boolean bool = true;
        if (player.health <= 0) {
            text.setText("YOU DIED! OH NO!");
            timer.start();
            bool = false;
        }
        if (monster.endurance <= 0) {
            text.setText("YOU WON! YAY!");
            timer.start();
            bool = false;
        }
        combat = bool;
    }

    public void speed(){
        int force = player.damage;
        int hurt = monster.attackForce;
    }
}
