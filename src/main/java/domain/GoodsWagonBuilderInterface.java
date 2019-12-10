package domain;

public interface GoodsWagonBuilderInterface {
    void setId(int id);
    void setCargo (String cargo);
    Train build();
}
