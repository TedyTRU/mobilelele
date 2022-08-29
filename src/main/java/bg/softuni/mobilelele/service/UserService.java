package bg.softuni.mobilelele.service;

import bg.softuni.mobilelele.model.dto.UserLoginDto;
import bg.softuni.mobilelele.model.dto.UserRegisterDto;
import bg.softuni.mobilelele.model.entity.User;
import bg.softuni.mobilelele.model.mapper.UserMapper;
import bg.softuni.mobilelele.repository.UserRepository;
import bg.softuni.mobilelele.user.CurrentUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserService {

    private final Logger LOGGER = LoggerFactory.getLogger(UserService.class);
    private final UserRepository userRepository;
    private final CurrentUser currentUser;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, CurrentUser currentUser, PasswordEncoder passwordEncoder, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.currentUser = currentUser;
        this.passwordEncoder = passwordEncoder;
        this.userMapper = userMapper;
    }

    public boolean login(UserLoginDto loginDto) {
        Optional<User> userOpt = userRepository
                .findByEmail(loginDto.getEmail());

        if (userOpt.isEmpty()) {
            LOGGER.info("User not found. User name: {}", loginDto.getEmail());
            return false;
        }

        String rawPassword = loginDto.getPassword();
        String encodedPassword = userOpt.get().getPassword();

        //boolean success = userOpt.get().getPassword().equals(loginDto.getPassword());
        boolean success = passwordEncoder
                .matches(rawPassword, encodedPassword);

        if (success) {
            login(userOpt.get());
        } else {
            logout();
        }

        return success;
    }

    private void login(User user) {
        currentUser
                .setLoggedIn(true)
                .setName(user.getFirstName() + " " + user.getLastName())
                .setEmail(user.getEmail());
    }

    public void logout() {
        currentUser.clear();
    }

    public void registerAndLogin(UserRegisterDto userRegisterDto) {

        User newUser = userMapper.userDtoToUserEntity(userRegisterDto);
        newUser.setPassword(passwordEncoder.encode(userRegisterDto.getPassword()));

        userRepository.save(newUser);
        login(newUser);

    }

}
