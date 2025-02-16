package vehicles;

public class Boat extends Vehicle implements Propeller, CarryCargo{

    public String name;
    public String captain;

    public Boat(String manufacturer, String model, String name, String captain){
        super(manufacturer, model);
        this.name = name;
        this.captain = captain;
    }

    @Override
    public void move() {
        System.out.println("The Boat is floating");
    }

    @Override
    public void spinPropeller() {

    }

    @Override
    public void carry() {

    }
}
