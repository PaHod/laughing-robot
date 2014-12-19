package hw2.hash;


import java.util.ArrayList;

/**
 * Created by PaHod on 26.08.2014.
 */
public class HashTableNode {
    private HashTableNode previos;
    private Integer key;
    private ArrayList<User> value;
    private HashTableNode next;


    public HashTableNode() {
    }
/*
    public HashTableNode(Integer key, User user) {
        this.key = key;
        if(value == null){ this.value = new ArrayList<>(); }

        value.add(user);
    }*/

    public HashTableNode(HashTableNode previos, Integer key,
                         User user, HashTableNode next) {
        this.previos = previos;
        this.key = key;
        if(value == null){ this.value = new ArrayList<>(); }
        this.value = value;
        this.next = next;
    }
}
