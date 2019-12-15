package domain;

import parser.LogTrainService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TrainBuilder implements TrainBuilderInterface {
    private Train train;
    private List<Component> components = new ArrayList<>();
    private LogTrainService log = new LogTrainService();

    public void addComponent(Component component){
        this.components.add(component);
    }
    public Train setTrainId(String trainId){

        Train train = new Train(trainId);
        this.train = train;
        return train;
    }
    public void setTrain(Train train){
        this.train = train;
    }

    @Override
    public void build() {
        Train t = this.train;
        System.out.println("train list: "+ components);
        for(Component c: components){
            t.AddComponentToList(c);
        }
        try {
            log.addObjectToList(t);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public String toString() {
        return "TrainBuilder{" +
                "trainId='" + train.getTrainID() + '\'' +
                ", components=" + components +
                '}';
    }
}
