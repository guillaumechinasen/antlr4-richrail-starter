package domain;

public class PersonWagonBuilder implements PersonWagonBuilderInterface{
    private String name;
    private String classType;
    private int seats;

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setClassType(String classType) {
        this.classType = classType;
    }

    @Override
    public void setSeats(int seats) {
        this.seats = seats;
    }

    @Override
    public Train build() {
        return new PersonWagon(name, classType, seats);
    }
}