package RolePlayingGame;

import acm.program.GraphicsProgram;

/**
 * Created by Jenny on 3/12/14.
 */
public class Window extends GraphicsProgram{
    public void run(){
        RolePlayingGame game = new RolePlayingGame();
        game.run();
        getGCanvas().addKeyListener(game.getMap());
        add(game.getConsole());
    }
}
