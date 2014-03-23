package RolePlayingGame;

import acm.program.ConsoleProgram;

public class RolePlayingGame
        extends ConsoleProgram {
    private Map gameMap;
    public void run() {
        gameMap = new Map(this, 15, 30);

    }

    public void printMap()
    {
        for (int x = 0; x < gameMap.map.length; x++) {
            for (int y = 0; y < gameMap.map[0].length; y++) {
                print(gameMap.map[x][y]);
            }
            println();
        }
        print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }

    public Map getMap(){
        return gameMap;
    }
}
