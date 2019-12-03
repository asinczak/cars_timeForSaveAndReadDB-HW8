package pl.akademiaspring.cars.model;

import javax.persistence.*;

@Entity
@Table(name = "cars1000")
public class CarSql extends Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
