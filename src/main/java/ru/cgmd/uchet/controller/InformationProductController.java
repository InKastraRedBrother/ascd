package ru.cgmd.uchet.controller;

import ru.cgmd.uchet.domain.*;
import ru.cgmd.uchet.repos.InformationProductRepository;
import ru.cgmd.uchet.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.List;

@Controller
public class InformationProductController {

    @Value("${spring.servlet.multipart.location}")
    private String uploadPath;

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
    private InformationProductService informationProductService;

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

    @RequestMapping("/view_informationproduct")
    public String viewAllProducts(@ModelAttribute("informationProduct") InformationProduct informationProduct,
                                  @AuthenticationPrincipal User loggedUser, Model model) {
        List<InformationProduct> listInformationProducts = informationProductService.listAll();
        model.addAttribute("listInformationProducts", listInformationProducts);
        cahe(loggedUser,model );

        return "view_informationproduct";
    }

    @RequestMapping("/add_informationproduct")
    public String showNewInformationProductPage(@ModelAttribute("informationProduct") InformationProduct informationProduct,
                                                @AuthenticationPrincipal User loggedUser, Model model) {

        List<Country> listCountry = countryService.listAll(); //select стран
        model.addAttribute("listCountry", listCountry);

        List<GeographicalObject> listGeographicalObject = geographicalObjectService.listAll(); //select географического объекта
        model.addAttribute("listGeographicalObject", listGeographicalObject);

        List<Language> listLanguage = languageService.listAll(); //select языка
        model.addAttribute("listLanguage", listLanguage);

        List<ProjectOrProgram> listProjectOrProgram = projectOrProgramService.listAll(); //select 4
        model.addAttribute("listProjectOrProgram", listProjectOrProgram);

        List<ObservationDiscipline> listObservationDiscipline = observationDisciplineService.listAll(); //select 5
        model.addAttribute("listObservationDiscipline", listObservationDiscipline);

        List<ObservationParameterGroup> listObservationParameterGroup = observationParameterGroupService.listAll(); //select 6
        model.addAttribute("listObservationParameterGroup", listObservationParameterGroup);

        List<ObservationParameter> listObservationParameter = observationParameterService.listAll(); //select 7
        model.addAttribute("listObservationParameter", listObservationParameter);

        List<ObservationScope> listObservationScope = observationScopeService.listAll(); //select 8
        model.addAttribute("listObservationScope", listObservationScope);

        List<ObservationType> listObservationType = observationTypeService.listAll(); //select 9
        model.addAttribute("listObservationType", listObservationType);

        List<Organization> listOrganization = organizationService.listAll(); //select 10
        model.addAttribute("listOrganization", listOrganization);

        cahe(loggedUser,model);
        return "add_informationproduct";
    }


    @RequestMapping(value= "information_product/download/{id}", method = RequestMethod.GET)
    public
    void downloadFile(HttpServletResponse response, @PathVariable("id") Long idInformationProduct) throws IOException {
        File file = null;

        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        String uploafile = uploadPath + informationProductRepository.getOne(idInformationProduct).getUploadFile();
        file = new File(classloader.getResource(uploafile).getFile());


        if(!file.exists()){
            String errorMessage = "Sorry. The file you are looking for does not exist";
            System.out.println(errorMessage);
            OutputStream outputStream = response.getOutputStream();
            outputStream.write(errorMessage.getBytes(Charset.forName("UTF-8")));
            outputStream.close();
            return;
        }

        String mimeType= URLConnection.guessContentTypeFromName(file.getName());
        if(mimeType==null){
            System.out.println("mimetype is not detectable, will take default");
            mimeType = "application/octet-stream";
        }

        System.out.println("mimetype : "+mimeType);

        response.setContentType(mimeType);

        /* "Content-Disposition : inline" will show viewable types [like images/text/pdf/anything viewable by browser] right on browser
            while others(zip e.g) will be directly downloaded [may provide save as popup, based on your browser setting.]*/
        response.setHeader("Content-Disposition", String.format("inline; filename=\"" + file.getName() +"\""));


        /* "Content-Disposition : attachment" will be directly download, may provide save as popup, based on your browser setting*/
        //response.setHeader("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getName()));

        response.setContentLength((int)file.length());

        InputStream inputStream = new BufferedInputStream(new FileInputStream(file));

        //Copy bytes from source to destination(outputstream in this example), closes both streams.
        FileCopyUtils.copy(inputStream, response.getOutputStream());
    }

