package domain;

public class GoodsWagon extends Component{
    private String goodsid;
    private String Cargo;

    public GoodsWagon(String id, String Cargo) {
        super(id);
        this.goodsid = id;
        super.setGoodsid(goodsid);
        this.Cargo = Cargo;
        super.setCargo(this.Cargo);
    }


    @Override
    public String getGoodsid() {
        return this.goodsid;
    }

    public GoodsWagon() {}

    public void setGoodsid(String goodsid) {
        this.goodsid = goodsid;
    }

    public void setCargo(String cargo) {
        this.Cargo = cargo;
    }


    @Override
    public String toString() {
        return "GoodsWagon{" +
                "id='" + goodsid + '\'' +
                ", cargo='" + Cargo + '\'' +
                '}';
    }
}
