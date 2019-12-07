package pl.akademiaspring.cars.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineAppStartupRunner implements CommandLineRunner {

    private MongoDBservice mongoDBservice;

    private MySqlService mySqlService;

    @Autowired
    public CommandLineAppStartupRunner(MongoDBservice mongoDBservice, MySqlService mySqlService) {
        this.mongoDBservice = mongoDBservice;
        this.mySqlService = mySqlService;
    }

    @Override
    public void run(String... args) {
        mongoDBservice.saveAllCars();
        mySqlService.saveAllCars();
        mongoDBservice.findAllCars();
        mySqlService.findAllCars();
    }
}
