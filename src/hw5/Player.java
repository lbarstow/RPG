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
    ArrayList<String> items;
    boolean isAlive;

	public Player()
	{
		super("player");
        this.gold = 0;
        isAlive = true;
        this.items = new ArrayList<String>();
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
