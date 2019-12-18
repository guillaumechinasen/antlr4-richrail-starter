package domain;

public class PersonWagon extends Component {
    private String personid;
    private int seats;

    public PersonWagon(String id, int seats) {
        this.personid = id;
        this.seats = seats;
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
        this.seats = seats;
    }

    @Override
    public String toString() {
        return "("  + personid + ":"+seats+")";
    }
}
