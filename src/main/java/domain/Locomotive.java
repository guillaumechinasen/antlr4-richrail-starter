package domain;

public class Locomotive implements Train{
    private int id;
    private String fuelType;

    public Locomotive(int id, String fuelType ) {
        this.id = id;
        this.fuelType = fuelType;
    }

    @Override
    public void build() {
        System.out.println("Locomotive\nID:" + this.id +
                "\nfuel type::" + this.fuelType +
                "\nLocomotive has been made!");
    }
}