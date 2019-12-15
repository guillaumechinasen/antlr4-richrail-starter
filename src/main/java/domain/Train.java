package domain;

import parser.LogTrainService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Train implements TrainInterface {
    private String trainID;
    private  List<Component> componentsList =new ArrayList<>();




    public Train() {
    }

    public Train(String trainId) {
        this.trainID = trainId;
    }

    public Train(Train train) {
    }

    public String getTrainID() {
        return trainID;
    }

    public  List<Component> getComponentsList() {
        return componentsList;
    }

    public void AddComponentToList(Component comp) {
        if (!componentsList.contains(comp)) {
            componentsList.add(comp);

        }
        return;
    }
    public Component RemoveComponentFromList(String id){
       for(Component c : componentsList){
           if(c.getId().equals(id)){
               componentsList.remove(c);

               return c;
           }
       }
       return null;
    }


    @Override
    public String toString() {
        return "Train{" +
                "trainID='" + trainID + '\'' +
                ", componentsList=" + componentsList +
                '}';
    }
}
