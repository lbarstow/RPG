package hw5;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author baylor
 */
public class Application {
    public static void main(String[] args) {
        //--- The game is where all the interesting stuff happens
        //--- Formally, it's called the Model
        //--- The thing that draws the picture is called the View
        //--- The thing that lets players select actions is the Controller
        //CombatForm woo = new CombatForm();
        //woo.setVisible(true);
        //CombatForm woo = new CombatForm();
        //woo.setVisible(true);

        //CombatForm combo = new CombatForm();
        //combo.setVisible(true);

        //InteractionForm inter = new InteractionForm("Protein Powder", "Steroids", "Protein Powder increased you maximum health!", "The Steroids increased you maximum damage!");
        //inter.setVisible(true);

        BeginningOfTheGame beginningOfTheGame = new BeginningOfTheGame();
        beginningOfTheGame.setVisible(true);

       // while (beginningOfTheGame.getCompletion()) {
      //  }


    }

}
