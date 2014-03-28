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
    Timer timer = new Timer(1000, this);

    public BeginningOfTheGame(){
        panel = new JPanel();
        text = new JTextArea();
        this.add(panel);
        panel.add(text);
        schedule();
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == timer) {
            timer.stop();
            this.setVisible(false);
        }
    }

    private void schedule(){
        text.setText("You're falling asleep - good night!");
        timer.start();
        text.setText("Whoa! This is a weird dream you are starting..." + System.lineSeparator());

    }
}
