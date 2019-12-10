package domain;//Deze java klasse wordt gebruikt om alleen de domein klassen te testen.

import domain.*;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        //Builder test
        TrainBuilder PersonBuilder = new PersonWagonBuilder();
        TrainBuilder GoodBuilder = new GoodWagonBuilder();
        TrainBuilder LocoBuilder = new LocomotiveBuilder();

        PersonBuilder.setId("pw1");
        PersonBuilder.setTrainId("tr1");
        PersonBuilder.setClasstype("Klasse 2");
        PersonBuilder.setSeats(20);
        PersonWagon personWagon = (PersonWagon) PersonBuilder.build();

        GoodBuilder.setId("wg1");
        GoodBuilder.setTrainId("tr1");
        GoodBuilder.setCargo("Diesel");
        GoodsWagon goodsWagon = (GoodsWagon) GoodBuilder.build();

        LocoBuilder.setId("lo1");
        LocoBuilder.setTrainId("tr1");
        LocoBuilder.setFuelType("Kolen");
        Locomotive locomotive = (Locomotive) LocoBuilder.build();

        LocoBuilder.setId("lo2");
        LocoBuilder.setTrainId("tr1");
        LocoBuilder.setFuelType("Benzine");
        Locomotive locomotive2 = (Locomotive) LocoBuilder.build();

        personWagon.build();
        System.out.println("\n");
        goodsWagon.build();
        System.out.println("\n");
        locomotive.build();
        System.out.println("\n");
        locomotive2.build();

        System.out.println("\n");

        //iterator test
        LocomotiveGroup lgroup = new LocomotiveGroup();
        lgroup.addLocomotief(locomotive);
        lgroup.addLocomotief(locomotive2);

        PersonWagonGroup pgroup = new PersonWagonGroup();
        pgroup.addPersonWagon(personWagon);

        GoodsWagonGroup ggroup = new GoodsWagonGroup();
        ggroup.addGoodsWagon(goodsWagon);


        for (Locomotive searchLocomotive : lgroup) {
            if (searchLocomotive.getTrainId() == "tr1") {
                System.out.println(searchLocomotive);
            }
        }

        for (PersonWagon searchGoodsWagon : pgroup) {
            if (searchGoodsWagon.getTrainId() == "tr1") {
                System.out.println(searchGoodsWagon);
            }
        }

        for (GoodsWagon searchPersonWagon : ggroup) {
            if (searchPersonWagon.getTrainId() == "tr1") {
                System.out.println(searchPersonWagon);
            }
        }

    }
}
