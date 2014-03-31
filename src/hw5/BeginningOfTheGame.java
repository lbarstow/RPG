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
    Timer timer = new Timer(2000, this);

    public BeginningOfTheGame(){
        setSize(300,100);
        panel = new JPanel();
        text = new JTextArea();
        button1 = new JButton("Jake");
        button2 = new JButton("Finn");
        this.add(panel);
        panel.add(text);
        schedule();
        timer.start();
        panel.add(button1);
        panel.add(button2);
        timer.start();
        this.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == button1){

        }
        if (event.getSource() == button2){

        }
        if (event.getSource() == timer) {
            timer.stop();
            this.setVisible(false);
        }
    }

    private void schedule(){
        text.setText("You're falling asleep - good night!");
        timer.start();
        text.setText("Whoa! This is a weird dream..." + System.lineSeparator() + "Seems like you're in a labyrinth.");
        timer.start();
        text.setText("This can mean only one thing! - Slay the minotaur to wake up!");
        timer.start();
        text.setText("But first choose whether you want to be Jake or Finn!");
    }
}
