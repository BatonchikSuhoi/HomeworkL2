package vehicles;

public class Helicopter extends Vehicle implements Wheels, Propeller, CarryCargo{

    public String name;
    public String pilot;

    public Helicopter(String manufacturer, String model, String name, String pilot){
        super(manufacturer, model);
        this.name = name;
        this.pilot = pilot;
    }

    @Override
    public void move() {
        System.out.println("The helicopter is flying");
    }

    @Override
    public void spinWheels() {

    }

    @Override
    public void carry() {

    }

    @Override
    public void spinPropeller() {

    }
}
