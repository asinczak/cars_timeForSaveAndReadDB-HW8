package pl.akademiaspring.cars.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import pl.akademiaspring.cars.model.CarMongo;

public interface CarMongoDBRepo extends MongoRepository <CarMongo, String> {
}
