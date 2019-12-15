package domain;

import parser.LogTrainService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Train implements TrainInterface {
    private String trainID;
    private final List<Component> componentsList = new ArrayList<>();

    public Train() {
    }

    public Train(final String trainId) {
        this.trainID = trainId;
    }

    public Train(final Train train) {
    }

    public String getTrainID() {
        return trainID;
    }

    public List<Component> getComponentsList() {
        return componentsList;
    }

    public void AddComponentToList(final Component comp) {
        if (!componentsList.contains(comp)) {
            componentsList.add(comp);
        }
        return;
    }

    public Component RemoveComponentFromList(final String id) {
        for (final Component c : componentsList) {
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
