package pl.akademiaspring.cars.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineAppStartupRunner implements CommandLineRunner {

    @Autowired
    private MongoDBservice mongoDBservice;

    @Autowired
    private MySqlService mySqlService;

    @Override
    public void run(String... args) throws Exception {
//        mongoDBservice.saveAllCars();
//        mongoDBservice.findAllCars();
       mySqlService.saveAllCars();
       mySqlService.findAllCars();
    }
}
