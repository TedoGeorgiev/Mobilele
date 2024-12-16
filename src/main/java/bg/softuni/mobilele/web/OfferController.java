package bg.softuni.mobilele.web;


import bg.softuni.mobilele.model.AddOfferDTO;
import bg.softuni.mobilele.model.enums.EngineTypeEnum;
import bg.softuni.mobilele.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/offers")
public class OfferController {

    private final OfferService offerService;

    @Autowired
    public OfferController(OfferService offerService) {
        this.offerService = offerService;
    }

    @GetMapping("/add")
    public String newOffer(Model model) {

        if (!model.containsAttribute("addOfferDTO")) {
            model.addAttribute("addOfferDTO", AddOfferDTO.empty());
        }
        model.addAttribute("allEngineTypes", EngineTypeEnum.values());

        return "offer-add";
    }


    // This can be missed @ModelAttribute("addOfferDTO")
    @PostMapping("/add")
    public String createOffer(@ModelAttribute("addOfferDTO") AddOfferDTO addOfferDTO) {

        offerService.createOffer(addOfferDTO);

        //TODO
        return "offer-add";
    }

}
