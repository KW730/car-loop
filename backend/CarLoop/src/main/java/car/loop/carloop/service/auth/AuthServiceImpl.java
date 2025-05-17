package car.loop.carloop.service.auth;

import car.loop.carloop.dto.UserDto;
import car.loop.carloop.dto.requests.SignupRequest;
import car.loop.carloop.enums.UserRole;
import car.loop.carloop.model.User;
import car.loop.carloop.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    @PostConstruct
    private void createAdminAccount(){
        Optional<User> adminAccount = userRepository.findUserByUserRole(UserRole.ADMIN);
        if (adminAccount.isEmpty()){
            User user = new User();
            user.setEmail("serviceadmin@test.com");
            user.setUsername("admin");
            user.setUserRole(UserRole.ADMIN);
            user.setPassword(new BCryptPasswordEncoder().encode("admin1"));
            userRepository.save(user);
            System.out.println("Admin account has been created");
        }else {
            System.out.println("Admin account already exists");
        }
    }

    @Override
    public UserDto createUser(SignupRequest signupRequest) {
        if (userRepository.findUserByEmail(signupRequest.getEmail()).isPresent()){
            throw new EntityExistsException("User with that email already exists");
        }

        User user = new User();
        user.setEmail(signupRequest.getEmail());
        user.setUsername(signupRequest.getUsername());
        user.setUserRole(UserRole.USER);
        user.setPassword(new BCryptPasswordEncoder().encode(signupRequest.getPassword()));
        User createdUser = userRepository.save(user);
        return createdUser.getDto();
    }
}
