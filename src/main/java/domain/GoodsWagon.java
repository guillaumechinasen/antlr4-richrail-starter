package domain;

public class GoodsWagon extends Component{
    private String id;
    private String cargo;

    public GoodsWagon(String id, String cargo) {
        this.id = id;
        this.cargo = cargo;
    }


    public GoodsWagon() {}

    public void setId(String id) {
        this.id = id;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }


    @Override
    public String toString() {
        return "GoodsWagon{" +
                "id='" + id + '\'' +
                ", cargo='" + cargo + '\'' +
                '}';
    }
}
