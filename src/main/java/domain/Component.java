package domain;

public class Component {
    private String id;

    public Component(){}

    public Component(String id) {
        this.id = id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        String g =new GoodsWagon().getId();
        setId(g);
        System.out.println(g);
        return g;
    }
}
