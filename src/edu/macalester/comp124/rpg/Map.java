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
    }

    public void fillMatrix(){
        for (int x = 0; x<WIDTH; x++){
            for (int y = 0; y<HEIGHT; y++){
                if (y==WALL_TOP && x>=WALL_LEFT_BOUND && x<= WALL_RIGHT_BOUND) {
                   map[x][y]= 'w';
                } else if (x==WALL_LEFT_BOUND && y>=WALL_TOP && y<= WALL_BOTTOM){
                   map[x][y] = 'w';
                } else {
                   map[x][y] = '.';
                }
            }
        }
        map[pX][pY] = pChar;
    }

    public void setPlayer(int x, int y ){
        int oldX = pX;
        int oldY = pY;
        if (map[x][y]!= 'w'){
            pX=x;
            pY=y;
            if (x<0){
                pX=0;
            } else if(x>=WIDTH){
                pX=WIDTH-1;
            } else if(y<0){
                pY=0;
            } else if (y>=HEIGHT){
                pY=HEIGHT-1;
            }
            map[oldX][oldY] = filler;
        }
        this.map[pX][pY]=pChar;
    }


    public void movePlayer(char c){
        map[pX][pY] = filler;
        int newY=pY;
        int newX=pX;
        if (c=='n'){
            newY=pY-1;
        } else if(c=='s'){
            newY=(pY+1);
        } else if(c=='e'){
            newX=pX+1;
        } else if(c=='w'){
            newX=pX-1;
        }
        setPlayer(newX, newY);
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
