package hw5;

import java.util.ArrayList;

/**
 *
 * @author baylor
 */
public class Player
	extends Agent
{
    int gold;
    int damage;
    int health;
    int maxHealth;
    ArrayList<EquipableItem> items;
    boolean isAlive;

	public Player(int damage, int maxHealth)
	{
		super("player");
        this.maxHealth = maxHealth;
        this.damage = damage;
        this.health = this.maxHealth;
        this.gold = 0;
        isAlive = true;
        this.items = new ArrayList<EquipableItem>();
	}

    public void goldPickup()
    {
        this.gold += 1;
      //  System.out.println("player has " + this.gold + " gold");
    }

	@Override
	public void think()
	{
		//--- We don't think, the player thinks for us
	}
}
