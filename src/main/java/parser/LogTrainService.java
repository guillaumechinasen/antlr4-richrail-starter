package parser;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
<<<<<<< Updated upstream
<<<<<<< Updated upstream
=======
=======
>>>>>>> Stashed changes
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
<<<<<<< Updated upstream
>>>>>>> Stashed changes
=======
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
<<<<<<< Updated upstream
        WriteJson();
=======
>>>>>>> Stashed changes
=======
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
<<<<<<< Updated upstream

                for (Train train : trainList) {
                    System.out.println("train obj "+ train);
                    jsonString += gson.toJson(train);
                    System.out.println("het komt hier"+jsonString);

            }

            try {
                FileWriter writer =  new FileWriter(file,true);
                writer.write(jsonString);
                System.out.println("dit ook "+jsonString);
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
=======
        System.out.println(json);
        try{
            FileWriter  writer = new FileWriter( file,true);
            gson.toJson(json,writer);
            writer.close();
        }
        catch(Exception e  ){

            e.getMessage();
>>>>>>> Stashed changes
=======
        System.out.println(json);
        try{
            FileWriter  writer = new FileWriter( file,true);
            gson.toJson(json,writer);
            writer.close();
        }
        catch(Exception e  ){

            e.getMessage();
>>>>>>> Stashed changes

        }

        }
<<<<<<< Updated upstream
<<<<<<< Updated upstream
=======
=======
>>>>>>> Stashed changes
    public void ReadJson(String jasonFile) throws IOException {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setLenient();
        Gson gsonRead = new Gson();
        InputStream in = new FileInputStream(jasonFile);
        BufferedReader buffer = new BufferedReader(new InputStreamReader(in));
        Train out = gsonRead.fromJson(buffer, Train.class);


        System.out.println("dit is json to java "+out.toString());
    }
<<<<<<< Updated upstream
>>>>>>> Stashed changes
=======
>>>>>>> Stashed changes

}
