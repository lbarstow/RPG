package hw5;

/**
 * Created by Laura on 3/26/14.
 */
public class Helper {
    public String description; //name
    public int fee; //what it takes to get gift from the creature
    public int boost; //how much it helps player

    public Helper(String description, int fee, int boost){
        this.description = description;
        this.fee = fee;
        this.boost = boost;
    }

    @Override
    public String toString(){
        return description;
    }
}
