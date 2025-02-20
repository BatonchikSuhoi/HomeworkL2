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

    @Override
    public boolean equals(Object obj){
        if (obj == null) return false; //Проверка сравниваемого объекта на пустоту
        if (!(obj instanceof Helicopter other)) return false;
        //В случае, если объект obj является экземпляром Helicopter, оператор instanceof отдает значение true, которое инвертируется на false с помощью оператора ! вначале
        //Создается переменная other которой присваивается значение obj
        if (obj == this) return true; //Если ссылки на объекты равны, то и объекты равны - возвращаем true
        boolean manufacturerEquals =    (this.getManufacturer() == null && other.getManufacturer() == null)
                                     || (this.getManufacturer() != null && this.getManufacturer().equals(other.getManufacturer()));
        //(если сравниваемый(первый) объект пуст и объект с которым сравнивают первый(второй)пуст получаем true)
        // или (первый объект не пуст и первый объект равен второму получаем true)
        boolean modelEquals =           (this.getModel() == null && other.getModel() == null)
                                     || (this.getModel() != null && this.getModel().equals(other.getModel()));
        boolean nameEquals =            (this.name == null && other.name == null)
                                     || (this.name != null && this.name.equals(other.name));
        boolean pilotEquals =           (this.pilot == null && other.pilot == null)
                                     || (this.pilot != null && this.pilot.equals(other.pilot));

        return manufacturerEquals && modelEquals && nameEquals && pilotEquals;
    }

    @Override
    public int hashCode(){
        int result = 31;
        result = 31 * result + (getManufacturer() != null ? getManufacturer().hashCode() : 0);
        result = 31 * result + (getModel() != null ? getModel().hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (pilot != null ? pilot.hashCode() : 0);
        return result;
    }

}
