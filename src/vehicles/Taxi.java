package vehicles;

public class Taxi extends Vehicle implements Wheels{

    public String taxiCompany;
    public String carId;
    public String driver;

    public Taxi (String manufacturer, String model, String taxiCompany, String carId, String driver){
        super(manufacturer, model);
        this.taxiCompany = taxiCompany;
        this.carId = carId;
        this.driver = driver;
    }

    @Override
    public void move() {
        System.out.println("The taxi is going");
    }

    @Override
    public void spinWheels() {

    }
}
