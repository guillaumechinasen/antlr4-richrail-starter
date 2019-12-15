package parser;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import domain.Train;
import domain.TrainGroep;

public class LogTrainService  {
    private static List<String> log = new ArrayList<>();
    private List<Train> trainList = new ArrayList<>();


    public void addToList(String s){
        if(!log.contains(s)){
        log.add(s);
        print();
    }
        return;
    }

    public void setTrainList(List<Train> trainList) {
        this.trainList = trainList;
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

    public void WriteJson() throws IOException {
            Gson gson = new Gson();
            String jsonString = "";
            File file =new File( "Trainlist.json");
            if(!file.exists()){
                file.createNewFile();
            }
            if (!trainList.isEmpty()) {
                for (Train train : trainList) {
                    System.out.println("train obj "+ train);
                    jsonString += gson.toJson(train);
                }
            }

            try {
              BufferedWriter  writer = new BufferedWriter(new FileWriter(file));
                writer.write(jsonString);
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
}
