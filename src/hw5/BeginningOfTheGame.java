package hw5;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Created by Jenny on 3/28/14.
 */
public class BeginningOfTheGame extends JFrame implements ActionListener{
    private JPanel panel;
    private JTextArea text;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    public Player player;

    public BeginningOfTheGame(){
        setSize(400,170);
        this.panel = new JPanel();
        this.text = new JTextArea();
        this.text.setEditable(false);
        this.button1 = new JButton("Poe-tay-toe");
        this.button1.addActionListener(this);
        this.button2 = new JButton("Poh-tah-toh");
        this.button2.addActionListener(this);
        this.button3 = new JButton("Toe-may-toe");
        this.button3.addActionListener(this);
        this.button4 = new JButton("Toh-mah-toh");
        this.button4.addActionListener(this);
        this.button5 = new JButton("Grey");
        this.button5.addActionListener(this);
        this.button6 = new JButton("Beige");
        this.button6.addActionListener(this);
        this.button7 = new JButton("Health");
        this.button7.addActionListener(this);
        this.button8 = new JButton("Damage");
        this.button8.addActionListener(this);
        this.player = new Player(5, 50);

        this.add(panel);
        this.panel.add(text);

        this.text.setText("You're falling asleep - good night!");
        this.text.append(System.lineSeparator() + "Whoa! This is a weird dream..."
                + System.lineSeparator() + "Seems like you're in a labyrinth.");
        this.text.append(System.lineSeparator() + "This can mean only one thing! - Slay the minotaur to wake up!");
        this.text.append(System.lineSeparator() + "But first..." + System.lineSeparator() + "Poe-tay-toe or Puh-tah-toh?");

        this.panel.add(button1);
        this.panel.add(button2);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == button1){
            this.setSize(220, 120);
            panel.removeAll();
            this.panel.add(text);
            this.text.setText("Toe-may-toe or Toh-mah-toh?");
            panel.add(button3);
            panel.add(button4);
            this.player.health += 20;
            this.player.maxHealth +=20;
        }
        if (event.getSource() == button2){
            this.setSize(220, 120);
            panel.removeAll();
            this.panel.add(text);
            this.text.setText("Toe-may-toe or Toh-mah-toh?");
            panel.add(button3);
            panel.add(button4);
            this.player.damage += 2;
        }
        if (event.getSource() == button3){
            panel.removeAll();
            this.setSize(220, 121);
            this.panel.add(text);
            this.text.setText("Gray or Beige?");
            panel.add(button5);
            panel.add(button6);
            this.player.damage += 2;
        }
        if (event.getSource() == button4){
            panel.removeAll();
            this.setSize(220, 121);
            this.panel.add(text);
            this.text.setText("Gray or Beige?");
            panel.add(button5);
            panel.add(button6);
            this.player.health += 20;
            this.player.maxHealth +=20;
        }
        if (event.getSource() == button5){
            panel.removeAll();
            this.setSize(220, 120);
            this.panel.add(text);
            this.text.setText("Health or Damage?");
            panel.add(button7);
            panel.add(button8);
            this.player.damage += 2;
        }
        if (event.getSource() == button6){
            panel.removeAll();
            this.setSize(220, 120);
            this.panel.add(text);
            this.text.setText("Health or Damage?");
            panel.add(button7);
            panel.add(button8);
            this.player.health += 20;
            this.player.maxHealth +=20;
        }
        if (event.getSource() == button7){
            this.player.health += 20;
            this.player.maxHealth +=20;
            this.setVisible(false);

            Game theGame = new Game(this.player);

            //--- The map screen is a View of our game
            //--- It's also our Controller when navigating the map
            MainForm mapScreen = new MainForm(theGame);
            mapScreen.setVisible(true);
        }
        if (event.getSource() == button8){
            this.player.damage += 2;
            this.setVisible(false);

            Game theGame = new Game(this.player);

            //--- The map screen is a View of our game
            //--- It's also our Controller when navigating the map
            MainForm mapScreen = new MainForm(theGame);
            mapScreen.setVisible(true);
        }
    }
}
