package car.loop.carloop.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReservationDto {

    private Long id;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
}
