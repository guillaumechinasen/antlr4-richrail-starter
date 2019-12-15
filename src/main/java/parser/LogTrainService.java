package parser;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import domain.Component;
import domain.Train;

public class LogTrainService  {
    private static List<String> Logger = new ArrayList<>();
    private List<Train> trainList = new ArrayList<>();

    public void addToList(String s){
        if(!Logger.contains(s)){
        Logger.add(s);
        print();
    }
        return;
    }
    public void addObjectToList(Train train) throws IOException {
    /*    /if(!trainList.contains(train)){
            trainList.add(train);
            WriteJson();
        */
        trainList.add(train);
        WriteJson();
        return;
    }




   public void print(){
        System.out.println(this.Logger);
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
            int size = Logger.size();
            for(int i= 0 ; i < size; i++){
                output.write(Logger.get(i).toString()+"\n");
            }
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void WriteJson() throws IOException {
            Gson gson = new Gson();
            String jsonString = "";
            File file =new File( "Trainlist.json");


                for (Train train : trainList) {
                    System.out.println("train obj "+ train);
                    jsonString += gson.toJson(train);
                    System.out.println("het komt hier"+jsonString);

            }

            try {
              BufferedWriter  writer = new BufferedWriter(new FileWriter(file));
                writer.write(jsonString);
                System.out.println("dit ook "+jsonString);
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }

}
