package company;

/**
 * Created by PaHod on 24.12.2014.
 *
 Продавец (продажи, зп + 30% от продаж)
 */
public class Seller extends Employee {

    private double selles;
    private double selleBonus;


    public Seller(){
        super();
        selles= 0;
        selleBonus=0;

    }

    public Seller(String name, String surName, int age) {
        super(name, surName, age);
        selles= 0;
selleBonus=0;
    }

    public double getSelles() {
        return selles;
    }

    public void setSelles(double selles) {
        this.selles = selles;
    }

    public double getSelleBonus() {


        return selleBonus;
    }
}
