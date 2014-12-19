package hw2.hash;


import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by PaHod on 26.08.2014.
 * Написать собственную реализацию "Хэш карты".
 Карта должна хранить объекты класса "Пользователь" из первого задания.

 Реализовать методы:

 1. boolean put(int key, User elem)
 2. User get(int key)
 3. int size()
 4. boolean remove(int key)
 5. Iterator<User> iterator()


 */
public class HashTable {


    private HashTableNode first;
    private HashTableNode last;
    private int size;

    public HashTable() {
        first = null;
        last = null;
        size = 0;

    }

    boolean put(Integer key, User elem){


        if(first == null && last == null){
            size++;
            first = new HashTableNode(null, doubleHashCode(key), elem, null);
            last = first;
        } else if (first!=null && first.equals(last)){
            size++;



        }


        return false;
    }
     User get(int key){

         return null;
     }
     int size(){

         return 0;
     }
     boolean remove(int key){

         return false;
     }
     Iterator<User> iterator(){


         return null;
     }

    int doubleHashCode(int key){

        return key%size;
    }

}
