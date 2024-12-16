package bg.softuni.mobilele.service;

import bg.softuni.mobilele.model.AddOfferDTO;
import bg.softuni.mobilele.model.OfferDetailsDto;
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
    public long createOffer(AddOfferDTO addOfferDTO) {
        return offerRepository.save(map(addOfferDTO)).getId();
    }

    @Override
    public OfferDetailsDto getOfferDetails(Long id) {

        return this.offerRepository
                .findById(id)
                .map(OfferServiceImpl::toOfferDetails)
                .orElseThrow();
    }

    private static OfferDetailsDto toOfferDetails(OfferEntity offerEntity) {
        // TODO use mapping library
        return new OfferDetailsDto(offerEntity.getId(),
                offerEntity.getDescription(),
                offerEntity.getMileage(),
                offerEntity.getEngine());
    }

    private static OfferEntity map(AddOfferDTO addOfferDTO) {
        //design Pattern Builder
        return new OfferEntity()
                .setDescription(addOfferDTO.description())
                .setEngine(addOfferDTO.engineType())
                .setMileage(addOfferDTO.mileage());
    }
}
