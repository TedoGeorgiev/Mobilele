package bg.softuni.mobilele.service;

import bg.softuni.mobilele.model.AddOfferDTO;
import bg.softuni.mobilele.model.OfferDetailsDto;

public interface OfferService {

    void createOffer(AddOfferDTO addOfferDTO);

    OfferDetailsDto getOfferDetails(Long id);
}
