package domain;

public interface TrainBuilder {
    void setId(String ID);
    void setTrainId(String trainId);
    void setFuelType(String fuelType); //optional
    void setClasstype(String classType); //optional
    void setSeats(int seats); //optional
    void setCargo(String cargo); //optional
    Train build();
}
