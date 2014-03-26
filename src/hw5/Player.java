package hw5;

/**
 *
 * @author baylor
 */
public class Player
	extends Agent
{
    int gold;
    int strength;

	public Player()
	{
		super("player");
        this.gold = 0;
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
