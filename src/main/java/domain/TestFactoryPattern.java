package domain;

import java.util.Scanner;

public class TestFactoryPattern {
    public static void main(String[] args) {
        RollingComponentFactoryInterface factory = new RollingComponentFactory("Locomotive");
        RollingComponent rollingComponent = factory.createRollingcomponent();
        rollingComponent.build();
    }
}
