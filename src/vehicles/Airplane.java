package vehicles;

public class Airplane extends Vehicle implements Wheels, Wings, Propeller, CarryCargo {

    public String airline;
    public String pilot;

    public Airplane(String manufacturer, String model, String ownerName, String pilot) {
        super(manufacturer, model);
        this.airline = ownerName;
        this.pilot = pilot;
    }

    @Override
    public void move() {
        System.out.println("The airplane is flying");
    }

    @Override
    public void spinWheels() {
        System.out.println("The floating");
    }

    @Override
    public void moveFlaps() {

    }

    @Override
    public void spinPropeller() {

    }

    @Override
    public void carry() {

    }
}
