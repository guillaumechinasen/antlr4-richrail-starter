package domain;

import domain.GoodsWagonBuilderInterface;

public class GoodWagonBuilder implements GoodsWagonBuilderInterface {
    private int id;
    private String cargo;

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Override
    public Train build() {
        return new GoodsWagon(id, cargo);
    }
}
