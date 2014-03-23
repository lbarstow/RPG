package edu.macalester.comp124.rpg;

public class Map {
    char pChar = '@';
    char filler = '.';

    char tChar;
    int height, width;
    int pX, pY;
    int tX, tY;
    char[][] map;


    public Map(int width, int height, char tC){
        this.height= height;
        this.width = width;
        this.map= new char[width][height];
        this.tChar = tC;
        fillMatrix(filler);

    }

    public void fillMatrix(char r){
        for (int x = 0; x<width; x++){
            for (int y = 0; y<height; y++){
                map[x][y]=r;
            }
        }
    }

    public void setPlayer(int x, int y ){
        pX=x;
        pY=y;
        if (x<0){
            pX=0;
        } else if(x>width-1){
            pX=width-1;
        }
        if(y<0){
            pY=0;
        } else if (y>height-1){
            pY=height-1;
        }
        map[pX][pY]=pChar;
    }

    public void setTarget(int x, int y){
        tX=x;
        tY=y;
        map[tX][tY]=tChar;
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
        for (int y = 0; y<height; y++){
            for (int x =0; x<width; x++){
                content+= map[x][y];
            }
            content += System.lineSeparator();
        }
        return content;
    }
}
