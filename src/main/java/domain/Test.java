package domain;

public class Test {
     public static void main(String[] args) {
        GoodsWagon g1 = new GoodsWagon("wg2", "groenten");
        Locomotive lc1 = new Locomotive("lc1","diesel");
        ComponentFactory factory = new ComponentFactory();
        factory.setCargo("fruit");
        factory.setId("wg3");
        Component g = factory.CreateComponents("Goodswagon");

        TrainBuilderInterface trainBuilder = new TrainBuilder();
        trainBuilder.setTrainId("tr1");
        trainBuilder.addComponent(g);
      //  trainBuilder.addComponent(g1);
        //trainBuilder.addComponent(lc1);
        trainBuilder.build();
        System.out.println(trainBuilder);

    }
}
