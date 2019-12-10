package domain;//Deze java klasse wordt gebruikt om alleen de domein klassen te testen.

import domain.*;

public class Test {
    public static void main(String[] args) {
        PersonWagonBuilderInterface personWagonBuilderInterface = new PersonWagonBuilder();
        GoodsWagonBuilderInterface goodsWagonBuilderInterface = new GoodWagonBuilder();
        LocomotiveBuilderInterface locomotiveBuilderInterface = new LocomotiveBuilder();

        personWagonBuilderInterface.setName("Test PersonWagon");
        personWagonBuilderInterface.setClassType("Klasse 2");
        personWagonBuilderInterface.setSeats(20);
        PersonWagon personWagon = (PersonWagon) personWagonBuilderInterface.build();

        goodsWagonBuilderInterface.setId(0001);
        goodsWagonBuilderInterface.setCargo("Diesel");
        GoodsWagon goodsWagon = (GoodsWagon) goodsWagonBuilderInterface.build();

        locomotiveBuilderInterface.setId(1003);
        locomotiveBuilderInterface.setFuelType("Kolen");
        Locomotive locomotive = (Locomotive) locomotiveBuilderInterface.build();

        personWagon.build();
        System.out.println("\n");
        goodsWagon.build();
        System.out.println("\n");
        locomotive.build();
    }
}
