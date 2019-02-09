package model.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Visit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Date createdDate = new Date();

    private Date planningVisited;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="animal_id")
    private Animal animal;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="user_id")
    private Users users;

    private boolean isFinished = false;

    public Visit(Date planningVisited, Animal animal) {
        this.planningVisited = planningVisited;
        this.animal = animal;
    }

    public Visit(Date planningVisited) {
        this.planningVisited = planningVisited;
    }

    public Visit() {
    }

    public Visit(Date planningVisited, Animal animal, Users users) {
        this.planningVisited = planningVisited;
        this.animal = animal;
        this.users = users;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public void setFinished(boolean finished) {
        isFinished = finished;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }
}
