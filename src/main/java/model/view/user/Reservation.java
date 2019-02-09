package model.view.user;

import java.util.Date;

public class Reservation {

    private Date date;

    private model.entity.Animal animal;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public model.entity.Animal getAnimal() {
        return animal;
    }

    public void setAnimal(model.entity.Animal animal) {
        this.animal = animal;
    }
}
