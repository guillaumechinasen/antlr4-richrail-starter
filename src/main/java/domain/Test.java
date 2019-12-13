package domain;

public class Test {
     public static void main(String[] args) {
        GoodsWagon g = new GoodsWagon("wg1","fruit");
        GoodsWagon g1 = new GoodsWagon("wg2", "groenten");
        Locomotive lc1 = new Locomotive("lc1","diesel");
        TrainBuilderInterface trainBuilder = new TrainBuilder();
        trainBuilder.setTrainId("tr1");
        trainBuilder.addComponent(g);
        trainBuilder.addComponent(g1);
        trainBuilder.addComponent(lc1);
        trainBuilder.build();
        System.out.println(trainBuilder);

    }
}
