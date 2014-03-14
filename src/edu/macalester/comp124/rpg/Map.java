package edu.macalester.comp124.rpg;

/**
 * Created by Laura on 3/13/14.
 */
public class Map {
    private static int WIDTH = 50;
    private static int HEIGHT = 20;
    private static int LEFT_WALL = 15;
    private static int LEFT_DOOR_THREE = 13;
    private static int LEFT_DOOR_FOUR = 14;
    private static int LEFT_DOOR = 2;
    private static int LEFT_DOOR_TWO = 3;

    char pChar = '@';
    char filler = '.';
    char wall = 'w';
    int pX, pY;
    char[][] map;

    public Map(){
        map= new char[WIDTH][HEIGHT];
        pX = 0;
        pY = 0;
        fillMatrix();
        addWalls();
    }

    public void fillMatrix(){
        for (int x = 0; x<WIDTH; x++){
            for (int y = 0; y<HEIGHT; y++){
                map[x][y] = filler;
            }
        }
        map[pX][pY] = pChar;
    }

    public void addWalls(){
        for (int y=0; y<HEIGHT; y++){
            if (y!=LEFT_DOOR && y!=LEFT_DOOR_TWO && y!=LEFT_DOOR_THREE && y!=LEFT_DOOR_FOUR){
                map[LEFT_WALL][y] = wall;
            }
        }
        for (int x=0; x<=LEFT_WALL; x++){
            map[x][HEIGHT/2] = wall;
        }

    }

    public void movePlayer(char c){
        map[pX][pY] = filler;
        int newY=pY;
        int newX=pX;
        if (c=='n' && pY!=0){
            newY=pY-1;
        } else if(c=='s' && pY!=HEIGHT-1){
            newY=(pY+1);
        } else if(c=='e' && pX!=WIDTH-1){
            newX=pX+1;
        } else if(c=='w' && pX!=0){
            newX=pX-1;
        }
        if (map[newX][newY]!= 'w') {
           pX=newX;
           pY = newY;
        }
        map[pX][pY] = pChar;
    }

    @Override
    public String toString(){
        String content = "";
        for (int y = 0; y<HEIGHT; y++){
            for (int x =0; x<WIDTH; x++){
                content+= map[x][y];
            }
            content += System.lineSeparator();
        }
        return content;
    }
}
