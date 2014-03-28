package hw5;

/**
 *
 * @author baylor
 */
public class EquipableItem
{
	public String id, description;

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
