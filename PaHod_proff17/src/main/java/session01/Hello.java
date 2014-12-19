package session01;

import java.math.BigDecimal;
import java.util.Collections;

/**
 * Created by PaHod on 28.04.2014.
 */
public class Hello {


    public static void main(String[] args) {
        System.out.println("Hello world");
        Country ua = new Country("Ukraine", 46000000, BigDecimal.valueOf(1230000));
        Country gb = new Country("Ukraine", 46000000, BigDecimal.valueOf(1230000));
        System.out.println(ua.toString());
        System.out.println(gb.toString());
        System.out.println(ua.equals(gb));

    }


}
