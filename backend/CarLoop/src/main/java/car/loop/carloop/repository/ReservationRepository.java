package car.loop.carloop.repository;

import car.loop.carloop.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    Optional<Reservation> getReservationById(Long id);
    Optional<Reservation> getUserReservations(@Param("userId") Long userId);
}
