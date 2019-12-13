package domain;

public class PersonWagon extends Component {
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

    public void setId(String id) {
        this.id = id;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    @Override
    public String toString() {
        return "PersonWagon{" +
                "id='" + id + '\'' +
                ", seats='" + seats + '\'' +
                '}';
    }
}
