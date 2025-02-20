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

    @Override
    public boolean equals(Object obj){
        if (obj == null) return false; //Проверка сравниваемого объекта на пустоту
        if (!(obj instanceof Tanker other)) return false;
        //В случае, если объект obj является экземпляром Tanker, оператор instanceof отдает значение true, которое инвертируется на false с помощью оператора ! вначале
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
        boolean captainEquals =         (this.captain == null && other.captain == null)
                                     || (this.captain != null && this.captain.equals(other.captain));
        boolean oilWeightEquals =       (Float.compare(this.oilWeight, other.oilWeight) == 0);
        //для float и double используется метод сравнения compare()

        return manufacturerEquals && modelEquals && nameEquals && captainEquals && oilWeightEquals;
    }

    @Override
    public int hashCode(){
        int result = 31;
        result = 31 * result + (getManufacturer() != null ? getManufacturer().hashCode() : 0);
        result = 31 * result + (getModel() != null ? getModel().hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (captain != null ? captain.hashCode() : 0);
        result = 31 * result + Float.floatToIntBits(oilWeight);
        return result;
    }
}
