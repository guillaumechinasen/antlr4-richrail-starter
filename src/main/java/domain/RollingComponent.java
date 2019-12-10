package domain;

public class RollingComponent implements Train{
    private String id;
    private String trainId;
    private String fuelType;
    private String cargo;
    private String classType;
    private int seats;

    public RollingComponent(String id, String trainId, String fuelType, String cargo, String classType, int seats) {
        this.id = id;
        this.trainId = trainId;
        this.fuelType = fuelType;
        this.cargo = cargo;
        this.classType = classType;
        this.seats = seats;
    }

    public String getTrainId() {
        return trainId;
    }

    @Override
    public String toString() {
        return "RollingComponent{" +
                "id='" + id + '\'' +
                ", trainId='" + trainId + '\'' +
                ", fuelType='" + fuelType + '\'' +
                ", cargo='" + cargo + '\'' +
                ", classType='" + classType + '\'' +
                ", seats=" + seats +
                '}';
    }

    @Override
    public void build() {
        System.out.println("ID:" + this.id +
                "\ntrainID:" + this.trainId +
                "\nfuel type::" + this.fuelType +
                "\nClasstype:" + this.cargo +
                ", classType='" + classType + '\'' +
                ", seats=" + seats +
                "\nRollingcomponent has been made!");
    }
}
