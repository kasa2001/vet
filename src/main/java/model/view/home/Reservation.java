package model.view.home;

import javax.validation.constraints.Future;
import java.util.Date;

public class Reservation {

    @Future
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
