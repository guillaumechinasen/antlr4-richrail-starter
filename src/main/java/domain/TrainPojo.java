package domain;

public class TrainPojo implements Train{
    private String trainID;

    public TrainPojo(String trainID) {
        this.trainID = trainID;
    }

    @Override
    public String toString() {
        return "TrainPojo{" +
                "trainID='" + trainID + '\'' +
                '}';
    }

    @Override
    public void build() {
        //System.out.println("Locomotive\nID:" + this.trainID +
                //"\nLocomotive has been made!");
    }
}
