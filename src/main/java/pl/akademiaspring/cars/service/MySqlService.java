package pl.akademiaspring.cars.service;

import org.springframework.stereotype.Service;
import pl.akademiaspring.cars.model.Car;
import pl.akademiaspring.cars.model.CarSql;
import pl.akademiaspring.cars.repository.CarMySqlRepo;

import java.io.FileNotFoundException;
import java.util.List;

@Service
public class MySqlService {

    private CarMySqlRepo carMySqlRepo;
    private CsvReader csvReader;

    public MySqlService(CarMySqlRepo carMySqlRepo, CsvReader csvReader){
        this.carMySqlRepo = carMySqlRepo;
        this.csvReader = csvReader;
    }

    @LogExecutionTime
    public void saveAllCars(){
            csvReader.readCsvforSQL().stream().forEach(car -> carMySqlRepo.save(car));
    }

    @LogExecutionTime
    public List<CarSql> findAllCars(){
        return carMySqlRepo.findAll();
    }
}
