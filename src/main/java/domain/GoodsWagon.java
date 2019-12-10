package domain;

public class GoodsWagon implements Train{
    private String id;
    private String trainId;
    private String cargo;

    public GoodsWagon(String id, String trainId, String cargo) {
        this.id = id;
        this.trainId = trainId;
        this.cargo = cargo;
    }

    public String getTrainId() {
        return trainId;
    }

    @Override
    public String toString() {
        return "GoodsWagon{" +
                "id='" + id + '\'' +
                ", trainId='" + trainId + '\'' +
                ", cargo='" + cargo + '\'' +
                '}';
    }

    @Override
    public void build() {
        System.out.println("Goodswagon\nID:" + this.id +
                "\ntrainID:" + this.trainId +
                "\nClasstype:" + this.cargo +
                "\nGoodsWagon has been made!");
    }
}
