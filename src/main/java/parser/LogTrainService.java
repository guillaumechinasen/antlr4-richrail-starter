package parser;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
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
        Gson gsonRead = new Gson();
        InputStream in = new FileInputStream("Trainlist.json");
        BufferedReader buffer = new BufferedReader(new InputStreamReader(in));
        Train[] t = new Gson().fromJson(buffer, Train[].class);
        List<Train> asList = Arrays.asList(t);
  /*       System.out.println("dit is de json file"+ buffer);

         ObjectMapper mapper = new ObjectMapper();
         List<Train> cars1 = mapper.readValue(buffer, new TypeReference<List<Train>>(){});

         ArrayList<Train> obj = new ArrayList<>(cars1);*/
        // System.out.println(obj);
        System.out.println("dit is json to java "+asList);

    }

}
