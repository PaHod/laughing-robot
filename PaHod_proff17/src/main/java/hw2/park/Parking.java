package hw2.park;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by PaHod on 19.05.2014.
 Написать класс представляющий парковку. С методами:
 - int park(Car cat) - поместить машину на парковку, возвращает номер паркоместа
 - Car leave(int placeNumber) - удалить машину с парковки по номеру парокместа, возвращает удаляемую машину
 Методы выбрасывают ислключения IndexOutOfBoundsException и ParkFullException

 Класс задания hw2.park.Parking
 */
public class Parking {

    private Map<Integer, Car> parking;
    private int parkingSize;

    public Parking(){
        parking=new HashMap<>();

    }    public Parking(int parkingSize){

    this.parkingSize=parkingSize;
    parking=new HashMap<>();
    for (int i=1; i<=parkingSize; i++){
        parking.put(i, null);
        }

    }
    public int park(Car car){
        int placeNumber;

    //    parking.put();placeNumber

    return 1;
    }


    public Car leave(int placeNumber){
    return new Car();
    }

    public void getParking() {
       // return parking;
    }

    public  void setParking(Map<Integer, Car> parking) {
        parking = parking;
    }

    public int getParkingSize() {
        return parkingSize;
    }

    public void setParkingSize(int parkingSize) {
        this.parkingSize = parkingSize;
    }
}
