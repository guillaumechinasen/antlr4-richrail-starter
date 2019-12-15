package domain;

public class Component {
    private String id;

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
                "id='" +id + '\'' +
                '}';
    }
}
