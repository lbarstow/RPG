package hw5;

/**
 *
 * @author baylor
 */
public class EquipableItem
{
	public String id, description;
	public int damageModifier;
	public int healthModifier;

	public EquipableItem(String id, String description)
	{
		this.id = id;
		this.description = description;
	}

	@Override
	public String toString()
	{
		return description;
	}
}
