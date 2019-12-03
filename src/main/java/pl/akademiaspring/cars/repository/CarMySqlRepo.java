package pl.akademiaspring.cars.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.akademiaspring.cars.model.CarSql;

@Repository
public interface CarMySqlRepo extends JpaRepository<CarSql, Long> {
}
