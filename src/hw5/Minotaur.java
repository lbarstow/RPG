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
    List<String> nDirectionList = new ArrayList<String>();
    List<String> sDirectionList = new ArrayList<String>();
    List<String> wDirectionList = new ArrayList<String>();
    List<String> eDirectionList = new ArrayList<String>();


    @Override
    public void think()
    {
        nDirectionList.add("n");
        nDirectionList.add("n");
        nDirectionList.add("n");
        nDirectionList.add("n");
        nDirectionList.add("n");
        nDirectionList.add("n");
        nDirectionList.add("n");
        nDirectionList.add("s");
        nDirectionList.add("e");
        nDirectionList.add("w");

        sDirectionList.add("n");
        sDirectionList.add("s");
        sDirectionList.add("s");
        sDirectionList.add("s");
        sDirectionList.add("s");
        sDirectionList.add("s");
        sDirectionList.add("s");
        sDirectionList.add("s");
        sDirectionList.add("e");
        sDirectionList.add("w");

        eDirectionList.add("n");
        eDirectionList.add("s");
        eDirectionList.add("e");
        eDirectionList.add("e");
        eDirectionList.add("e");
        eDirectionList.add("e");
        eDirectionList.add("e");
        eDirectionList.add("e");
        eDirectionList.add("e");
        eDirectionList.add("w");

        wDirectionList.add("n");
        wDirectionList.add("s");
        wDirectionList.add("e");
        wDirectionList.add("w");
        wDirectionList.add("w");
        wDirectionList.add("w");
        wDirectionList.add("w");
        wDirectionList.add("w");
        wDirectionList.add("w");
        wDirectionList.add("w");



        if(map.getKey(this.x,this.y).equals(".")){
            int selectorInt = selector.nextInt(10);
            String direction = nDirectionList.get(selectorInt);
            moveMinotaur(direction);
        }
        if(map.getKey(this.x,this.y).equals("\'")){
            int selectorInt = selector.nextInt(10);
            String direction = sDirectionList.get(selectorInt);
            moveMinotaur(direction);
        }
        if(map.getKey(this.x,this.y).equals("`")){
            int selectorInt = selector.nextInt(10);
            String direction = eDirectionList.get(selectorInt);
            moveMinotaur(direction);
        }
        if(map.getKey(this.x,this.y).equals("\"")){
            int selectorInt = selector.nextInt(10);
            String direction = wDirectionList.get(selectorInt);
            moveMinotaur(direction);
        }
    }

    public void moveMinotaur(String direction) {
        int a = x;
        int b = y;
        switch (direction) {
            case "n":
                b = y - 1;
                break;
            case "s":
                b = y + 1;
                break;
            case "e":
                a = x + 1;
                break;
            case "w":
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
