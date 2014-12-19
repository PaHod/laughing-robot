package session01;

import java.util.Scanner;

/**
 * Created by PaHod on 28.04.2014.
 */
public class Greeting {
    public static void main(String[] args) {
        System.out.println("tell your name: ");
        Scanner scan = new Scanner(System.in);
        String    name = scan.nextLine();
        System.out.println("Здравствуйте "+name);


    }
}
