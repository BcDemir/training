package SlotGame;

/**
 * This is a human abstract class to create player subclasses by inheriting its properties.
 * It has a winCheer method which can be specialized for each player using polymorphism.
 */
public abstract class Human {
    private String name;
    private double money;

    public Human(String name, double money) {
        this.name = name;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public abstract void winCheer();

    public abstract void winCheer(String speech);
}
