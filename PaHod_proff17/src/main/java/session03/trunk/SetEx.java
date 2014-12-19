package session03;

import javax.swing.text.html.HTMLDocument;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by PaHod on 12.05.2014.
 даны 5 уникальных чисел удалить четные

 */
public class SetEx {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(3);
        set.add(2);
        set.add(4);
        set.add(5);



        Iterator<Integer> ist = set.iterator();
        while (ist.hasNext()){
            Integer curr = ist.next();
            System.out.println(curr+" ");
            if(curr % 2 == 0){
                ist.remove();

            }
            }
        System.out.println("----------------");
        for(Integer el : set   ){
            System.out.println(el + " ");
        }

    }


}
