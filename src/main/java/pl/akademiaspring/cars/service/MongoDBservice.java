package pl.akademiaspring.cars.service;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.akademiaspring.cars.model.CarMongo;
import pl.akademiaspring.cars.repository.CarMongoDBRepo;

import java.util.List;

@Service
public class MongoDBservice {

    private CarMongoDBRepo carMongoDBrepo;
    private CsvReader csvReader;


    @Autowired
    public MongoDBservice(CarMongoDBRepo carMongoDBrepo, CsvReader csvReader){
        this.carMongoDBrepo = carMongoDBrepo;
        this.csvReader = csvReader;
    }

    @LogExecutionTime
    public void saveAllCars(){
            csvReader.readCsvforMongo().stream().forEach(car -> carMongoDBrepo.save(car));
    }

    @LogExecutionTime
    public List<CarMongo> findAllCars(){
        return carMongoDBrepo.findAll();
    }
}
