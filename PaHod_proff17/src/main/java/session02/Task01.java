package session02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by PaHod on 29.04.2014.
 * дан файл с пользователями, мосчитать кол-в пользователей в файле.
 */
public class Task01 {
    class User{
        private String name;
        private int age;

        public void User(){

        }
        public void User(String name, int age){
            this.name = name;
            this.age = age;
        }


        @Override
        public String toString() {
            return "<User>" + '\''+ "<name>" + name + "</name>" +'\'' +"<age>" + age + '\''+ "</aga>" + '\''+ "</user>";
        }

        public void setName(String name){
            this.name = name;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }

    public static void main(String[] args) {
        System.out.println(readFile("text.txt"));
      //  User us1 = new User("qwerty", 22);
        //us1.setName("qwe");
        //us1.setAge(22);
      //  System.out.println(us1.toString());
    }

    public static int readFile(final String FILE_NAME) {

        int userCount = 0;
        ArrayList<String> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String userOpen = "<user>";
            String userClose = "</user>";
            String nameOpen = "<name>";
            String nameClose = "</name>";
            String ageOpen = "<age>";
            String ageClose = "</age>";

            boolean checkUserTag = true;
            boolean checkNameTag = true;
            boolean checkAgeTag = true;

            String line;
            while ((line = reader.readLine()) != null) {
                if (line.equals(userOpen)) {
                   if(checkUserTag){
                    checkUserTag = false;




                   }else {
                       return -1;
                   }

                }
                if (line.equals(userClose)) {
                    if (!checkUserTag) {
                        userCount++;
                        checkUserTag=true;
                    }else{
                        return -1;
                    }

                }
                System.out.println(line);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return userCount;
    }
}
