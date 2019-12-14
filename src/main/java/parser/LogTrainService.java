package parser;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LogTrainService {
    private static List<String> log = new ArrayList<>();

    public void addToList(String s){
        if(!log.contains(s)){
        log.add(s);
        print();
    }
        return;
    }

    public void print(){
        System.out.println(this.log);
        WriteFile();
    }
    public void WriteFile(){
        File file = new File("test.txt");
        try {
            if(!file.exists()){
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file, true);
            Writer output = new BufferedWriter(fw);
            int size = log.size();
            for(int i= 0 ; i < size; i++){
                output.write(log.get(i).toString()+"\n");
            }
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
