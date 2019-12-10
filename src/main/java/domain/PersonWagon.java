package domain;

public class PersonWagon implements Train{
    private String name;
    private String classType;
    private int seats;
    private Train mijntrein;

    public PersonWagon(String name, String classType, int seats) {
        this.name = name;
        this.classType = classType;
        this.seats = seats;
    }

    @Override
    public void build() {
        System.out.println("Personwagon\nNaam:" + this.name +
                            "\nClasstype:" + this.classType +
                            "\nSeats:" + this.seats +
                            "\nPersonWagon has been made!");
    }
}
