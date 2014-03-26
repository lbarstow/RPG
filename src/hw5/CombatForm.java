package hw5;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

/**
 * Created by Jenny on 3/25/14.
 */
public class CombatForm extends JFrame implements ActionListener{

    private JButton fastAttackButton;
    private JButton heavyAttackButton;
    private JButton mediumAttackButton;
    private JLabel text;
    private JPanel panel;
    private JPanel buttonPanel;

    public CombatForm(){
        setSize(400,400);
        panel = new JPanel();
        buttonPanel = new JPanel();
        fastAttackButton = new JButton("Fast Attack");
        fastAttackButton.addActionListener(this);
        mediumAttackButton = new JButton("Medium Attack");
        mediumAttackButton.addActionListener(this);
        heavyAttackButton = new JButton("Heavy Attack");
        heavyAttackButton.addActionListener(this);
        text = new JLabel();

        this.add(panel);
        panel.add(text);
        panel.add(buttonPanel);
        buttonPanel.add(fastAttackButton);
        buttonPanel.add(mediumAttackButton);
        buttonPanel.add(heavyAttackButton);
    }
    @Override
    public void actionPerformed(ActionEvent event){
        if(event.getSource() == fastAttackButton){
            text.setText("You made a fast attack!");
        }
        if(event.getSource() == mediumAttackButton){
            text.setText("You made a medium attack!");
        }
        if(event.getSource() == heavyAttackButton){
            text.setText("You made a heavy attack!");
        }
    }
}