    @RequestMapping(value = "add_informationproduct", method = RequestMethod.POST)
    public String saveInformationProduct(@AuthenticationPrincipal User author,
                                         @RequestParam Country country,
                                         @RequestParam Language language,
                                         @RequestParam ObservationDiscipline observationDiscipline,
                                         @RequestParam ProjectOrProgram projectOrProgram,
                                         @RequestParam ObservationType observationType,
                                         @RequestParam ObservationParameter observationParameter,
                                         @RequestParam ObservationParameterGroup observationParameterGroup,
                                         @RequestParam ObservationScope observationScope,
                                         @RequestParam GeographicalObject geographicalObject,
                                         @RequestParam Organization organization,
                                         @RequestParam String inventoryNumber,
                                         @RequestParam String fullnameCdrom,
                                         @RequestParam String abbreviationCdrom,
                                         @RequestParam String dateObservationStart,
                                         @RequestParam String dateObservationEnd,
                                         @RequestParam String briefContent,
                                         @RequestParam String volume,
                                         @RequestParam String receivedDate,
                                         @RequestParam("uploadFile") MultipartFile file) throws IOException {

        InformationProduct informationProduct = new InformationProduct(country, language, observationDiscipline,
                projectOrProgram, observationType, observationParameter,
                observationParameterGroup, observationScope, geographicalObject,
                organization, inventoryNumber, fullnameCdrom, abbreviationCdrom,
                dateObservationStart, dateObservationEnd, briefContent, volume, receivedDate);

        if (file != null && !file.getOriginalFilename().isEmpty()) {
            File uploadDir = new File(String.format("%s%s%s", System.getProperty("user.dir"), File.separatorChar, uploadPath));
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }
            String currentPath = uploadDir.getPath();
            String resultFilename = inventoryNumber + "_" + file.getOriginalFilename();
            file.transferTo(new File(currentPath + "/" + resultFilename));

            informationProduct.setUploadFile(uploadPath + "/" + resultFilename);
        }
        informationProduct.setUser(author);
        Date date = new Date();
        informationProduct.setDateOfEntering(date.toString());
        informationProductService.save(informationProduct);

        return "redirect:/view_informationproduct";
    }
