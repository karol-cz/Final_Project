package pl.virtualconcierge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.virtualconcierge.model.City;
import pl.virtualconcierge.repository.CityRepository;

@Controller
@RequestMapping("cities")
public class CityController {

	@Autowired
	private CityRepository cityRepository;
	
	@RequestMapping(path = "/add", method = RequestMethod.GET)
	public String showAddcityForm(Model model) {
		model.addAttribute("city", new City());
		return "cityViews/registerForm";
	}
	
	@RequestMapping(path = "/add", method = RequestMethod.POST)
	public String processcityForm(Model model, City city) {
		cityRepository.save(city);
		return "redirect:/cities/list";
	}
	
	@RequestMapping(path = "/list", method = RequestMethod.GET)
	public String showcity(Model model) {
		model.addAttribute("cities", cityRepository.findAll());
		return "cityViews/listView";
	}
}
