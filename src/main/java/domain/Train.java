package domain;

import java.util.ArrayList;
import java.util.List;

public class Train implements TrainInterface {
    private String trainID;
    private List<Component> componentsList = new ArrayList<>();

   

    public Train() {
    }

    public Train(String trainId) {
        this.trainID = trainId;
    }

    public Train(Train train) {
    }


    public void AddComponentToList(Component comp) {
        if (!componentsList.contains(comp)) {
            componentsList.add(comp);
        }
    }

    @Override
    public String toString() {
        return "Train{" +
                "trainID='" + trainID + '\'' +
                '}';
    }

}
