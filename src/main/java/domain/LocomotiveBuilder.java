package domain;

public class LocomotiveBuilder implements LocomotiveBuilderInterface{
    private int id;
    private String fuelType;


    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    @Override
    public Train build() {
        return new Locomotive(id, fuelType);
    }
}
