package car.loop.carloop.repository;

import car.loop.carloop.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    Optional<Vehicle> findVehicleByType(String type);
    Optional<Vehicle> findVehicleById(Long id);
    Optional<Vehicle> findVehicleByPrice(Integer price);

}
