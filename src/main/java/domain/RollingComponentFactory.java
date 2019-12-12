package domain;


public class RollingComponentFactory implements RollingComponentFactoryInterface {
    private String componentType;
    private String id;
    private String fueltype;
    private String cargo;
    private int seats;


    public RollingComponentFactory(String componentType) {
        this.componentType = componentType;
    }

    public RollingComponentFactory(String componentType, String id, String fueltype, String cargo, int seats) {
        this.componentType = componentType;
        this.id = id;
        this.fueltype = fueltype;
        this.cargo = cargo;
        this.seats = seats;
    }
    public RollingComponentFactory(){}

    @Override
    public RollingComponent createRollingcomponent() {
        if (componentType == "Locomotive") {
            return new Locomotive(this.id,this.fueltype);
        }
        if (componentType == "Goodswagon") {
            GoodsWagon g = new GoodsWagon(this.id,this.cargo);
            g.toString();
            System.out.println(g);
        }
            if(componentType == "Personwagon") {
            PersonWagon p = new PersonWagon(this.id, this.seats);
            p.toString();
                System.out.println(p);
        }
        return null;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setFueltype(String fueltype) {
        this.fueltype = fueltype;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void setSeats(int seats) {
        this.seats = seats;
        System.out.println(seats);
    }
}
