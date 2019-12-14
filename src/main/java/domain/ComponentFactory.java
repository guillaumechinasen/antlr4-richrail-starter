package domain;

public class ComponentFactory implements ComponentFactoryInterface {
    private String id;
    private String cargo;
    private String fueltype;
    private int seats;

    public ComponentFactory(String id, String fueltype, String cargo, int seats) {
        this.id = id;
        this.fueltype = fueltype;
        this.cargo = cargo;
        this.seats = seats;
    }
    public ComponentFactory(){}

    @Override
    public Component CreateComponents(String type) {
        if (type == "Locomotive") {
            return new Locomotive(this.id,this.fueltype);
        }
        if (type == "Goodswagon") {
            return new GoodsWagon(this.id,this.cargo);
        }
        if(type == "Personwagon") {
            return new PersonWagon(this.id, this.seats);
        }
        return null;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void setFueltype(String fueltype) {
        this.fueltype = fueltype;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }
}
