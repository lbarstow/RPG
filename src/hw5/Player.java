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
    int strength;
    ArrayList<String> items;

	public Player()
	{
		super("player");
        this.gold = 0;
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
