package bg.softuni.mobilele.web;


import bg.softuni.mobilele.model.AddOfferDTO;
import bg.softuni.mobilele.model.enums.EngineTypeEnum;
import bg.softuni.mobilele.service.OfferService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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


    // This can be missed @ModelAttribute("addOfferDTO").
    // Is used only when there is another object, which should not be mapped to model
    @PostMapping("/add")
    public String createOffer(@Valid @ModelAttribute("addOfferDTO") AddOfferDTO addOfferDTO,
                              BindingResult bindingResult, RedirectAttributes rAtt) {

        if (bindingResult.hasErrors()) {
            rAtt.addFlashAttribute("addOfferDTO", addOfferDTO);
            rAtt.addFlashAttribute("org.springframework.validation.BindingResult.addOfferDTO", bindingResult);
            return "redirect:/offers/add";
        }

        long newOfferId = offerService.createOffer(addOfferDTO);

        return "redirect:/offers/" + newOfferId;

    }

}
