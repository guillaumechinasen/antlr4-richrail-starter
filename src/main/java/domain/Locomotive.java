package domain;

public class Locomotive implements Train{
    private String id;
    private String trainId;
    private String fuelType;

    public Locomotive(String id, String trainId, String fuelType ) {
        this.id = id;
        this.trainId = trainId;
        this.fuelType = fuelType;
    }

    public String getTrainId() {
        return trainId;
    }

    @Override
    public String toString() {
        return "Locomotive{" +
                "id='" + id + '\'' +
                ", trainId='" + trainId + '\'' +
                ", fuelType='" + fuelType + '\'' +
                '}';
    }


    @Override
    public void build() {
        System.out.println("Locomotive\nID:" + this.id +
                "\ntrainID:" + this.trainId +
                "\nfuel type::" + this.fuelType +
                "\nLocomotive has been made!");
    }
}