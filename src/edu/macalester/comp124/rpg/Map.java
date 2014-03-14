package edu.macalester.comp124.rpg;

/**
 * Created by Laura on 3/13/14.
 */
public class Map {
    private static int WIDTH = 10;
    private static int HEIGHT = 10;
    private static int WALL_LEFT_BOUND = 3;
    private static int WALL_RIGHT_BOUND = 6;
    private static int WALL_TOP = 2;
    private static int WALL_BOTTOM = 7;

    char pChar = '@';
    char filler = '.';
    int pX, pY;
    char[][] map;

    public Map(){
        map= new char[WIDTH][HEIGHT];
        pX = 0;
        pY = 0;
        fillMatrix();
        addWall();
    }

    public void fillMatrix(){
        for (int x = 0; x<WIDTH; x++){
            for (int y = 0; y<HEIGHT; y++){
                   map[x][y] = filler;
            }
        }
        map[pX][pY] = pChar;
    }

    public void addWall(){
        for (int x=WALL_LEFT_BOUND; x<=WALL_RIGHT_BOUND; x++){
            map[x][WALL_TOP] = 'w';
        }
        for (int y=WALL_TOP; y<=WALL_BOTTOM; y++){
            map[WALL_LEFT_BOUND][y] = 'w';
            map[WALL_RIGHT_BOUND][y] = 'w';
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
