package RolePlayingGame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Map implements KeyListener{

    int width;
    int height;
    char[][] map;
    char hero = '!';
    int xPlace = 0;
    int yPlace = 0;
    int objXPlace;
    int objYPlace;
    public List<Character> saveList = new ArrayList<Character>();
    private RolePlayingGame game;

    public Map(RolePlayingGame game, int width, int height){
        saveList.add('.');
        this.game = game;
        this.width = width;
        this.height = height;
        map = new char[width][height];
        Random dice = new Random();
        for(int x = 0; x < map.length; x++){
            for(int y = 0; y < map[0].length; y++){
                int randomSelect = dice.nextInt(99);
                if(randomSelect < 10){
                    map[x][y] = '*';
                }
                else if(randomSelect > 10 && randomSelect < 45){
                    map[x][y] = '-';
                }
                else{
                    map[x][y] = '.';
                }
            }
        }
        map[xPlace][yPlace] = hero;
    }

   public void move2 (KeyEvent e){
       map[xPlace][yPlace] = saveList.get(saveList.size()-1);
        if(e.getKeyCode() == KeyEvent.VK_UP){
            if(xPlace > 0)
            {
                xPlace -= 1;
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN){
            if(xPlace < map.length-1)
            {
                xPlace += 1;
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            if(yPlace < map[0].length-1)
            {
                yPlace += 1;
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            if(yPlace > 0)
            {
                yPlace -= 1;
            }
        }
        char save = map[xPlace][yPlace];
        saveList.add(save);
        map[xPlace][yPlace] = hero;
        game.printMap();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("Key was pressed: " + e.getKeyChar());
        move2(e);

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
