package hw5;

import java.awt.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author baylor
 */
public class Game {
    public Map map;
    public Player player;    // change this to whatever subclass player is
    public Minotaur minotaur;

    //--- A list of all the agents in the game (player, NPCs, monsters, etc.)
    //--- We need to know this so we know who to draw and so that we can ask
    //---	each turn what they want to do
    public List<Agent> agents = new LinkedList<Agent>();

    public HashMap<String, EquipableItem> weapons = new HashMap<String, EquipableItem>();
    public HashMap<String, Monster> enemies = new HashMap<String, Monster>();
    public HashMap<String, Helper> helpers = new HashMap<String, Helper>();
    public boolean untouched = true;

    public Game() {
        //--- Load a map
        map = new Map("main");

        //--- Create a player, stick him in the top left corner
        player = new Player(8, 100);
        player.x = 1;
        player.y = 1;
        minotaur = new Minotaur();
        minotaur.x = 26;
        minotaur.y = 16;

        EquipableItem item = new EquipableItem("q", "sword");
        weapons.put("q", item);
        item = new EquipableItem("h", "helm");
        weapons.put("h", item);
        item = new EquipableItem("d", "sheild");
        weapons.put("d", item);

        Monster monster1 = new Monster("EyeMan", 11, 72, "eyeHandsPic.png");
        enemies.put("e", monster1);
        Monster monster2 = new Monster("Fire Monster", 11, 54, "fireyPic.png");
        enemies.put("f", monster2);
        Monster monster3 = new Monster("Ogre", 15, 94, "ogrePic.png");
        enemies.put("l", monster3);

        Helper beast1 = new Helper("Phoenix", 1, 1);
        helpers.put("s", beast1);
        Helper beast2 = new Helper("Gnome", 1, 1);
        helpers.put("n", beast2);

        //--- Add the player to the agents list. This list controls
        agents.add(player);
    }

    public void movePlayer(char direction) {
        int x = player.x;
        int y = player.y;
        switch (direction) {
            case 'n':
                y = player.y - 1;
                break;
            case 's':
                y = player.y + 1;
                break;
            case 'e':
                x = player.x + 1;
                break;
            case 'w':
                x = player.x - 1;
                break;
        }
        String newSpace = map.terrain[x][y];
        //gets character value in that spot on terrain map.
        //if player walks over an item, pick it up
        String item = map.items[x][y];
        if (null != item) {
            map.pickUP(x, y);
            if (item.equals("g")) {
                player.goldPickup();
            } else if (item.equals("q")) {
                EquipableItem object = this.weapons.get(item);
                player.items.add(object);
                player.damage += 5;
            } else if (item.equals("d")){
                EquipableItem object = this.weapons.get(item);
                player.items.add(object);
                player.maxHealth += 20;
                player.health += 20;
            } else if (item.equals("h")){
                EquipableItem object = this.weapons.get(item);
                player.items.add(object);
                player.maxHealth += 10;
                player.health += 10;
            }
        }
        //if the character in that space is not a key in the dictionary of impassible characters, the player position is reset
        if (!map.passibility.containsKey(newSpace)) {
            player.x = x;
            player.y = y;
        } else if (map.passibility.get(newSpace)) {
            onTouchMonster(newSpace);
        }
    }

    /**
     * Run a turn. Did the player run into an enemy? An item?
     * What do the other agents (NPCs, monsters, etc.) want to do?
     */
    private void nextTurn() {
        //--- Do whatever you do in a turn
    }

    private void onTouchMonster(String key) {
        if (enemies.containsKey(key) && untouched) {
            untouched = false;
            Monster monster = enemies.get(key);
            CombatForm combo = new CombatForm(monster, player, this);
            combo.setVisible(true);
        } else if (helpers.containsKey(key) && untouched) {
            untouched = false;
            if(key.equals("n")){
            InteractionForm inter = new InteractionForm("Protein Powder", "Steroids",
                    "Protein Powder increased you maximum health!",
                    "The Steroids increased you maximum damage!", "gnomePic.png", this, player);
            inter.setVisible(true);
            }
            if(key.equals("s")){
                InteractionForm inter = new InteractionForm("Heal", "filler", "You healed to maximum health!",
                        "filler", "pheonixPic.png", this, player);
                inter.setVisible(true);
            }
        }


        //--- Who did you run into?

        //--- Time to fight

//		form.game = this;	// let them know about us so they can talk to us
//		form.enemies = ???;
//		form.run();
    }
}
