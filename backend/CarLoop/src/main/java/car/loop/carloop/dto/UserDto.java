package car.loop.carloop.dto;

import car.loop.carloop.enums.UserRole;
import lombok.Data;

@Data
public class UserDto {

    private Long id;
    private String email;
    private String username;
    private UserRole userRole;
}
