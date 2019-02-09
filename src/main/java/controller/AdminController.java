package controller;

import model.entity.Findings;
import model.entity.Users;
import model.entity.Visit;
import model.view.admin.AnimalType;
import model.view.admin.Finding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import repository.AnimalTypeRepository;
import repository.FindingsRepository;
import repository.VisitRepository;
import service.VisitService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class AdminController {

    @Autowired
    private VisitService visitService;

    @Autowired
    private VisitRepository visitRepository;

    @Autowired
    private FindingsRepository findingsRepository;

    @Autowired
    private AnimalTypeRepository animalTypeRepository;

    @Autowired
    private HttpServletRequest request;

    @RequestMapping(value="/admin", method = RequestMethod.GET)
    public String main()
    {
        if (!this.checkSession())
        {
            return "error/403";
        }

        return "admin/main";
    }


    @RequestMapping(value="/admin/finding/add/{id}", method = RequestMethod.GET)
    public String addFindings(@PathVariable Long id, Model model)
    {
        if (!this.checkSession())
        {
            return "error/403";
        }
        model.addAttribute("finding", new Finding());
        return "admin/finding";
    }

    @RequestMapping(value = "/admin/finding/add/{id}", method = RequestMethod.POST)
    public String addFindings(Model model, @PathVariable Long id, @ModelAttribute("finding") @Valid Finding f, BindingResult result)
    {
        if (!this.checkSession())
        {
            return "error/403";
        }

        if(result.hasErrors()) {
            return "admin/finding";
        }

        Visit visit = this.visitRepository.findById(id).get();

        Findings findings = new Findings(f.getDiagnose(), visit);

        this.findingsRepository.save(findings);
        visit.setFinished(true);
        this.visitRepository.save(visit);

        model.addAttribute("visit", this.visitService.getAdminVisits(this.visitRepository));
        return "admin/visits";
    }

    @RequestMapping(value="/admin/animal/add", method = RequestMethod.GET)
    public String addAnimalCategory(Model model)
    {
        if (!this.checkSession())
        {
            return "error/403";
        }
        model.addAttribute("animalType", new AnimalType());
        return "admin/animalCategory";
    }

    @RequestMapping(value="/admin/animal/add", method = RequestMethod.POST)
    public String addAnimalCategory(@ModelAttribute("animalType") @Valid AnimalType a, BindingResult result)
    {
        if (!this.checkSession())
        {
            return "error/403";
        }
        if (result.hasErrors())
        {
            return "admin/animalCategory";
        }

        this.animalTypeRepository.save(new model.entity.AnimalType(a.getName()));

        return "admin/animalCategory";
    }

    @RequestMapping(value="/admin/visit", method = RequestMethod.GET)
    public String showVisits(Model model)
    {
        if (!this.checkSession())
        {
            return "error/403";
        }
        model.addAttribute("visit", this.visitService.getAdminVisits(this.visitRepository));
        return "admin/visits";
    }

    private boolean checkSession()
    {
        HttpSession session = this.request.getSession();

        Users users = (Users) session.getAttribute("user");
        return users != null && users.getUserType().getId() == 2;
    }
}
