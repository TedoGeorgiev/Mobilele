package bg.softuni.mobilele.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OfferController {


    @GetMapping("/offers")
    public String offers() {


        return "offers";
    }
}
