package bg.softuni.mobilele.model;

import bg.softuni.mobilele.model.enums.EngineTypeEnum;
import jakarta.validation.constraints.*;

public record AddOfferDTO(

        @NotEmpty(message = "{add.offer.description.not.empty}")
        @Size(message = "{add.offer.description.length}", min = 5, max = 100)
        String description,

        @NotNull
        @PositiveOrZero
        Integer mileage,

        @NotNull
        EngineTypeEnum engineType
) {

    public static AddOfferDTO empty() {
        return new AddOfferDTO(null, null, null);
    }


}
