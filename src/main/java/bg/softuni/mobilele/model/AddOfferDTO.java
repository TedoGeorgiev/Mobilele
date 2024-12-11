package bg.softuni.mobilele.model;

import bg.softuni.mobilele.model.enums.EngineTypeEnum;

public record AddOfferDTO(
        String description,
        EngineTypeEnum engineType
) {

    public static AddOfferDTO empty() {
        return new AddOfferDTO(null, null);
    }


}
