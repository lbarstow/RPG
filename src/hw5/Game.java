package hw5;

import java.awt.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author baylor
 */
public class Game
{
	public Map map;
	public Player player;	// change this to whatever subclass player is

	//--- A list of all the agents in the game (player, NPCs, monsters, etc.)
	//--- We need to know this so we know who to draw and so that we can ask
	//---	each turn what they want to do
	public List<Agent> agents = new LinkedList<Agent>();

    public HashMap<String, EquipableItem> weapons = new HashMap<>();
    public HashMap<String, Monster> creatures = new HashMap<>();
    public HashMap<String, Helper> animals = new HashMap<>();

	public Game()
	{
		//--- Load a map
		map = new Map("main");

		//--- Create a player, stick him in the top left corner
		player = new Player();
		player.x = 1;
		player.y = 1;

        EquipableItem item = new EquipableItem("q", "sword");
        weapons.put("q", item);
        item =  new EquipableItem("h", "helm");
        weapons.put("h", item);
        item = new EquipableItem("d", "sheild");
        weapons.put("d", item);

        Monster monster = new Monster("EyeMan", 1, 1);
        creatures.put("e", monster);
        monster = new Monster("Fire Monster", 1, 1);
        creatures.put("f", monster);
        monster = new Monster("Ogre", 1, 1);
        creatures.put("l", monster);

        Helper beast = new Helper("Phoenix", 1, 1);
        animals.put("s", beast);
        beast = new Helper("Gnome", 1, 1);
        animals.put("n", beast);

		//--- Add the player to the agents list. This list controls
		agents.add(player);
	}

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
        String newSpace = map.terrain[x][y];
        //gets character value in that spot on terrain map.
        //if player walks over an item, pick it up
        String item = map.items[x][y];
        if (null != item){
            map.pickUP(x, y);
            if (item.equals("g")){
                player.goldPickup();
            } else if (item.equals("q") || item.equals("d") || item.equals("h")){
                EquipableItem object = this.weapons.get(item);
                player.items.add(object);
                System.out.print("Player has");
                for (EquipableItem holding : player.items){
                    System.out.print(" a " + holding);
                }
                System.out.println();
            }
        }
        //if the character in that space is not a key in the dictionary of impassible characters, the player position is reset
        if (!map.passibility.containsKey(newSpace)){
            player.x = x;
            player.y = y;
        } else if (map.passibility.get(newSpace)){
            onTouchMonster(newSpace);
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

	private void onTouchMonster(String key)
	{
        if (creatures.containsKey(key)){
            Monster monster = creatures.get(key);
            System.out.println("Player hit " + monster);
        } else if(animals.containsKey(key)){
            Helper helper = animals.get(key);
            System.out.println("Player wants help from the " + helper + ".");
        }


		//--- Who did you run into?

		//--- Time to fight
//		CombatForm form = new CombatForm();
//		form.game = this;	// let them know about us so they can talk to us
//		form.enemies = ???;
//		form.run();
	}
}
