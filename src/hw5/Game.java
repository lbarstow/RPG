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
    public Monster minotaurMonster = new Monster("Minotaur", 30, 140, "minotaurPic.png", 140);


    public Game(Player player) {
        //--- Load a map
        map = new Map("main");

        //--- Create a player, stick him in the top left corner
        this.player = player;
        //player = new Player(8, 100);
        this.player.x = 1;
        this.player.y = 1;
        minotaur = new Minotaur(map);
        minotaur.x = 26;
        minotaur.y = 16;

        EquipableItem item = new EquipableItem("q", "sword");
        weapons.put("q", item);
        item = new EquipableItem("h", "helm");
        weapons.put("h", item);
        item = new EquipableItem("d", "sheild");
        weapons.put("d", item);

        Monster monster1 = new Monster("EyeMan", 11, 72, "eyeHandsPic.png", 72);
        enemies.put("e", monster1);
        Monster monster2 = new Monster("Fire Monster", 11, 54, "fireyPic.png", 54);
        enemies.put("f", monster2);
        Monster monster3 = new Monster("Ogre", 15, 94, "ogrePic.png", 94);
        enemies.put("l", monster3);

        Helper beast1 = new Helper("Phoenix", 1, 1);
        helpers.put("s", beast1);
        Helper beast2 = new Helper("Gnome", 1, 1);
        helpers.put("n", beast2);

        //--- Add the player to the agents list. This list controls
        agents.add(player);
        agents.add(minotaur);
    }

    public void movePlayer(char direction) {
        checkDead();
        checkMinotaurDead();
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
            onTouchMonster(newSpace, x, y);
        }
        hitMinotaur();
        minotaur.think();
        minotaur.think();
    }

    /**
     * Run a turn. Did the player run into an enemy? An item?
     * What do the other agents (NPCs, monsters, etc.) want to do?
     */
    private void nextTurn() {
        //--- Do whatever you do in a turn
    }

    private void onTouchMonster(String key, int x, int y) {
        if (enemies.containsKey(key) && untouched) {
            untouched = false;
            Monster monster = enemies.get(key);
            CombatForm combo = new CombatForm(monster, player, this, x, y);
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
    }
        private void hitMinotaur(){
            //System.out.println("Player x: " + player.x + " Player y: " +
                    //player.y + " Minotaur x: " + minotaur.x + " Minotaur y: " + minotaur.y);
            if(player.x == minotaur.x && player.y == minotaur.y){
                //System.out.println("HIT THE MINOTAUR");
                CombatForm combo = new CombatForm(minotaurMonster, player, this, minotaur.x, minotaur.y);
                combo.setVisible(true);
            }
        }

    private void checkDead(){
        if(player.health <= 0){
            System.exit(0);
        }
    }

    private void checkMinotaurDead(){
        if(minotaurMonster.endurance <= 0){
            System.exit(0);
        }
    }


        //--- Who did you run into?

        //--- Time to fight

//		form.game = this;	// let them know about us so they can talk to us
//		form.enemies = ???;
//		form.run();
    }

