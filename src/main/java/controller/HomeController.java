package controller;

import model.entity.Users;
import model.entity.Visit;
import model.view.home.Registry;
import model.view.home.Reservation;
import model.view.user.Login;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import repository.UserRepository;
import repository.UserTypeRepository;
import repository.VisitRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class HomeController {

    private static final Logger logger = LogManager.getLogger(HomeController.class);

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private UserTypeRepository userTypeRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private VisitRepository visitRepository;

    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String login(Model model)
    {
        model.addAttribute("login", new Login());
        return "login";
    }

    @RequestMapping(value="/login", method = RequestMethod.POST)
    public String login(@ModelAttribute("login") @Valid Login l, BindingResult result, Model model)
    {
        if(result.hasErrors() || this.userRepository.checkSimple(l.getName(), l.getPassword()).size() != 1)
        {
            model.addAttribute("message", "Wrong name or password");
            return "login";
        }

        HttpSession session = this.request.getSession();
        Users users = this.userRepository.checkSimple(l.getName(), l.getPassword()).get(0);
        session.setAttribute("user", users);

        if (users.getUserType().getId() == 1)
        {
            return "redirect:/user";
        }
        return "redirect:/admin";
    }

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String home(Model model) {
        model.addAttribute("user", (Users) this.request.getSession().getAttribute("user"));
        return "home";
    }

    @RequestMapping(value="/visit", method = RequestMethod.GET)
    public String visit(Model model) {
        model.addAttribute("reservation", new Reservation());
        return "visit";
    }

    @RequestMapping(value="/visit", method = RequestMethod.POST)
    public String visit(@ModelAttribute("reservation") @Valid Reservation r, BindingResult result) {
        if (result.hasErrors())
        {
            return "visit";
        }

        Visit visit = new Visit(r.getDate());

        this.visitRepository.save(visit);

        return "redirect:/";
    }

    @RequestMapping(value="/registry", method = RequestMethod.GET)
    public String registry(Model model)
    {
        model.addAttribute("registry", new Registry());
        return "registry";
    }

    @RequestMapping(value="/registry", method = RequestMethod.POST)
    public String registry(@ModelAttribute("registry") @Valid Registry r, BindingResult result)
    {
        if (result.hasErrors())
        {
            return "registry";
        }

        Users user = new Users(r.getName(), r.getPassword(), r.getEmail());
        user.setUserType(this.userTypeRepository.findById(new Long(1)).get());

        this.userRepository.save(user);

        return "registry";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout()
    {
        HttpSession session = this.request.getSession();
        session.setAttribute("user", null);
        return "redirect:/";
    }
}
