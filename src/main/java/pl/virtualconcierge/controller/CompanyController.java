package pl.virtualconcierge.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import pl.virtualconcierge.model.Address;
import pl.virtualconcierge.model.City;
import pl.virtualconcierge.model.Company;
import pl.virtualconcierge.model.ServiceType;
import pl.virtualconcierge.repository.AddressRepository;
import pl.virtualconcierge.repository.CityRepository;
import pl.virtualconcierge.repository.CompanyRepository;
import pl.virtualconcierge.repository.ServiceTypeRepository;

@Controller
@RequestMapping("companies")
public class CompanyController {

	@Autowired
	private CompanyRepository companyRepository;

	@Autowired
	private ServiceTypeRepository serviceTypeRepository;

	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private CityRepository cityRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@ModelAttribute("serviceTypes")
	public List<ServiceType> getAllServiceTypes() {
		return serviceTypeRepository.findAll();
	}

	@ModelAttribute("addresses")
	public List<Address> getAllAddresses() {
		return addressRepository.findAll();
	}
	
	@ModelAttribute("cities")
	public List<City> getAllCities() {
		return cityRepository.findAll();
	}

	@RequestMapping(path = "/add", method = RequestMethod.GET)
	public String showAddCompanyForm(Model model) {
		model.addAttribute("company", new Company());
		return "companyViews/registerForm";
	}

	@RequestMapping(path = "/add", method = RequestMethod.POST)
	public String processCompanyForm(Model model,  Company company) {
		company.setPassword(passwordEncoder.encode(company.getPassword()));
		companyRepository.save(company);
		return "redirect:/companies/login";
	}

	@RequestMapping(path = "/list", method = RequestMethod.GET)
	public String showCompanies(Model model) {
		model.addAttribute("companies", companyRepository.findAll());
		return "companyViews/listView";
	}
	
	@RequestMapping(path = "/details", method = RequestMethod.GET)
	public String showCompanyDetails(Model model, @SessionAttribute Long companyId) {
		model.addAttribute("company", companyRepository.findById(companyId));
		return "companyViews/profilDetails";
	}

	
	@RequestMapping(path = "/login", method = RequestMethod.GET)
	public String showLoginForm(Model model) {
		model.addAttribute("company", new Company());
		return "companyViews/loginForm";
	}

	@RequestMapping(path = "/login", method = RequestMethod.POST)
	//@ResponseBody
	public String loginUser(@ModelAttribute Company company, Model model, HttpServletRequest request) {
		Company companyToCheck = companyRepository.findByEmail(company.getEmail());

		if (companyToCheck != null && passwordEncoder.matches(company.getPassword(), companyToCheck.getPassword())) {
			request.getSession().setAttribute("companyId", companyToCheck.getId());
			request.getSession().setAttribute("companyName", companyToCheck.getName());			
			//return "success";
			return "redirect:../appointments/showAppointmentsCompany";
		} else {
			request.getSession().removeAttribute("companyId");
			return "invalid login or password";
		}
	}

	@RequestMapping(path = "/logout", method = RequestMethod.GET)
	public String logOutCompany(HttpServletRequest request) {
		request.getSession().removeAttribute("companyId");
		request.getSession().removeAttribute("companyName");
		return "redirect:../home";
	}
	
	
	

}
