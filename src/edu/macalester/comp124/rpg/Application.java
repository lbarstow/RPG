package edu.macalester.comp124.rpg;

import acm.program.ConsoleProgram;
import acm.util.RandomGenerator;

/**
 * Created by Laura on 3/10/14.
 */
public class Application
extends ConsoleProgram{

    public void run(){
        Map map = new Map();
        print(map);
        //move player to bottom left corner to break
        while (map.pX!= 0 || map.pY!=9){
            char direction = readChar("How would you like to move (n, s, e, w) ?" );
            map.movePlayer(direction);
            println(map);
        }

    }



}
