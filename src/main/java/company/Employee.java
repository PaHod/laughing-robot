package company;



/**
 * Created by PaHod on 24.12.2014.
 *  - Обычный сотрудник
 - Фамилия
 - Имя
 - Отчество
 - Пол
 - Дата рождения
 - Ставка зарплаты
 - Зарплатный счет
 - Стаж
 - Дни отпуска
 - Дата последнего отпуска
 - Отдел
 - получение размера зарплаты
 */
public class Employee {
    private int id ;
    private String name;
    private String surName;
    private int age;

    private static int nextId = 1;
    private final Integer privateFinalInteger=1;
    public static final Integer publicStaticFinalInteger = 1;
    public static Integer publicStaticInteger;
    public final Integer publicFinalInteger=1;

    public Employee(){
        this.id = nextId;
        nextId++;
    }

    public Employee(String name, String surName, int age) {
        this.id = nextId;
        nextId++;
        this.name = name;
        this.surName = surName;
        this.age=age;

    }

    private static void methodPivateStatic(int num){
        nextId++;

        System.out.println("num in methodPivateStatic " + num);


    }
    public static void methodPublicStatic(int num){
        System.out.println("num in methodPublicStatic " + num);
    }
    public  void methodPublic(int num){
        System.out.println("num in methodPublic " + num);
    }
    private final void methodPivatefinal(int num){
        System.out.println("num in methodPivatefinal " + num);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name=" + name +
                ", surName=" + surName +
                ", age=" + age +
                ", privateFinalInteger=" + privateFinalInteger +
                ", publicFinalInteger=" + publicFinalInteger +
                '}';
    }


//@Override
//    public String toString(){
//
//}


}
