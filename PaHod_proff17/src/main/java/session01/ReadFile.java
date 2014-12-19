package session01;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by PaHod on 28.04.2014.
 * дан текстовый файл, построчно вывести содежимое файла в обратном порядке
 */
public class ReadFile {
    public static void main(String[] args) throws IOException{
       File file = new File("qwe.txt");
        FileReader fileRead = new FileReader(file);
        BufferedReader bufRead = new BufferedReader(fileRead);

        StringBuilder strBuild =new StringBuilder();

     while(bufRead.readLine() != null){
    //     StringBuilder str =  strBuild.append(bufRead.readLine());


     }
     //   System.out.println(str);



    }

}
