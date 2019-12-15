package domain;

public class Locomotive extends Component{
    private String locoid;
    private String fuelType;

    public Locomotive(String id, String fuelType) {
        this.locoid = id;
        this.fuelType = fuelType;
    }
    public Locomotive(){}

    public String getGoodsid() {
        return locoid;
    }


    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    @Override
    public String toString() {
        return "Locomotive{" +
                "id='" + locoid + '\'' +
                ", fuelType='" + fuelType + '\'' +
                '}';

    }


}
