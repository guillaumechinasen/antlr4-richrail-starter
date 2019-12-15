package domain;

public class GoodsWagon extends Component{
    private String goodsid;
    private String cargo;

    public GoodsWagon(String id, String cargo) {
        this.goodsid = id;
        this.cargo = cargo;
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
        this.cargo = cargo;
    }


    @Override
    public String toString() {
        return "GoodsWagon{" +
                "id='" + goodsid + '\'' +
                ", cargo='" + cargo + '\'' +
                '}';
    }
}
