package session01;

import java.math.BigDecimal;

/**
 * Created by PaHod on 28.04.2014.
 * данн класс страна, поля:
 * - название
 * - кол-во населения
 * - бюджет
 * переопределить метод equals
 */
public class Country {

    private String name;
    private Integer population;
    private BigDecimal money;




    public Country() {


    }

    public Country(String inName, Integer inPopulation, BigDecimal inMoney) {

        name = inName;
        population = inPopulation;
        money = inMoney;

    }

    @Override
    public String toString() {
         return "Name - "+name+", population - "+ population +", money - "+ money;
    }

    @Override
    public boolean equals(Object obj) {
        boolean res = false;
        if (obj != null && getClass() == obj.getClass()) {
           Country country=(Country) obj;
            if (name.equals(country.name) && population.equals(country.population) && money.equals(country.money)) {
                res = true;
            }
        }
        return res;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public Integer getPopulation() {
        return population;
    }

    public String getName() {
        return name;
    }

}
