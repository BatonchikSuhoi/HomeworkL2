package vehicles;

public class Airplane extends Vehicle implements Wheels, Wings, Propeller, CarryCargo {

    public String airline;
    public String pilot;

    public Airplane(String manufacturer, String model, String airline, String pilot) {
        super(manufacturer, model);
        this.airline = airline;
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

    @Override
    public boolean equals(Object obj){
        if (obj == null) return false; //Проверка сравниваемого объекта на пустоту
        if (!(obj instanceof Airplane other)) return false;
        //В случае, если объект obj является экземпляром Airplane, оператор instanceof отдает значение true, которое инвертируется на false с помощью оператора ! вначале
        //Создается переменная other которой присваивается значение obj
        if (obj == this) return true; //Если ссылки на объекты равны, то и объекты равны - возвращаем true
        boolean manufacturerEquals =    (this.getManufacturer() == null && other.getManufacturer() == null)
                                     || (this.getManufacturer() != null && this.getManufacturer().equals(other.getManufacturer()));
        //(если сравниваемый(первый) объект пуст и объект с которым сравнивают первый(второй)пуст получаем true)
        // или (первый объект не пуст и первый объект равен второму получаем true)
        boolean modelEquals =           (this.getModel() == null && other.getModel() == null)
                                     || (this.getModel() != null && this.getModel().equals(other.getModel()));
        boolean airlineEquals =         (this.airline == null && other.airline == null)
                                     || (this.airline != null && this.airline.equals(other.airline));
        boolean pilotEquals =           (this.pilot == null && other.pilot == null)
                                     || (this.pilot != null && this.pilot.equals(other.pilot));

        return manufacturerEquals && modelEquals && airlineEquals && pilotEquals;
    }

    @Override
    public int hashCode(){
        int result = 31;
        result = 31 * result + (getManufacturer() != null ? getManufacturer().hashCode() : 0);
        result = 31 * result + (getModel() != null ? getModel().hashCode() : 0);
        result = 31 * result + (airline != null ? airline.hashCode() : 0);
        result = 31 * result + (pilot != null ? pilot.hashCode() : 0);
        return result;
        /*        int manufacturerHash = getManufacturer() != null ? getManufacturer().hashCode() : 0;
        int modelHash = getModel() != null ? getModel().hashCode() : 0;
        int airlineHash = airline != null ? airline.hashCode() : 0;
        int pilotHash = pilot != null ? pilot.hashCode() : 0;
        int result = manufacturerHash;
        result = 31 * result + modelHash;
        result = 31 * result + airlineHash;
        result = 31 * result + pilotHash;
        return result;*/
    }

}
