package domain;

public class LocomotiveBuilder implements TrainBuilder{
    private String id;
    private String trainId;
    private String fuelType;


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
        this.fuelType = fuelType;
    }

    @Override
    public void setClasstype(String classtype) {

    }

    @Override
    public void setSeats(int seats) {

    }

    @Override
    public void setCargo(String cargo) {

    }


    @Override
    public Train build() {
        return new Locomotive(id, trainId, fuelType);
    }
}
