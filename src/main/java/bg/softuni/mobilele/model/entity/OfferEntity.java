package bg.softuni.mobilele.model.entity;


import bg.softuni.mobilele.model.enums.EngineTypeEnum;
import jakarta.persistence.*;

@Entity
@Table(name = "offers")
public class OfferEntity extends BaseEntity {


    @Column
    private String description;

    @Column
    private Integer mileage;

    @Column
    @Enumerated(EnumType.STRING)
    private EngineTypeEnum engine;


    public String getDescription() {
        return description;
    }

    //Design Patter Builder
    public OfferEntity setDescription(String description) {
        this.description = description;
        return this;
    }

    public Integer getMileage() {
        return mileage;
    }

    public OfferEntity setMileage(Integer mileage) {
        this.mileage = mileage;
        return this;
    }

    public EngineTypeEnum getEngine() {
        return engine;
    }

    //Design Patter Builder
    public OfferEntity setEngine(EngineTypeEnum engine) {
        this.engine = engine;
        return this;
    }


}
