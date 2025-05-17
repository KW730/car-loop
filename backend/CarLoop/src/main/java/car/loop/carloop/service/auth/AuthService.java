package car.loop.carloop.service.auth;

import car.loop.carloop.dto.UserDto;
import car.loop.carloop.dto.requests.SignupRequest;
import org.springframework.stereotype.Service;

@Service
public interface AuthService {

    public UserDto createUser(SignupRequest signupRequest);
}
