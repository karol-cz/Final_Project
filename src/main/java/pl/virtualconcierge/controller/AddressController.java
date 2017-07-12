package pl.virtualconcierge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.virtualconcierge.model.Address;
import pl.virtualconcierge.model.City;
import pl.virtualconcierge.repository.AddressRepository;
import pl.virtualconcierge.repository.CityRepository;

@Controller
@RequestMapping("addresses")
public class AddressController {
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private CityRepository cityRepository;
	
	@ModelAttribute("cities")
	public List<City> showAllCities() {
		return cityRepository.findAll();
	}
	
	@RequestMapping(path = "/add", method = RequestMethod.GET)
	public String showAddaddressForm(Model model) {
		model.addAttribute("address", new Address());
		return "addressViews/registerForm";
	}
	
	@RequestMapping(path = "/add", method = RequestMethod.POST)
	public String processaddressForm(Model model, Address address) {
		addressRepository.save(address);
		return "redirect:/addresses/list";
	}
	
	@RequestMapping(path = "/list", method = RequestMethod.GET)
	public String showaddress(Model model) {
		model.addAttribute("addresses", addressRepository.findAll());
		return "addressViews/listView";
	}
}
