package pl.akademiaspring.cars.service;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.akademiaspring.cars.model.Car;
import pl.akademiaspring.cars.model.CarMongo;
import pl.akademiaspring.cars.model.CarSql;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CsvReader {


    public List<CarMongo> readCsvforMongo() {

        Map<String, String> mapping = new HashMap<>();
        mapping.put("id", "Id");
        mapping.put("mark", "Mark");
        mapping.put("model", "Model");
        mapping.put("productionYear", "Production_year");
        mapping.put("vin", "Vin");

        HeaderColumnNameTranslateMappingStrategy<CarMongo> strategy =
                new HeaderColumnNameTranslateMappingStrategy<CarMongo>();
        strategy.setType(CarMongo.class);
        strategy.setColumnMapping(mapping);

        CSVReader csvReader = null;
        try {
            csvReader = new CSVReader(new FileReader
                    ("src/main/resources/templates/cars.csv"));
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        CsvToBean csvToBean = new CsvToBean();

        List<CarMongo> list = csvToBean.parse(strategy, csvReader);

//        for (Car car : list) {
//            System.out.println(car);
//        }

        return list;
}


    public List<CarSql> readCsvforSQL() {

        Map<String, String> mapping = new HashMap<>();
        mapping.put("mark", "Mark");
        mapping.put("model", "Model");
        mapping.put("productionYear", "Production_year");
        mapping.put("vin", "Vin");

        HeaderColumnNameTranslateMappingStrategy<CarSql> strategy =
                new HeaderColumnNameTranslateMappingStrategy<CarSql>();
        strategy.setType(CarSql.class);
        strategy.setColumnMapping(mapping);

        CSVReader csvReader = null;
        try {
            csvReader = new CSVReader(new FileReader
                    ("src/main/resources/templates/cars.csv"));
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        CsvToBean csvToBean = new CsvToBean();

        List<CarSql> list = csvToBean.parse(strategy, csvReader);

        for (Car car : list) {
            System.out.println(car);
        }

        return list;
    }
}