//  \/EDIT\/
    @GetMapping("/information_product/edit/{id}")
    public String showUpdateInformationProduct(@PathVariable("id") Long idInformationProduct,
                                               Model model){

        InformationProduct informationProduct = informationProductService.findByIdInformationProduct(idInformationProduct);

        List<Country> listCountry = countryService.listAll(); //select стран
        model.addAttribute("listCountry", listCountry);

        List<GeographicalObject> listGeographicalObject = geographicalObjectService.listAll(); //select географического объекта
        model.addAttribute("listGeographicalObject", listGeographicalObject);

        List<Language> listLanguage = languageService.listAll(); //select языка
        model.addAttribute("listLanguage", listLanguage);

        List<ProjectOrProgram> listProjectOrProgram = projectOrProgramService.listAll(); //select 4
        model.addAttribute("listProjectOrProgram", listProjectOrProgram);

        List<ObservationDiscipline> listObservationDiscipline = observationDisciplineService.listAll(); //select 5
        model.addAttribute("listObservationDiscipline", listObservationDiscipline);

        List<ObservationParameterGroup> listObservationParameterGroup = observationParameterGroupService.listAll(); //select 6
        model.addAttribute("listObservationParameterGroup", listObservationParameterGroup);

        List<ObservationParameter> listObservationParameter = observationParameterService.listAll(); //select 7
        model.addAttribute("listObservationParameter", listObservationParameter);

        List<ObservationScope> listObservationScope = observationScopeService.listAll(); //select 8
        model.addAttribute("listObservationScope", listObservationScope);

        List<ObservationType> listObservationType = observationTypeService.listAll(); //select 9
        model.addAttribute("listObservationType", listObservationType);

        List<Organization> listOrganization = organizationService.listAll(); //select 10
        model.addAttribute("listOrganization", listOrganization);

        model.addAttribute("informationProduct",informationProduct);

        return "/update_informationproduct";
    }

    @PostMapping("/information_product/update/{id}")
    public String updateInformationProduct(@PathVariable("id") Long idInformationProduct,
                                           @RequestParam Country country,
                                           @RequestParam Language language,
                                           @RequestParam ObservationDiscipline observationDiscipline,
                                           @RequestParam ProjectOrProgram projectOrProgram,
                                           @RequestParam ObservationType observationType,
                                           @RequestParam ObservationParameter observationParameter,
                                           @RequestParam ObservationParameterGroup observationParameterGroup,
                                           @RequestParam ObservationScope observationScope,
                                           @RequestParam GeographicalObject geographicalObject,
                                           @RequestParam Organization organization,
                                           @RequestParam String inventoryNumber,
                                           @RequestParam String fullnameCdrom,
                                           @RequestParam String abbreviationCdrom,
                                           @RequestParam String dateObservationStart,
                                           @RequestParam String dateObservationEnd,
                                           @RequestParam String briefContent,
                                           @RequestParam String volume,
                                           @RequestParam String receivedDate,
                                           @RequestParam("uploadFile") MultipartFile file,
                                           @AuthenticationPrincipal User author) throws IOException {

        InformationProduct informationProduct = new InformationProduct(country, language, observationDiscipline,
                projectOrProgram, observationType, observationParameter,
                observationParameterGroup, observationScope, geographicalObject,
                organization, inventoryNumber, fullnameCdrom, abbreviationCdrom,
                dateObservationStart, dateObservationEnd, briefContent, volume, receivedDate);
        informationProduct.setIdInformationProduct(idInformationProduct);

        if (file != null && !file.getOriginalFilename().isEmpty()) {
            File uploadDir = new File(String.format("%s%s%s", System.getProperty("user.dir"), File.separatorChar, uploadPath));
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }
            String currentPath = uploadDir.getPath();
            String resultFilename = inventoryNumber + "_" + file.getOriginalFilename();
            file.transferTo(new File(currentPath + "/" + resultFilename));

            informationProduct.setUploadFile(uploadPath + "/" + resultFilename);
        }
        informationProduct.setUser(author);
        Date date = new Date();
        informationProduct.setDateOfEntering(date.toString());
        informationProductService.save(informationProduct);
        return "redirect:/view_informationproduct";
    }
///\EDIT/\

//\/DELETE\/
    @GetMapping("information_product/delete/{id}")
    public String deleteUser(@PathVariable("id") Long idInformationProduct, Model model) {
        InformationProduct informationProduct = informationProductService.findByIdInformationProduct(idInformationProduct);
        informationProductService.delete(idInformationProduct);
        return "redirect:/view_informationproduct";
    }
//  /\ DELETE/\

//  \/VIEW ONE\/
@GetMapping("/information_product/view/{id}")
public String showFullInformationProduct(@PathVariable("id") Long idInformationProduct,
                                           Model model){

    InformationProduct informationProduct = informationProductService.findByIdInformationProduct(idInformationProduct);
    model.addAttribute("listInformationProducts", informationProduct);
    return "/full_view_informationproduct";
}
//  /\VIEW ONE/\
}
