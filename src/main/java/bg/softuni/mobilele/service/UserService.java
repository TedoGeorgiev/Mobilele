package bg.softuni.mobilele.service;

import bg.softuni.mobilele.model.UserLoginDTO;
import bg.softuni.mobilele.model.UserRegistrationDto;

public interface UserService {

    void registerUser(UserRegistrationDto userRegistrationDto);

    boolean loginUser(UserLoginDTO userLoginDTO);

}
