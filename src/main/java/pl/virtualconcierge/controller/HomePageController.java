package pl.virtualconcierge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.virtualconcierge.model.City;
import pl.virtualconcierge.model.ServiceType;
import pl.virtualconcierge.repository.CityRepository;
import pl.virtualconcierge.repository.CompanyRepository;
import pl.virtualconcierge.repository.ServiceTypeRepository;

@Controller
@RequestMapping("home")
public class HomePageController {
	
	@Autowired
	private CompanyRepository companyRepository;
	

//	@RequestMapping(path = "/add", method = RequestMethod.GET)
//	public String showAddCompanyForm(Model model) {
//		model.addAttribute("company", new Company());
//		return "companyRegisterForm";
//	}
//	
//	@RequestMapping(path = "/add", method = RequestMethod.POST)
//	public String processCompanyForm(Model model, Company company) {
//		companyRepository.save(company);
//		return "redirect:/companies/list";
//	}
//	
//	@RequestMapping(path = "/list", method = RequestMethod.GET)
//	public String showCompanies(Model model) {
//		model.addAttribute("companies", companyRepository.findAll());
//		return "companiesList";
//	}
	
	
	@Autowired
	private ServiceTypeRepository serviceTypeRepository;
	
	@Autowired
	private CityRepository cityRepository;

	@ModelAttribute("serviceTypes")
	public List<ServiceType> getAllServiceTypes() {
		return serviceTypeRepository.findAll();
	}
	
	@ModelAttribute("cities")
	public List<City> getAllCities() {
		return cityRepository.findAll();
	}
	
	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String showHomePage(Model model) {
		return showHomePageProper(model);
	}
	
	
	@RequestMapping(method = RequestMethod.GET)
	public String showHomePageProper(Model model) {
		model.addAttribute("companies", companyRepository.findAll());
		return "home";
	}
	
	@RequestMapping(path = "/list", method = RequestMethod.GET)
	public String showList(
			@RequestParam("serviceId") Long serviceId,
			@RequestParam("cityId") Long cityId,
			Model model) {
		model.addAttribute("companies", companyRepository.findCompaniesByCityAndService(serviceId, cityId));
		return "homeList";
	}
	
	@RequestMapping(path = "/getCities", method = RequestMethod.GET)
	@ResponseBody
	public List<City> getCities(@RequestParam (name="serviceId") Long id) {
		return companyRepository.findCitiesByService(id);
	}
	
}
