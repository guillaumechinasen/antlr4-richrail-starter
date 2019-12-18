package domain;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import parser.LogTrainService;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Test {
     public static void main(String[] args) throws IOException {
        LogTrainService logTrainService = new LogTrainService();
         Gson gsonRead = new Gson();
         InputStream in = new FileInputStream("Trainlist.json");
         BufferedReader buffer = new BufferedReader(new InputStreamReader(in));

         System.out.println("dit is de json file"+ buffer);

         ObjectMapper mapper = new ObjectMapper();
         List<Train> cars1 = mapper.readValue(buffer, new TypeReference<List<Train>>(){});

         ArrayList<Train> obj = new ArrayList<>(cars1);
         System.out.println(obj);
         System.out.println("dit is json to java "+obj);

     }
}
