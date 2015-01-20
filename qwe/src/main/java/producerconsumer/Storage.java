package producerconsumer;


import java.util.ArrayList;
import java.util.List;

public class Storage {

    private List<Integer> data;

    public Storage() {
        data = new ArrayList<>();
    }

    public synchronized void putData(Integer number) {
        data.add(number);
    }

    public synchronized Integer getData() {
        final Integer number = data.get(0);
        data.remove(0);
        return number;
    }

    public synchronized Integer getSize() {
        return data.size();
    }
}
