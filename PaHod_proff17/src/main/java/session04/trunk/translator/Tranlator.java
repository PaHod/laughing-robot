package session04.translator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by PaHod on 13.05.2014.
 */
public class Tranlator {
    private Map<String, String> dictionary;

    public Tranlator(){
        this.dictionary = new HashMap<>();
        dictionary.put("bag", "чумадан");
        dictionary.put("spring", "весна");
        dictionary.put("qwerty", "йцукен");
        dictionary.put("summer", "лето");
        dictionary.put("go", "идти");
        dictionary.put("stop", "стоп");
        dictionary.put("left", "лево");
        dictionary.put("right", "право");
        dictionary.put("top", "верх");
        dictionary.put("bottom", "низ");

    }

    public static void main(String[] args) throws IOException {


        reader();



    }

    public static ArrayList<String[]> reader() throws IOException {
        ArrayList<String[]> res = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader("ses04TextO.txt"));
        String line;
        while ((line = br.readLine())!=null){
            res.add(line.split(" "));
        }


        return res;
    }
    /*public ArrayList<String[]> translator(ArrayList<String[]> text){


    }
*/
    public void writer(ArrayList<String[]> text){

    }
}
