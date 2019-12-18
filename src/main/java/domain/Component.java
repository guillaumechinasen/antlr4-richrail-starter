package domain;

public class Component {
    private String id;
    private String cargo;
    private String fueltype;
    private int seats;

    public Component(){}

    public Component(String id) {
        this.id = id;
    }

    public void setCargo(String cargo) {
       this.cargo = cargo;
    }

    public void setFueltype(String fueltype) {
        this.fueltype = fueltype;
    }

    public void setPersonid(String personid){
        this.id = personid;
    }
    public void setGoodsid(String goodsid) {
        this.id = goodsid;
    }
    public void setLocoId(String locoId){
        this.id = locoId;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public String getGoodsid() {
        String g =new GoodsWagon().getGoodsid();
        setGoodsid(g);
        System.out.println(g);
        return g;
    }

    @Override
    public String toString() {
        return "Component{" +
                "id='" + id + '\'' +
                ", cargo='" + cargo + '\'' +
                ", fueltype='" + fueltype + '\'' +
                ", seats=" + seats +
                '}';
    }
}
