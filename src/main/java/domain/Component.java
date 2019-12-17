package domain;

import com.google.gson.annotations.SerializedName;

public class Component {
    @SerializedName("id")

    private String id;
    private String cargo;
    private String fueltype;
    private int seats;

    public Component(){}

    public Component(String id) {
        this.id = id;
    }

    public void setGoodsid(String goodsid) {
        this.id = goodsid;
    }
    public void setLocoId(String locoId){
        this.id = locoId;
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
