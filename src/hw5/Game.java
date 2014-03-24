package hw5;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author baylor
 */
public class Game
{
	public Map map;
	public Agent player;	// change this to whatever subclass player is

	//--- A list of all the agents in the game (player, NPCs, monsters, etc.)
	//--- We need to know this so we know who to draw and so that we can ask
	//---	each turn what they want to do
	public List<Agent> agents = new LinkedList<Agent>();

	public Game()
	{
		//--- Load a map
		map = new Map("main");

		//--- Create a player, stick him in the top left corner
		player = new Player();
		player.x = 1;
		player.y = 1;

		//--- Add the player to the agents list. This list controls
		agents.add(player);
	}

/*	public void movePlayer(int x, int y)
	{
        String newSpace = map.terrain[x][y]; //gets character value in that
        //if the character in that space is not a key in the dictionary of impassible characters, the player position is reset
        if (!map.passibility.containsKey(newSpace)){
            player.x = x;
            player.y = y;
        }

		//--- Don't do anything if the move is illegal


		//--- Assuming this is the last thing that happens in the round,
		//---	start a new round. This lets the other agents make their moves.
		nextTurn();
	}
*/
	public void movePlayer(char direction)
	{
        int x = player.x;
        int y = player.y;
		switch(direction)
		{
			case 'n':
				y = player.y-1;
				break;
			case 's':
				y = player.y+1;
				break;
			case 'e':
				x = player.x+1;
				break;
			case 'w':
				x = player.x-1;
				break;
		}
        String newSpace = map.terrain[x][y]; //gets character value in that spot on terrain map.
        if (null != map.items[x][y]){
            map.pickUP(x, y);
            player.goldPickup();
        }
        //if the character in that space is not a key in the dictionary of impassible characters, the player position is reset
        if (!map.passibility.containsKey(newSpace)){
            player.x = x;
            player.y = y;
        }
	}

	/**
	 * Run a turn. Did the player run into an enemy? An item?
	 * What do the other agents (NPCs, monsters, etc.) want to do?
	 */
	private void nextTurn()
	{
		//--- Do whatever you do in a turn
	}

	private void onTouchMonster()
	{
		//--- Who did you run into?

		//--- Time to fight
//		CombatForm form = new CombatForm();
//		form.game = this;	// let them know about us so they can talk to us
//		form.enemies = ???;
//		form.run();
	}
}
