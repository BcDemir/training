package SlotGame;

/**
 * This is a class inherited from another class which is "Vehicle".
 * Inheritance let programmers to extend classes by inheriting their properties
 * and adding more specific properties to the subclasses.
 */
public class Car extends Vehicle{
    int numberOfWheels;

    public Car(String name, String color, String model, float speed, int numberOfWheels) {
        super(name, color, model, speed);
        this.numberOfWheels = numberOfWheels;
    }

    public Car() {
    }

    public int getNumberOfWheels() {
        return numberOfWheels;
    }

    public void setNumberOfWheels(int numberOfWheels) {
        this.numberOfWheels = numberOfWheels;
    }

    // This is polymorphism. We override the method in super class by adjusting it to make it more suitable for a car.
    // We used exact same signature with the super class to override it. This way we can create many methods
    // with same name but with different outcome or with different parameters. This is called polymorphism.
    public void go(){
        System.out.printf("This car goes %.2f km/h", speed);
    }

}
