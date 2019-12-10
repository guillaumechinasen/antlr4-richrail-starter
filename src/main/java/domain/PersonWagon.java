package domain;

public class PersonWagon implements Train{
    private String id;
    private String trainId;
    private String classType;
    private int seats;

    public PersonWagon(String id, String TrainId, String classType, int seats) {
        this.id = id;
        this.trainId = TrainId;
        this.classType = classType;
        this.seats = seats;
    }

    public String getTrainId() {
        return trainId;
    }

    @Override
    public String toString() {
        return "PersonWagon{" +
                "id='" + id + '\'' +
                ", trainId='" + trainId + '\'' +
                ", classType='" + classType + '\'' +
                ", seats=" + seats +
                '}';
    }

    @Override
    public void build() {
        System.out.println("Personwagon\nNaam:" + this.id +
                            "\ntrainID:" + this.trainId +
                            "\nClasstype:" + this.classType +
                            "\nSeats:" + this.seats +
                            "\nPersonWagon has been made!");
    }
}
