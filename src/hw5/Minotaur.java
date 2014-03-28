package hw5;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Jenny on 3/27/14.
 */
public class Minotaur extends Agent{
    Map map;

    public Minotaur(Map map){
        super("minotaur");
        this.map = map;
    }

    Random selector = new Random();
    List<Character> directionList = new ArrayList<Character>();


    @Override
    public void think()
    {
        directionList.add('n');
        directionList.add('s');
        directionList.add('e');
        directionList.add('w');
        int selectorInt = selector.nextInt(4);
        char direction = directionList.get(selectorInt);
        moveMinotaur(direction);
    }

    public void moveMinotaur(char direction) {
        int a = x;
        int b = y;
        switch (direction) {
            case 'n':
                b = y - 1;
                break;
            case 's':
                b = y + 1;
                break;
            case 'e':
                a = x + 1;
                break;
            case 'w':
                a = x - 1;
                break;
        }
        String newSpace = map.terrain[a][b];
        //gets character value in that spot on terrain map.
        //if the character in that space is not a key in the dictionary of impassible characters, the player position is reset
        if (!map.passibility.containsKey(newSpace)) {
            x = a;
            y = b;
        }
        }
}
