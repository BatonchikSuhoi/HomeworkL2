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

    @Override
    public boolean equals(Object obj){
        if (obj == null) return false; //Проверка сравниваемого объекта на пустоту
        if (!(obj instanceof Taxi other)) return false;
        //В случае, если объект obj является экземпляром Taxi, оператор instanceof отдает значение true, которое инвертируется на false с помощью оператора ! вначале
        //Создается переменная other которой присваивается значение obj
        if (obj == this) return true; //Если ссылки на объекты равны, то и объекты равны - возвращаем true
        boolean manufacturerEquals =    (this.getManufacturer() == null && other.getManufacturer() == null)
                                     || (this.getManufacturer() != null && this.getManufacturer().equals(other.getManufacturer()));
        //(если сравниваемый(первый) объект пуст и объект с которым сравнивают первый(второй)пуст получаем true)
        // или (первый объект не пуст и первый объект равен второму получаем true)
        boolean modelEquals =           (this.getModel() == null && other.getModel() == null)
                                     || (this.getModel() != null && this.getModel().equals(other.getModel()));
        boolean taxiCompanyEquals =     (this.taxiCompany == null && other.taxiCompany == null)
                                     || (this.taxiCompany != null && this.taxiCompany.equals(other.taxiCompany));
        boolean carIdEquals =           (this.carId == null && other.carId == null)
                                     || (this.carId != null && this.carId.equals(other.carId));
        boolean driverEquals =          (this.driver == null && other.driver == null)
                                     || (this.driver != null && this.driver.equals(other.driver));

        return manufacturerEquals && modelEquals && taxiCompanyEquals && carIdEquals && driverEquals;
    }

    @Override
    public int hashCode(){
        int result = 31;
        result = 31 * result + (getManufacturer() != null ? getManufacturer().hashCode() : 0);
        result = 31 * result + (getModel() != null ? getModel().hashCode() : 0);
        result = 31 * result + (taxiCompany != null ? taxiCompany.hashCode() : 0);
        result = 31 * result + (carId != null ? carId.hashCode() : 0);
        result = 31 * result + (driver != null ? driver.hashCode() : 0);
        return result;
    }

}
