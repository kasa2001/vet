package model.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Findings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Date createdDate = new Date();

    private String diagnose;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="visit_id", nullable = false)
    private Visit visit;

    public Findings() {
    }

    public Findings(String diagnose, Visit visit) {
        this.diagnose = diagnose;
        this.visit = visit;
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

    public String getDiagnose() {
        return diagnose;
    }

    public void setDiagnose(String diagnose) {
        this.diagnose = diagnose;
    }

    public Visit getVisit() {
        return visit;
    }

    public void setVisit(Visit visit) {
        this.visit = visit;
    }
}
