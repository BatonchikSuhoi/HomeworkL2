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

    @Override
    public boolean equals(Object obj){
        if (obj == null) return false; //Проверка сравниваемого объекта на пустоту
        if (!(obj instanceof Truck other)) return false;
        //В случае, если объект obj является экземпляром Truck, оператор instanceof отдает значение true, которое инвертируется на false с помощью оператора ! вначале
        //Создается переменная other которой присваивается значение obj
        if (obj == this) return true; //Если ссылки на объекты равны, то и объекты равны - возвращаем true
        boolean manufacturerEquals =    (this.getManufacturer() == null && other.getManufacturer() == null)
                                     || (this.getManufacturer() != null && this.getManufacturer().equals(other.getManufacturer()));
        //(если сравниваемый(первый) объект пуст и объект с которым сравнивают первый(второй)пуст получаем true)
        // или (первый объект не пуст и первый объект равен второму получаем true)
        boolean modelEquals =           (this.getModel() == null && other.getModel() == null)
                                     || (this.getModel() != null && this.getModel().equals(other.getModel()));
        boolean carrierCompanyEquals =  (this.carrierCompany == null && other.carrierCompany == null)
                                     || (this.carrierCompany != null && this.carrierCompany.equals(other.carrierCompany));
        boolean carIdEquals =           (this.carId == null && other.carId == null)
                                     || (this.carId != null && this.carId.equals(other.carId));
        boolean driverEquals =          (this.driver == null && other.driver == null)
                                     || (this.driver != null && this.driver.equals(other.driver));
        boolean cargoWeightEquals =     (Float.compare(this.cargoWeight, other.cargoWeight) == 0);
        //для float и double используется метод сравнения compare()

        return manufacturerEquals && modelEquals && carrierCompanyEquals && carIdEquals && driverEquals && cargoWeightEquals;
    }

    @Override
    public int hashCode(){
        int result = 31;
        result = 31 * result + (getManufacturer() != null ? getManufacturer().hashCode() : 0);
        result = 31 * result + (getModel() != null ? getModel().hashCode() : 0);
        result = 31 * result + (carrierCompany != null ? carrierCompany.hashCode() : 0);
        result = 31 * result + (carId != null ? carId.hashCode() : 0);
        result = 31 * result + (driver != null ? driver.hashCode() : 0);
        result = 31 * result + Float.floatToIntBits(cargoWeight);
        return result;
    }
}
