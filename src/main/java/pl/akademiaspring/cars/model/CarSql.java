package pl.akademiaspring.cars.model;

import javax.persistence.*;

@Entity
@Table(name = "cars1000")
public class CarSql {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    String model;
    String mark;
    String productionYear;
    String vin;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(String productionYear) {
        this.productionYear = productionYear;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
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
