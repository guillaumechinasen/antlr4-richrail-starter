package domain;

public class PersonWagon implements RollingComponent{
    private String id;
    private int seats;

    public PersonWagon(String id, int seats) {
        this.id = id;
        this.seats = seats;
    }

    public PersonWagon() {

    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "PersonWagon{" +
                "id='" + id + '\'' +
                ", seats='" + seats + '\'' +
                '}';
    }

    @Override
    public void build() {
        System.out.println(id + seats);
    }
}
