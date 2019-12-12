package domain;

public class TrainBuilder implements TrainBuilderInterface{
    private String trainid;
    private Locomotive locomotive;
    private GoodsWagon goodsWagon;
    private PersonWagon personWagon;

    @Override
    public void setTrainId(String trainId) {
        this.trainid = trainId;
        TrainPojo t = new TrainPojo(trainId);
        System.out.println(t);
    }

    @Override
    public void addLocomotiveToTrain(String id) {
        locomotive.getId();
    }

    @Override
    public void addGoodsWagonToTrain(String id) {
        goodsWagon.getId();
    }

    @Override
    public void addPersonalWagonToTrain(String id) {
        personWagon.getId();
    }

    @Override
    public void removeLocomotiveToTrain(String id) {
        /*if (this.personWagon.getId() == locomotive.getId()) {
            train
        }*/
    }

    @Override
    public void removeGoodsWagonToTrain(String id) {

    }

    @Override
    public void removePersonalWagonToTrain(String id) {

    }

    @Override
    public Train build() {
        return new TrainPojo(trainid);
    }

    /*@Override
    public String toString() {
        return "TrainBuilder{" +
                "trainid='" + trainid + '\'' +
                ", locomotive=" + locomotive +
                ", goodsWagon=" + goodsWagon +
                ", personWagon=" + personWagon +
                '}';
    }*/
}
