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
    private JButton runAwayButton;
    private JButton heavyAttackButton;
    private JLabel text;
    private JLabel playerHealth;
    private JLabel monsterHealth;
    private JPanel panel;
    private JPanel buttonPanel;
    private Monster monster;
    private Player player;
    private JLabel image;
    public Game game;
    private boolean combat;
    private int x;
    private int y;



    public CombatForm(Monster monster, Player player, Game game, int x, int y) {
        this.x =x;
        this.y = y;
        setSize(400, 400);
        this.game = game;
        panel = new JPanel();
        buttonPanel = new JPanel();
        fastAttackButton = new JButton("Attack With Speed");
        fastAttackButton.addActionListener(this);
        heavyAttackButton = new JButton("Attack With Force");
        heavyAttackButton.addActionListener(this);
        runAwayButton = new JButton("Run Away");
        runAwayButton.addActionListener(this);
        text = new JLabel();
        this.monster = monster;
        this.player = player;
        ImageIcon image2 = new ImageIcon("RPG/images/"+monster.imageName);
        image = new JLabel(image2);
        monsterHealth = new JLabel();
        playerHealth = new JLabel();
        monsterHealth.setText("The monster's current health is: " + monster.endurance + "/" + monster.fierceness);
        playerHealth.setText("Your current health is: " + player.health + "/" + player.maxHealth);

        this.add(panel);
        panel.add(image);
        panel.add(text);
        panel.add(monsterHealth);
        panel.add(playerHealth);
        panel.add(buttonPanel);
        buttonPanel.add(fastAttackButton);
        buttonPanel.add(heavyAttackButton);
        buttonPanel.add(runAwayButton);
    }

    Timer timer = new Timer(2000,this);

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == fastAttackButton) {
            text.setText("You made a fast attack!");
            speed();
            combat = combatRound();
            if(!combat){

            }
        }
        if (event.getSource() == heavyAttackButton) {
            text.setText("You made a heavy attack!");
            force();
            combat = combatRound();
            if(!combat){

            }
        }
        if (event.getSource() == runAwayButton) {
            text.setText("You ran away!");
            flee();
            timer.start();
        }
        if(event.getSource() == timer)
        {
            game.untouched = true;
            timer.stop();
            this.setVisible(false);
        }
        monsterHealth.setText("The monster's current health is: " + monster.endurance + "/" + monster.fierceness);
        playerHealth.setText("Your current health is: " + player.health + "/" + player.maxHealth);
    }

    private boolean combatRound() {
        boolean bool = true;
        if (player.health <= 0) {
            text.setText("YOU DIED! OH NO!");
            timer.start();
        }
        if (monster.endurance <= 0) {
            text.setText("YOU WON! YAY!");
            if(monster.mName.equalsIgnoreCase("EyeMan")){
                player.gold += 14;
            }
            if(monster.mName.equalsIgnoreCase("Fire Monster")){
                player.gold += 10;
            }
            if(monster.mName.equalsIgnoreCase("Ogre")){
                player.gold += 20;
            }
            if(monster.mName.equalsIgnoreCase("Minotaur")){
                bool = false;
            }
            game.map.kill(x, y);
            timer.start();
        }
        return bool;
    }

    public void speed(){
        int force = player.damage;
        int hurt = monster.attackForce;
        if (monster.mName.equals("Ogre") || monster.mName.equals("EyeMan")){
            monster.endurance -= force;
            player.health -= hurt-2;
        } else {
            monster.endurance -= force-2;
            player.health -= hurt;
        }
    }

    public void force() {
        int force = player.damage;
        int hurt = monster.attackForce;
        if (monster.mName.equals("Fire Monster")){
            monster.endurance -= force;
            player.health -= hurt-2;
        } else {
            monster.endurance -= force-2;
            player.health -= hurt;
        }
    }

    public void flee() {
        int loss = (monster.fierceness-monster.endurance)/2;
        monster.endurance += loss;
    }
}
