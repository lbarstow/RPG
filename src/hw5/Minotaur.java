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
    List<Character> upDownDirectionList = new ArrayList<Character>();
    List<Character> rightLeftDirectionList = new ArrayList<Character>();


    @Override
    public void think()
    {
        upDownDirectionList.add('n');
        upDownDirectionList.add('s');
        rightLeftDirectionList.add('e');
        rightLeftDirectionList.add('w');
        int selectorInt = selector.nextInt(2);
        char direction = upDownDirectionList.get(selectorInt);
        moveMinotaur(direction);
        selectorInt = selector.nextInt(2);
        direction = rightLeftDirectionList.get(selectorInt);
        moveMinotaur(direction);
        selectorInt = selector.nextInt(2);
        direction = upDownDirectionList.get(selectorInt);
        moveMinotaur(direction);
        selectorInt = selector.nextInt(2);
        direction = rightLeftDirectionList.get(selectorInt);
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
