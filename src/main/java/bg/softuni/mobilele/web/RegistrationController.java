package bg.softuni.mobilele.web;


import bg.softuni.mobilele.model.UserRegistrationDto;
import bg.softuni.mobilele.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class RegistrationController {

    private final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }


    @ModelAttribute("registerDTO")
    public UserRegistrationDto registerDTO() {
        return new UserRegistrationDto();
    }

    @GetMapping("/register")
    public String register() {

        return "auth-register";
    }

    @PostMapping("/register")
    public String register(UserRegistrationDto registerDTO) {

        userService.registerUser(registerDTO);

        return "redirect:/";
    }
}
