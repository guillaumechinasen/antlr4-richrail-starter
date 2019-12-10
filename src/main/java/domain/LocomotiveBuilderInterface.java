package domain;

public interface LocomotiveBuilderInterface {
    void setId(int id);
    void setFuelType (String fuelType);
    Train build();
}
