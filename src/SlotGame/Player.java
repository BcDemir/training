package SlotGame;

/**
 * Player class inherited from Human class. Inheritance is a method that let programmers extend
 * classes by inheriting their properties and adding more specific properties to the subclasses.
 */
public class Player extends Human implements PlayerCheer{
    private int playCounter;

    public Player(String name, double money) {
        super(name, money);
    }

    public int getPlayCounter() {
        return playCounter;
    }

    public void setPlayCounter(int playCounter) {
        this.playCounter = playCounter;
    }

    @Override
    public void winCheer() {
        System.out.println("Well Played yeah!");
    }

    @Override
    public void winCheer(String speech) {
        System.out.println(this.getName() + " says: " + speech);
    }

    @Override
    public void happyCheer() {
        System.out.println("Win Win Win!");
    }

    @Override
    public void angryCheer() {
        System.out.println("Please Noo");
    }
}
