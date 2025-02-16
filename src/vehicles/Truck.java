package vehicles;

public class Truck extends Vehicle implements Wheels, CarryCargo{

    public String carrierCompany;
    public String carId;
    public String driver;
    public float cargoWeight;

    public Truck(String manufacturer, String model, String carrierCompany, String carId, String driver, float cargoWeight){
        super(manufacturer, model);
        this.carrierCompany = carrierCompany;
        this.carId = carId;
        this.driver = driver;
        this.cargoWeight = cargoWeight;
    }

    @Override
    public void move() {
        System.out.println("The truck is going");
    }

    @Override
    public void carry() {

    }

    @Override
    public void spinWheels() {

    }
}
