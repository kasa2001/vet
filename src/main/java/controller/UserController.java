package controller;

import model.entity.Animal;
import model.entity.AnimalType;
import model.entity.Users;
import model.entity.Visit;
import model.view.admin.Finding;
import model.view.user.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import repository.*;
import service.VisitService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@SessionAttributes(names={"user", "type"})
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FindingsRepository findingsRepository;

    @Autowired
    private AnimalRepository animalRepository;

    @Autowired
    private VisitService visitService;

    @Autowired
    private VisitRepository visitRepository;

    @Autowired
    private AnimalTypeRepository animalTypeRepository;

    @Autowired
    private HttpServletRequest request;

    @RequestMapping(value="/user", method = RequestMethod.GET)
    public String main()
    {
        if (!this.checkSession())
        {
            return "error/403";
        }

        return "user/main";
    }

    @RequestMapping(value="/user/animal/add", method = RequestMethod.GET)
    public String addAnimal(Model model)
    {
        if (!this.checkSession())
        {
            return "error/403";
        }
        model.addAttribute("animal", new model.entity.Animal());
        return "user/addAnimal";
    }

    @ModelAttribute("animalType")
    public Iterable<AnimalType> loadTypes(){
        return animalTypeRepository.findAll();
    }

    @RequestMapping(value="/user/animal/add", method = RequestMethod.POST)
    public String addAnimalCategory(@ModelAttribute("animal") @Valid Animal a, BindingResult result)
    {
        if (!this.checkSession())
        {
            return "error/403";
        }
        if (result.hasErrors())
        {
            return "user/addAnimal";
        }

        a.setUser((Users)this.request.getSession().getAttribute("user"));
        this.animalRepository.save(a);

        return "redirect:/user";
    }

    @RequestMapping(value="/user/visits", method = RequestMethod.GET)
    public String checkVisits(Model model)
    {
        if (!this.checkSession())
        {
            return "error/403";
        }
        model.addAttribute("visit", this.visitService.getUserVisits(this.visitRepository, ((Users)this.request.getSession().getAttribute("user"))));
        return "user/visits";
    }

    @RequestMapping(value="/user/finding/{id}", method = RequestMethod.GET)
    public String finding(@PathVariable Long id, Model model)
    {
        if (!this.checkSession())
        {
            return "error/403";
        }
        model.addAttribute("finding", this.findingsRepository.findByVisits(this.visitRepository.findById(id).get()));
        return "user/finding";
    }

    @RequestMapping(value="/user/animal/{id}", method = RequestMethod.GET)
    public String checkConditionAnimal(@PathVariable Long id, Model model)
    {
        if (!this.checkSession())
        {
            return "error/403";
        }
        Animal animal = this.animalRepository.findById(id).get();
        if (((Users)this.request.getSession().getAttribute("user")).getId() != animal.getUser().getId())
        {
            return "error/403";
        }

        model.addAttribute("finding", this.findingsRepository.findByVisits(this.visitRepository.findByAnimal(animal)));

        return "user/finding";
    }

    @RequestMapping(value = "/user/animal", method = RequestMethod.GET)
    public String animalList(Model model)
    {
        if (!this.checkSession())
        {
            return "error/403";
        }
        model.addAttribute("animal", this.animalRepository.findByUser((Users) this.request.getSession().getAttribute("user")));
        return "user/animal";
    }

    private boolean checkSession()
    {
        HttpSession session = this.request.getSession();

        Users users = (Users) session.getAttribute("user");
        return users != null && users.getUserType().getId() == 1;
    }

    @RequestMapping(value="/user/visit/add", method = RequestMethod.GET)
    public String visit(Model model) {
        if (!this.checkSession())
        {
            return "error/403";
        }
        model.addAttribute("reservation", new Reservation());
        return "user/addVisit";
    }

    @RequestMapping(value="/user/visit/add", method = RequestMethod.POST)
    public String visit(@ModelAttribute("reservation") @Valid Reservation r, BindingResult result) {
        if (!this.checkSession())
        {
            return "error/403";
        }
        if (result.hasErrors())
        {
            return "user/addVisit";
        }

        Visit visit = new Visit(r.getDate(), r.getAnimal(), (Users) this.request.getSession().getAttribute("user"));

        this.visitRepository.save(visit);

        return "redirect:/user";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, "date", new CustomDateEditor(dateFormat, false));
    }


    @ModelAttribute("animal")
    public Iterable<Animal> loadAnimals(){
        return animalRepository.findByUser((Users) this.request.getSession().getAttribute("user"));
    }
}
