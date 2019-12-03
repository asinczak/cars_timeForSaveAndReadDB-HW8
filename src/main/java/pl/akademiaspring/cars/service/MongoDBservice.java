package pl.akademiaspring.cars.service;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.interceptor.PerformanceMonitorInterceptor;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.akademiaspring.cars.model.Car;
import pl.akademiaspring.cars.model.CarMongo;
import pl.akademiaspring.cars.repository.CarMongoDBRepo;

import java.io.FileNotFoundException;
import java.util.List;

@Service
@Aspect
@EnableAspectJAutoProxy
public class MongoDBservice {

    private CarMongoDBRepo carMongoDBrepo;
    private CsvReader csvReader;


    @Autowired
    public MongoDBservice(CarMongoDBRepo carMongoDBrepo, CsvReader csvReader){
        this.carMongoDBrepo = carMongoDBrepo;
        this.csvReader = csvReader;
    }

    @LogExecutionTime
    @EventListener(ApplicationReadyEvent.class)
    public void saveAllCars(){
            csvReader.readCsvforMongo().stream().forEach(car -> carMongoDBrepo.save(car));
    }

    public List<CarMongo> findAllCars(){
        return carMongoDBrepo.findAll();
    }
}
