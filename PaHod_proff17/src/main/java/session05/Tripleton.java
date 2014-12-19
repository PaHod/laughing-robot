package session05;

/**
 * Created by PaHod on 19.05.2014.
 */
public class Tripleton {
    private static Tripleton instance;
    private static int count=0;
    private int value;

    private Tripleton(int value){
        this.value=value;
    }

    public static synchronized Tripleton getInstance() {
        if (count++ <3){
            instance = new Tripleton(count);

        }

        return instance;
    }

    public int getValue() {
        return value;
    }

    public static void main(String[] args) {
        Tripleton t1= Tripleton.getInstance();
        Tripleton t2= Tripleton.getInstance();
        Tripleton t3= Tripleton.getInstance();

        System.out.println(t1.getValue());
        System.out.println(t2.getValue());
        System.out.println(t3.getValue());

        System.out.println(Tripleton.getInstance().getValue());
        System.out.println(Tripleton.getInstance().getValue());
        System.out.println(Tripleton.getInstance().getValue());

        System.out.println(t2.getValue());
    }
}
