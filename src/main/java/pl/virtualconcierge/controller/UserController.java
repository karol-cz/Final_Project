package pl.virtualconcierge.controller;

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

import pl.virtualconcierge.model.User;
import pl.virtualconcierge.repository.UserRepository;

@Controller
@RequestMapping("users")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@RequestMapping(path = "/add", method = RequestMethod.GET)
	public String showAddUserForm(Model model) {
		model.addAttribute("user", new User());
		return "userViews/registerForm";
	}

	@RequestMapping(path = "/add", method = RequestMethod.POST)
	public String processUserForm(Model model, User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepository.save(user);
		return "redirect:/users/list";
	}

	@RequestMapping(path = "/list", method = RequestMethod.GET)
	public String showUsers(Model model) {
		model.addAttribute("users", userRepository.findAll());
		return "redirect:../users/login";
	}
	
	@RequestMapping(path = "/details", method = RequestMethod.GET)
	public String showUserDetails(Model model, @SessionAttribute Long userId) {
		model.addAttribute("user", userRepository.findById(userId));
		return "userViews/profilDetails";
	}

	@RequestMapping(path = "/login", method = RequestMethod.GET)
	public String showLoginForm(Model model) {
		model.addAttribute("user", new User());
		return "userViews/loginForm";
	}

	@RequestMapping(path = "/login", method = RequestMethod.POST)
	// @ResponseBody
	public String loginUser(@ModelAttribute User user, Model model, HttpServletRequest request) {
		User userToCheck = userRepository.findByEmail(user.getEmail());

		if (userToCheck != null && passwordEncoder.matches(user.getPassword(), userToCheck.getPassword())) {
			request.getSession().setAttribute("userId", userToCheck.getId());
			request.getSession().setAttribute("userName", userToCheck.getFirstName());			
			// return "success";
			return "redirect:../home";
		} else {
			request.getSession().removeAttribute("userId");
			return "invalid login or password";
		}
	}

	@RequestMapping(path = "/logout", method = RequestMethod.GET)
	public String logOutUser(HttpServletRequest request) {
		request.getSession().removeAttribute("userId");
		request.getSession().removeAttribute("userName");
		return "redirect:../home";
	}
	
	

}
