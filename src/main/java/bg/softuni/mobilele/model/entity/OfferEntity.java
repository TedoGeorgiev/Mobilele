package bg.softuni.mobilele.model.entity;


import bg.softuni.mobilele.model.enums.EngineTypeEnum;
import jakarta.persistence.*;

@Entity
@Table(name = "offers")
public class OfferEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String description;

    @Column
    @Enumerated(EnumType.STRING)
    private EngineTypeEnum engine;


    public long getId() {
        return id;
    }

    //Design Patter Builder
    public OfferEntity setId(long id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    //Design Patter Builder
    public OfferEntity setDescription(String description) {
        this.description = description;
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
