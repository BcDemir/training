package SlotGame;

public class Vehicle {
    String name;
    String color;
    String model;
    float speed;

    public Vehicle(String name, String color, String model, float speed) {
        this.name = name;
        this.color = color;
        this.model = model;
        this.speed = speed;
    }


    public Vehicle() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public void go(){
        System.out.printf("The %s goes with %.2f speed.", this.name, this.speed);
    }
}
