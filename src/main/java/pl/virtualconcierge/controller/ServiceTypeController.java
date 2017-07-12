package pl.virtualconcierge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.virtualconcierge.model.ServiceType;
import pl.virtualconcierge.model.User;
import pl.virtualconcierge.repository.ServiceTypeRepository;

@Controller
@RequestMapping("serviceTypes")
public class ServiceTypeController {
	
	@Autowired
	private ServiceTypeRepository serviceTypeRepository;
	
	@RequestMapping(path = "/add", method = RequestMethod.GET)
	public String showAddServiceTypeForm(Model model) {
		model.addAttribute("serviceType", new ServiceType());
		return "serviceTypeViews/registerForm";
	}
	
	@RequestMapping(path = "/add", method = RequestMethod.POST)
	public String processServiceTypeForm(Model model, ServiceType serviceType) {
		serviceTypeRepository.save(serviceType);
		return "redirect:/serviceTypes/list";
	}
	
	@RequestMapping(path = "/list", method = RequestMethod.GET)
	public String showServiceType(Model model) {
		model.addAttribute("serviceTypes", serviceTypeRepository.findAll());
		return "serviceTypeViews/listView";
	}
}
