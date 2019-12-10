package domain;

public interface PersonWagonBuilderInterface {
    void setName(String name);
    void setClassType(String classType);
    void setSeats(int seats);
    Train build();
}
