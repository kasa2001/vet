package model.view.admin;

import org.hibernate.validator.constraints.Length;

public class AnimalType {


    @Length(min = 2, max = 255)
    String name;

    model.entity.AnimalType animalType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public model.entity.AnimalType getAnimalType() {
        return animalType;
    }

    public void setAnimalType(model.entity.AnimalType animalType) {
        this.animalType = animalType;
    }
}
