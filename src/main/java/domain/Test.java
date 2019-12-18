package domain;

import parser.LogTrainService;

import java.io.IOException;

public class Test {
     public static void main(String[] args) {
        LogTrainService logTrainService = new LogTrainService();
        try {
           logTrainService.ReadJson("Trainlist.json");
        } catch (IOException e) {
           e.printStackTrace();
        }

     }
}
