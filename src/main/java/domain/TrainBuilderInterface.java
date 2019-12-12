package domain;

public interface TrainBuilderInterface {
    void setTrainId(String trainId);
    void addLocomotiveToTrain(String id);
    void addGoodsWagonToTrain(String id);
    void addPersonalWagonToTrain(String id);
    void removeLocomotiveToTrain(String id);
    void removeGoodsWagonToTrain(String id);
    void removePersonalWagonToTrain(String id);
    Train build();
}
