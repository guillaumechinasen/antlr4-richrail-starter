package domain;

public interface TrainBuilderInterface {
    void build();
    void addComponent(Component component);
    Train setTrainId(String id);
    void setTrain(Train train);
}
