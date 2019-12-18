package parser;

import java.io.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import domain.Train;
import domain.TrainGroep;

public class LogTrainService  {
     static List<String> Logger = new ArrayList<>();
     static List<Train> trainList = new ArrayList<>();
     private static LogTrainService uniequeInstance;

    public static LogTrainService getInstance(){
        if(LogTrainService.uniequeInstance == null){
            LogTrainService.uniequeInstance = new LogTrainService();
        }
        return LogTrainService.uniequeInstance;
    }

    public void addToList(String s){
        if(!Logger.contains(s)){
        Logger.add(s);
        print();
    }
        return;
    }
    public void addObjectToList(Train train) throws IOException {
        if(trainList.contains(train)) {
            trainList.remove(train);
            trainList.add(train);
        }else {
            trainList.add(train);
        }
        System.out.println("trainlist  "+trainList);
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
            SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
            Date date = new Date(System.currentTimeMillis());
            int size = Logger.size();
            for(int i= 0 ; i < size; i++){
                output.write(formatter.format(date)+": "+Logger.get(i).toString()+"\n");
            }
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void WriteJson() throws IOException {
        System.out.println("trainlist bij write json "+ trainList);
            Gson gson = new Gson();
            JsonElement element = gson.toJsonTree(trainList, new TypeToken<List<Train>>() {}.getType());
             if (! element.isJsonArray()) {
            throw new NullPointerException();
             }
             JsonArray json = element.getAsJsonArray();
             String jsonString = "";
            File file =new File( "Trainlist.json");
            if(!file.exists()){
                file.createNewFile();
            }
        System.out.println(json);
        try{
            FileWriter  writer = new FileWriter( file,true);
            gson.toJson(json,writer);
            writer.close();
        }
        catch(Exception e  ){

            e.getMessage();

        }
        trainList.clear();
        }
    public void ReadJson(String jasonFile) throws IOException {
        Gson gsonRead = new Gson();
        InputStream in = new FileInputStream("Trainlist.json");
        BufferedReader buffer = new BufferedReader(new InputStreamReader(in));
        Train[] t = new Gson().fromJson(buffer, Train[].class);
        List<Train> asList = Arrays.asList(t);
        System.out.println("dit is json to java " + asList);
    }
}
