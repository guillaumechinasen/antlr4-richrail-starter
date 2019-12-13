package domain;

import java.util.ArrayList;
import java.util.List;

public class TrainBuilder implements TrainBuilderInterface {
    private String trainId;
    private List<Component> components = new ArrayList<>();

    public void addComponent(Component component){
        System.out.println(component);
        this.components.add(component);
    }
    public void setTrainId(String trainId){
        this.trainId = trainId;
    }

    @Override
    public void build() {
        System.out.println(this.trainId);
        Train t = new Train(this.trainId);
        System.out.println(t);
        for(Component c: components){
            t.AddComponentToList(c);
        }

    }

    @Override
    public String toString() {
        return "TrainBuilder{" +
                "trainId='" + trainId + '\'' +
                ", components=" + components +
                '}';
    }
}
