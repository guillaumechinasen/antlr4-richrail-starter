package parser;

import java.io.*;
import java.lang.reflect.Type;
<<<<<<< Updated upstream
import java.util.ArrayList;
import java.util.Collection;
=======
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
>>>>>>> Stashed changes
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import domain.Component;
import domain.Train;
import com.fasterxml.jackson.core.JsonParser;

public class LogTrainService  {
     static List<String> Logger = new ArrayList<>();
     static List<Train> trainList = new ArrayList<>();


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
<<<<<<< Updated upstream
            int size = Logger.size();
            for(int i= 0 ; i < size; i++){
                output.write(Logger.get(i).toString()+"\n");
=======
            SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
            Date date = new Date(System.currentTimeMillis());
            int size = Logger.size();
            for(int i= 0 ; i < size; i++){
                output.write(formatter.format(date)+": "+Logger.get(i).toString()+"\n");
>>>>>>> Stashed changes
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

        }
    public void ReadJson(String jasonFile) throws IOException {
   /*    GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setLenient();*/
        Gson gsonRead = new Gson();
       InputStream in = new FileInputStream(jasonFile);
        BufferedReader buffer = new BufferedReader(new InputStreamReader(in));

        System.out.println("dit is de json file"+ buffer);

        ObjectMapper mapper = new ObjectMapper();
        List<Train> cars1 = mapper.readValue(buffer, new TypeReference<List<Train>>(){});

     /*   Type collectionType = new TypeToken<Collection<Train>>(){}.getType();
        Collection<Train> enums = gsonRead.fromJson(buffer, collectionType);*/
        ArrayList<Train> obj = new ArrayList<>(cars1);
        System.out.println(obj);
        System.out.println("dit is json to java "+obj);
    }

}
