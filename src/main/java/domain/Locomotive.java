package domain;

public class Locomotive extends Component{
    private String locoid;
    private String Fueltype;

    public Locomotive(String id, String fuelType) {
        super(id);
        this.locoid = id;
        super.setLocoId(locoid);
        this.Fueltype = fuelType;
        super.setFueltype(Fueltype);
    }
    public Locomotive(){}

    public String getGoodsid() {
        return locoid;
    }


    public void setFueltype(String fueltype) {
        this.Fueltype = fueltype;
    }

    @Override
    public String toString() {
        return "Locomotive{" +
                "id='" + locoid + '\'' +
                ", fuelType='" + Fueltype + '\'' +
                '}';

    }


}
