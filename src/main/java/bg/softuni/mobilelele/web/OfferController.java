package bg.softuni.mobilelele.web;


import bg.softuni.mobilelele.model.dto.AddOfferDto;
import bg.softuni.mobilelele.service.OfferService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class OfferController {

    private final OfferService offerService;

    public OfferController(OfferService offerService) {
        this.offerService = offerService;
    }

    @GetMapping("/offers/all")
    public String allOffers() {
        return "offers";
    }


    @GetMapping("/offers/add")
    public String addOffer(Model model) {

        if (!model.containsAttribute("addOfferModel")) {
            model.addAttribute("addOfferModel", new AddOfferDto());
        }

        return "offer-add";
    }

    @PostMapping("/offers/add")
    public String addOffer(@Valid AddOfferDto addOfferModel,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("addOfferModel", addOfferModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.addOfferModel", bindingResult);

            return "redirect:/offers/add";
        }

        // TODO

        return "redirect:/";
    }

}
