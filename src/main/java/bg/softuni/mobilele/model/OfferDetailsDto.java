package bg.softuni.mobilele.model;

import bg.softuni.mobilele.model.enums.EngineTypeEnum;

public record OfferDetailsDto (

        Long id,
        String description,
        Integer mileage,
        EngineTypeEnum engineType){
}
