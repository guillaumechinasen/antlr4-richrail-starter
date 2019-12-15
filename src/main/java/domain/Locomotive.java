package domain;

public class Locomotive extends Component{
    private String id;
    private String fuelType;

    public Locomotive(String id, String fuelType) {
        this.id = id;
        this.fuelType = fuelType;
    }

    public String getId() {
        return id;
    }

<<<<<<< Updated upstream
    public void setId(String id) {
        this.id = id;
    }
=======

    public void setGoodsid(String goodsid) {
        this.locoid = goodsid;
    }

>>>>>>> Stashed changes

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    @Override
    public String toString() {
        return "Locomotive{" +
                "id='" + id + '\'' +
                ", fuelType='" + fuelType + '\'' +
                '}';

    }


}
