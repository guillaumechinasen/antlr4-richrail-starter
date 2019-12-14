package parser;

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
    }
}
