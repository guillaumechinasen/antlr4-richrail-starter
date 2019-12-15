package domain;

public class Component {
    private String id;

    public Component(){}

    public Component(String id) {
        this.id = id;
    }

<<<<<<< Updated upstream
    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        String g =new GoodsWagon().getId();
        setId(g);
=======
    public void setGoodsid(String goodsid) {
        this.id = goodsid;
    }


    public String getGoodsid() {
        String g =new GoodsWagon().getGoodsid();
        setGoodsid(g);
>>>>>>> Stashed changes
        System.out.println(g);
        return g;
    }
}
