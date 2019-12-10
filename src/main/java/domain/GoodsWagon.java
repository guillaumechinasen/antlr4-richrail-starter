package domain;

public class GoodsWagon implements Train{
    private int id;
    private String cargo;

    public GoodsWagon(int id, String cargo) {
        this.id = id;
        this.cargo = cargo;
    }

    @Override
    public void build() {
        System.out.println("Goodswagon\nID:" + this.id +
                "\nClasstype:" + this.cargo +
                "\nGoodsWagon has been made!");
    }
}
