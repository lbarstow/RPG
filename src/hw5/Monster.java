package hw5;

/**
 * Created by Laura on 3/26/14.
 */
public class Monster {
    public String mName; //monster's name
    public int attackForce; //how much damage they cause to player
    public int endurance; //how much damage / how many attacks it takes to kill them
    public String imageName;

    public Monster(String mName, int attackForce, int endurance, String imageName){
        this.mName = mName;
        this.attackForce = attackForce;
        this.endurance = endurance;
        this.imageName = imageName;
    }

    @Override
    public String toString(){
        return mName;
    }


}