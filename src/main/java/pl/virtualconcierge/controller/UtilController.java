package pl.virtualconcierge.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("utils")
public class UtilController {

	


	@RequestMapping(path = "/loginChoose", method = RequestMethod.GET)
	public String loginChose() {
		return "utilViews/loginChoose";
	}
	
	

}
