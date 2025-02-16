package vehicles;

public class Tanker extends Vehicle implements Propeller, CarryCargo{

    public String name;
    public String captain;
    public float oilWeight;

    public Tanker(String manufacturer, String model, String name, String captain, float oilWeight){
        super(manufacturer, model);
        this.name = name;
        this.captain = captain;
        this.oilWeight = oilWeight;
    }

    @Override
    public void move() {
        System.out.println("The tanker is floating");
    }

    @Override
    public void carry() {

    }

    @Override
    public void spinPropeller() {

    }
}
