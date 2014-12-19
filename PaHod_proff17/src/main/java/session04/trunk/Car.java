package session04;


import java.util.Date;

/**
 * Created by PaHod on 13.05.2014.
 *
 * создать класс машина, модель, дата угона, имя хозяина
 * написать метод для поиска машины по базе
 *
 *
 */
public class Car {
    private String model;
    private String ovnerName;
    private Date theftDate;


    public Car() {
    }



    public  Car(String model, String ovnerName, int year, int month, int day ){
        this.model = model;
        this.ovnerName = ovnerName;
        this.theftDate = new Date(year, month, day);

    }
    @Override
    public int hashCode() {
        // TODO implement
        int res = model.hashCode() + ovnerName.hashCode() + theftDate.hashCode();

        return res;
    }

    @Override
    public boolean equals(Object o) {
        // TODO implements
        if(o!=null && o.getClass()==this.getClass()){
            Car secCar = (Car)o;
        if(this.model.equals(secCar.getModel()) && this.ovnerName.equals(secCar.getOvnerName())){
        return false;
        }
        }
            return true;
    }



    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", ovnerName='" + ovnerName + '\'' +
                ", theftDate=" + theftDate +
                '}';
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getOvnerName() {
        return ovnerName;
    }

    public void setOvnerName(String ovnerName) {
        this.ovnerName = ovnerName;
    }

    public Date getTheftDate() {
        return theftDate;
    }

    public void setTheftDate(Date theftDate) {
        this.theftDate = theftDate;
    }
}
