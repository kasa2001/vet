package model.view.user;

import java.util.Date;

public class Visits {

    private Long id;

    private Date createdDate;

    private Date planningVisited;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getPlanningVisited() {
        return planningVisited;
    }

    public void setPlanningVisited(Date planningVisited) {
        this.planningVisited = planningVisited;
    }
}
