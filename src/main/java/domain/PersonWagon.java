package domain;

public class PersonWagon extends Component {
    private String personid;
    private int Seats;

    public PersonWagon(String id, int seats) {
        super(id);
        this.personid = id;
        super.setPersonid(personid);
         this.Seats = seats;
         super.setSeats(Seats);
    }


    public PersonWagon() {

    }

    public String getGoodsid() {
        return personid;
    }

    public void setGoodsid(String goodsid) {
        this.personid = goodsid;
    }

    public void setSeats(int seats) {
        this.Seats = seats;
    }

    @Override
    public String toString() {
        return "PersonWagon{" +
                "id='" + personid + '\'' +
                ", seats='" + Seats + '\'' +
                '}';
    }
}
