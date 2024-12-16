package bg.softuni.mobilele.service;

import bg.softuni.mobilele.model.AddOfferDTO;
import bg.softuni.mobilele.model.OfferDetailsDto;

public interface OfferService {

    long createOffer(AddOfferDTO addOfferDTO);

    OfferDetailsDto getOfferDetails(Long id);
}
