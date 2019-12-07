package pl.akademiaspring.cars.model;

public class CarMongo {

    private String id;
    private String model;
    private String mark;
    private String production_Year;
    private String vin;

    public CarMongo(String model, String mark, String productionYear, String vin) {
        this.model = model;
        this.mark = mark;
        this.production_Year = productionYear;
        this.vin = vin;
    }

    public CarMongo() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getProduction_Year() {
        return production_Year;
    }

    public void setProduction_Year(String production_Year) {
        this.production_Year = production_Year;
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
                ", productionYear='" + production_Year + '\'' +
                ", vin='" + vin + '\'' +
                '}';
    }
}
