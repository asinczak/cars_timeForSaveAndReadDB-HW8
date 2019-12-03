package pl.akademiaspring.cars.model;

public class CarMongo extends Car {

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", mark='" + mark + '\'' +
                ", productionYear='" + productionYear + '\'' +
                ", vin='" + vin + '\'' +
                '}';
    }
}
