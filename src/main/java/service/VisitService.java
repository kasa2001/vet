package service;

import model.entity.Animal;
import model.entity.Users;
import model.entity.Visit;
import model.view.admin.Visits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;
import repository.AnimalRepository;
import repository.UserRepository;
import repository.VisitRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class VisitService {

    public List<Visits> getAdminVisits(VisitRepository visitRepository)
    {
        List<Visit> visitList = visitRepository.findByNotFinished();
        List<Visits> visits = new ArrayList<>();

        for (Visit v: visitList) {
            Visits visit = new Visits();
            visit.setId(v.getId());
            visit.setCreatedDate(v.getCreatedDate());
            visit.setPlanningVisited(v.getPlanningVisited());
            visits.add(visit);
        }

        return visits;
    }

    public List<model.view.user.Visits> getUserVisits(VisitRepository visitRepository, Users users)
    {
        List<Visit> visitList = visitRepository.findByNotFinished(users);
        List<model.view.user.Visits> visits = new ArrayList<>();

        for (Visit v: visitList) {
            model.view.user.Visits visit = new model.view.user.Visits();
            visit.setId(v.getId());
            visit.setCreatedDate(v.getCreatedDate());
            visit.setPlanningVisited(v.getPlanningVisited());
            visits.add(visit);
        }

        return visits;
    }

    public void addVisit(VisitRepository visitRepository, Date planning)
    {
        Visit visit = new Visit(planning);
        visitRepository.save(visit);
    }

    public void addVisit(VisitRepository visitRepository, AnimalRepository animalRepository, Date planning, Long animalId)
    {
        Optional<Animal> animal = animalRepository.findById(animalId);
        Visit visit = new Visit(planning, animal.get());
        visitRepository.save(visit);
    }
}
