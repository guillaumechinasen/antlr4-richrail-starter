package domain;

public class PersonWagonBuilder implements TrainBuilder{
    private String id;
    private String trainId;
    private String classType;
    private int seats;

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public void setTrainId(String trainId) {
        this.trainId = trainId;
    }

    @Override
    public void setFuelType(String fuelType) {

    }

    @Override
    public void setClasstype(String classtype) {
        this.classType = classtype;
    }

    @Override
    public void setSeats(int seats) {
        this.seats = seats;
    }

    @Override
    public void setCargo(String cargo) {

    }

    @Override
    public Train build() {
        return new PersonWagon(id, trainId, classType, seats);
    }
}