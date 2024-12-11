package bg.softuni.mobilele.service;


import bg.softuni.mobilele.model.UserRegistrationDto;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{


    @Override
    public void registerUser(UserRegistrationDto userRegistrationDto) {
        //TODO
        System.out.println("The user received is: " + userRegistrationDto);
    }
}
