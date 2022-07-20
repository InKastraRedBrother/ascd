package ru.cgmd.uchet.controller;

import ru.cgmd.uchet.domain.*;
import ru.cgmd.uchet.repos.InformationProductRepository;
import ru.cgmd.uchet.repos.UserRepository;
import ru.cgmd.uchet.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private CountryService countryService;

    @Autowired
    private GeographicalObjectService geographicalObjectService;

    @Autowired
    private LanguageService languageService;

    @Autowired
    private ProjectOrProgramService projectOrProgramService;

    @Autowired
    private ObservationDisciplineService observationDisciplineService;

    @Autowired
    private ObservationParameterGroupService observationParameterGroupService;

    @Autowired
    private ObservationParameterService observationParameterService;

    @Autowired
    private ObservationScopeService observationScopeService;

    @Autowired
    private ObservationTypeService observationTypeService;

    @Autowired
    private OrganizationService organizationService;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private InformationProductRepository informationProductRepository;

    public String cahe( @AuthenticationPrincipal User loggedUser, Model model)
    {
        if (loggedUser != null) {
            model.addAttribute("loggedUser", loggedUser);
        }
        else{
            model.addAttribute("message", "Вы не авторизованы!");
        }
        return null;
    }


    @GetMapping("/main")
    public String viewMainPage(@AuthenticationPrincipal User loggedUser,
                               Model model){
        cahe(loggedUser, model);
        return "main";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String viewLoginPage(@AuthenticationPrincipal User loggedUser,
                               Model model){

        if (loggedUser != null) {
            model.addAttribute("loggedUser", loggedUser);
            model.addAttribute("message", "Вы уже авторизованы!");
        }
        else{
            model.addAttribute("message", "Авторизуйтесь!");
        }
        return("login");
    }


//  \/------------------------ORGANIZATION------------------------\/ ИДЕЛА V 1.4 ORIGINAL
    @RequestMapping("/view_organization")
    public String viewAllOrganization(@AuthenticationPrincipal User loggedUser, Model model) {
        List<Organization> listOrganization = organizationService.listAll();
        model.addAttribute("listOrganization", listOrganization);
        cahe(loggedUser,model);
        return "view_organization";
    }
    @RequestMapping("/add_organization")
    public String showNewOrganizationPage(Model model) {
        List<Country> listCountry = countryService.listAll(); //select стран
        model.addAttribute("listCountry", listCountry);

        Organization organization = new Organization();
        model.addAttribute("organization", organization);
        return "add_organization";
    }

    @RequestMapping(value = "add_organization", method = RequestMethod.POST)
    public String saveOrganization(@ModelAttribute("organization") Organization organization) {
        organizationService.save(organization);
        return "redirect:/view_organization";
    }
//  /\------------------------ORGANIZATION------------------------/\

//  \/------------------------COUNTRY------------------------\/ ИДЕЛА V 1.4
    @RequestMapping("/view_country")
    public String viewAllCountry(@AuthenticationPrincipal User loggedUser, Model model) {
        List<Country> listCountry = countryService.listAll();
        model.addAttribute("listCountry", listCountry);
        cahe(loggedUser,model);
        return "view_country";
    }
    @RequestMapping("/add_country")
    public String showNewCountryPage(Model model) {
        Country country = new Country();
        model.addAttribute("country", country);
        return "add_country";
    }

    @RequestMapping(value = "add_country", method = RequestMethod.POST)
    public String saveCountry(@ModelAttribute("country") Country country) {
        countryService.save(country);
        return "redirect:/view_country";
    }
//  /\------------------------COUNTRY------------------------/\

//  \/------------------------LANGUAGE------------------------\/ ИДЕЛА V 1.4
    @RequestMapping("/view_language")
    public String viewAllLanguage(@AuthenticationPrincipal User loggedUser, Model model) {
        List<Language> listLanguage = languageService.listAll();
        model.addAttribute("listLanguage", listLanguage);
        cahe(loggedUser,model);
        return "view_language";
    }

    @RequestMapping("/add_language")
    public String showNewLanguagePage(Model model) {
        Language language = new Language();
        model.addAttribute("language", language);
        return "add_language";
    }

    @RequestMapping(value = "add_language", method = RequestMethod.POST)
    public String saveLanguage(@ModelAttribute("language") Language language) {
        languageService.save(language);
        return "redirect:/view_language";
    }
//  /\------------------------LANGUAGE------------------------/\

//  \/------------------------GEOGRAPHICALOBJECT------------------------\/ ИДЕЛА V 1.4
    @RequestMapping("/view_geographicalobject")
    public String viewAllGeographicalObject(@AuthenticationPrincipal User loggedUser, Model model) {
        List<GeographicalObject> listGeographicalObject = geographicalObjectService.listAll();
        model.addAttribute("listGeographicalObject", listGeographicalObject);
        cahe(loggedUser,model);
        return "view_geographicalobject";
    }

    @RequestMapping("/add_geographicalobject")
    public String showNewGeographicalObjectPage(Model model) {
        GeographicalObject geographicalObject = new GeographicalObject();
        model.addAttribute("geographicalObject", geographicalObject);
        return "add_geographicalobject";
    }

    @RequestMapping(value = "add_geographicalobject", method = RequestMethod.POST)
    public String saveGeographicalObject(@ModelAttribute("geographicalObject") GeographicalObject geographicalObject) {
        geographicalObjectService.save(geographicalObject);
        return "redirect:/view_geographicalobject";
    }
//  /\------------------------GEOGRAPHICALOBJECT------------------------/\


//  \/------------------------PROJECTORPROGRAM------------------------\/ ИДЕЛА V 1.4
    @RequestMapping("/view_projectorprogram")
    public String viewAllProjectOrProgram(@AuthenticationPrincipal User loggedUser, Model model) {
        List<ProjectOrProgram> listProjectOrProgram = projectOrProgramService.listAll();
        model.addAttribute("listProjectOrProgram", listProjectOrProgram);
        cahe(loggedUser,model);
        return "view_projectorprogram";
    }

    @RequestMapping("/add_projectorprogram")
    public String showNewProjectOrProgramPage(Model model) {
        ProjectOrProgram projectOrProgram = new ProjectOrProgram();
        model.addAttribute("projectOrProgram", projectOrProgram);
        return "add_projectorprogram";
    }

    @RequestMapping(value = "add_projectorprogram", method = RequestMethod.POST)
    public String saveProjectOrProgram(@ModelAttribute("projectOrProgram") ProjectOrProgram projectOrProgram) {
        projectOrProgramService.save(projectOrProgram);
        return "redirect:/view_projectorprogram";
    }
//  /\------------------------PROJECTORPROGRAM------------------------/\

//  \/------------------------OBSEVATIONDISCIPLINE------------------------\/ ИДЕЛА V 1.4
    @RequestMapping("/view_observationdiscipline")
    public String viewAllObservationDiscipline(@AuthenticationPrincipal User loggedUser, Model model) {
        List<ObservationDiscipline> listObservationDiscipline = observationDisciplineService.listAll();
        model.addAttribute("listObservationDiscipline", listObservationDiscipline);
        cahe(loggedUser,model);
        return "view_observationdiscipline";
    }

    @RequestMapping("/add_observationdiscipline")
    public String showNewObservationDisciplinePage(Model model) {
        ObservationDiscipline observationDiscipline = new ObservationDiscipline();
        model.addAttribute("observationDiscipline", observationDiscipline);
        return "add_observationdiscipline";
    }

    @RequestMapping(value = "add_observationdiscipline", method = RequestMethod.POST)
    public String saveObservationDiscipline(@ModelAttribute("observationDiscipline") ObservationDiscipline observationDiscipline) {
        observationDisciplineService.save(observationDiscipline);
        return "redirect:/view_observationdiscipline";
    }
//  /\------------------------OBSEVATIONDISCIPLINE------------------------/\

    //  \/------------------------OBSEVATIONPARAMETER------------------------\/ ИДЕЛА V 1.4
    @RequestMapping("/view_observationparameter")
    public String viewAllObservationParameter(@AuthenticationPrincipal User loggedUser, Model model) {
        List<ObservationParameter> listObservationParameter = observationParameterService.listAll();
        model.addAttribute("listObservationParameter", listObservationParameter);
        cahe(loggedUser,model);
        return "view_observationparameter";
    }

    @RequestMapping("/add_observationparameter")
    public String showNewObservationParameterPage(Model model) {
        List<ObservationParameterGroup> listObservationParameterGroup = observationParameterGroupService.listAll(); //select стран
        model.addAttribute("listObservationParameterGroup", listObservationParameterGroup);
        ObservationParameter observationParameter = new ObservationParameter();
        model.addAttribute("observationParameter", observationParameter);
        return "add_observationparameter";
    }

    @RequestMapping(value = "add_observationparameter", method = RequestMethod.POST)
    public String saveObservationParameter(@ModelAttribute("observationParameter") ObservationParameter observationParameter) {
        observationParameterService.save(observationParameter);
        return "redirect:/view_observationparameter";
    }
//  /\------------------------OBSEVATIONPARAMETER------------------------/\


    //  \/------------------------OBSEVATIONPARAMETERGROUP------------------------\/ ИДЕЛА V 1.4
    @RequestMapping("/view_observationparametergroup")
    public String viewAllObservationParameterGroup(@AuthenticationPrincipal User loggedUser, Model model) {
        List<ObservationParameterGroup> listObservationParameterGroup = observationParameterGroupService.listAll();
        model.addAttribute("listObservationParameterGroup", listObservationParameterGroup);
        cahe(loggedUser,model);
        return "view_observationparametergroup";
    }

    @RequestMapping("/add_observationparametergroup")
    public String showNewObservationParameterGroupPage(Model model) {
        ObservationParameterGroup observationParameterGroup = new ObservationParameterGroup();
        model.addAttribute("observationParameterGroup", observationParameterGroup);
        return "add_observationparametergroup";
    }

    @RequestMapping(value = "add_observationparametergroup", method = RequestMethod.POST)
    public String saveObservationParameterGroup(@ModelAttribute("observationParameterGroup") ObservationParameterGroup observationParameterGroup) {
        observationParameterGroupService.save(observationParameterGroup);
        return "redirect:/view_observationparametergroup";
    }
//  /\------------------------OBSEVATIONPARAMETERGROUP------------------------/\


//  \/------------------------OBSERVATIONSCOPE------------------------\/ ИДЕЛА V 1.4
    @RequestMapping("/view_observationscope")
    public String viewAllObservationScope(@AuthenticationPrincipal User loggedUser, Model model) {
        List<ObservationScope> listObservationScope = observationScopeService.listAll();
        model.addAttribute("listObservationScope", listObservationScope);
        cahe(loggedUser,model);
        return "view_observationscope";
    }

    @RequestMapping("/add_observationscope")
    public String showNewObservationScopePage(Model model) {
        ObservationScope observationScope = new ObservationScope();
        model.addAttribute("observationScope", observationScope);
        return "add_observationscope";
    }

    @RequestMapping(value = "add_observationscope", method = RequestMethod.POST)
    public String saveObservationScope(@ModelAttribute("observationScope") ObservationScope observationScope) {
        observationScopeService.save(observationScope);
        return "redirect:/view_observationscope";
    }
//  /\------------------------OBSERVATIONSCOPE------------------------/\

    //  \/------------------------OBSERVATIONTYPE------------------------\/ ИДЕЛА V 1.4
    @RequestMapping("/view_observationtype")
    public String viewAllObservationType(@AuthenticationPrincipal User loggedUser, Model model) {
        List<ObservationType> listObservationType = observationTypeService.listAll();
        model.addAttribute("listObservationType", listObservationType);
        cahe(loggedUser,model);
        return "view_observationtype";
    }

    @RequestMapping("/add_observationtype")
    public String showNewObservationTypePage(Model model) {
        ObservationType observationType = new ObservationType();
        model.addAttribute("observationType", observationType);
        return "add_observationtype";
    }

    @RequestMapping(value = "add_observationtype", method = RequestMethod.POST)
    public String saveObservationType(@ModelAttribute("observationType") ObservationType observationType) {
        observationTypeService.save(observationType);
        return "redirect:/view_observationtype";
    }
//  /\------------------------OBSERVATIONTYPE------------------------/\

}