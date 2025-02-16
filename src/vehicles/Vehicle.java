package vehicles;

abstract class Vehicle {

    private final String manufacturer;
    private final String model;

    public Vehicle(String manufacturer, String model) {
        this.manufacturer = manufacturer;
        this.model = model;
    }

    public String getManufacturer() {return manufacturer;}
    public String getModel() {return model;}

    public abstract void move();

}
