package bg.softuni.mobilele.service;

import bg.softuni.mobilele.model.AddOfferDTO;
import bg.softuni.mobilele.model.entity.OfferEntity;
import bg.softuni.mobilele.repository.OfferRepository;
import org.springframework.stereotype.Service;

@Service
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;

    public OfferServiceImpl(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    @Override
    public void createOffer(AddOfferDTO addOfferDTO) {
        offerRepository.save(map(addOfferDTO));
    }

    private static OfferEntity map (AddOfferDTO addOfferDTO) {
         //design Pattern Builder
        return new OfferEntity().setDescription(addOfferDTO.description()).setEngine(addOfferDTO.engineType());
    }
}
