package bg.softuni.mobilele.service.impl;


import bg.softuni.mobilele.model.UserLoginDTO;
import bg.softuni.mobilele.model.UserRegistrationDto;
import bg.softuni.mobilele.model.entity.UserEntity;
import bg.softuni.mobilele.repository.UserRepository;
import bg.softuni.mobilele.service.CurrentUser;
import bg.softuni.mobilele.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepepository;
    private final CurrentUser currentUser;

    public UserServiceImpl(ModelMapper modelMapper, PasswordEncoder passwordEncoder, UserRepository userRepepository, CurrentUser currentUser) {
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
        this.userRepepository = userRepepository;
        this.currentUser = currentUser;
    }

    @Override
    public void registerUser(UserRegistrationDto userRegistrationDto) {

        userRepepository.save(map(userRegistrationDto));
    }

    @Override
    public boolean loginUser(UserLoginDTO userLoginDTO) {

        UserEntity userEntity = userRepepository
                .findByEmail(userLoginDTO.email())
                .orElse(null);

        if (userLoginDTO.password() == null ||
                userEntity == null ||
                userEntity.getPassword() == null) {
            return false;
        }

        boolean success = passwordEncoder.matches(userLoginDTO.password(), userEntity.getPassword());

        if (success) {
            currentUser.setLoggedIn(true);
            currentUser.setFullName(String.format("%s %s",
                    userEntity.getFirstName(), userEntity.getLastName()));
        } else {
            currentUser.clean();

        }

        return false;
    }

    private UserEntity map(UserRegistrationDto userRegistrationDto) {
        UserEntity mapped = modelMapper.map(userRegistrationDto, UserEntity.class);
        mapped.setPassword(passwordEncoder.encode(userRegistrationDto.getPassword()));
        return mapped;
    }
}
