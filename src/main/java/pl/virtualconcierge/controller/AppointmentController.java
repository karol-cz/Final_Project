package pl.virtualconcierge.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import pl.virtualconcierge.model.Appointment;
import pl.virtualconcierge.model.AppointmentSlot;
import pl.virtualconcierge.model.Company;
import pl.virtualconcierge.model.User;
import pl.virtualconcierge.repository.AppointmentRepository;
import pl.virtualconcierge.repository.CompanyRepository;
import pl.virtualconcierge.repository.UserRepository;

@Controller
@RequestMapping("appointments")
public class AppointmentController {
	
	@Autowired
	private AppointmentRepository appointmentRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CompanyRepository companyRepository;
	
	@ModelAttribute("users")
	public List<User> showAllUsers() {
		return userRepository.findAll();
	}
	
	@ModelAttribute("companies")
	public List<Company> showAllCompanies() {
		return companyRepository.findAll();
	}
	
	@RequestMapping(path = "/add", method = RequestMethod.GET)
	public String showAddappointmentForm(Model model) {
		model.addAttribute("appointment", new Appointment());
		return "appointmentViews/registerForm";
	}
	
	@RequestMapping(path = "/add", method = RequestMethod.POST)
	public String processappointmentForm(Model model, Appointment appointment) {
		appointmentRepository.save(appointment);
		return "redirect:/appointments/list";
	}
	
	@RequestMapping(path = "/list", method = RequestMethod.GET)
	public String showappointment(Model model) {
		model.addAttribute("appointments", appointmentRepository.findAll());
		return "appointmentViews/listView";
	}
	
	@RequestMapping(path = "/makeAppointment", method = RequestMethod.GET)
	public String showMakeappointmentForm(
			Model model,
			@RequestParam("userId") Long userId,
			@RequestParam("companyId") Long companyId) {
		
		model.addAttribute("userId", userId);
		model.addAttribute("companyId", companyId);
		model.addAttribute("appointment", new Appointment());
		model.addAttribute("company", companyRepository.findById(companyId));
		return "appointmentViews/newAppointment";
	}
	
	@RequestMapping(path = "/retriveHour", method = RequestMethod.GET)
	public String showMakeappointmentForm(
			Model model,
			@RequestParam("companyId") Long id,
			@RequestParam("date") @DateTimeFormat(pattern="dd-MM-yyyy") LocalDate date) {
		model.addAttribute("appointment", new Appointment());
		List<Appointment> appointments = appointmentRepository.findByCompanyIdAndDate(id, date);
		List<LocalTime> hours = appointments.stream()
				.map(Appointment::getTime)
				.collect(Collectors.toList());
		
		List<AppointmentSlot> slots = new ArrayList<>();
		
		LocalTime end = LocalTime.of(16, 0);
		for(LocalTime time = LocalTime.of(8, 0); time.isBefore(end); time = time.plusHours(1))
		{
			boolean taken = hours.contains(time);
			slots.add(new AppointmentSlot(time, taken));
		}
		
		model.addAttribute("slots", slots);
		
		return "appointmentViews/hourList";
	}
	
	@RequestMapping(path = "/makeAppointment", method = RequestMethod.POST)
	public String processMakeAppointmentForm(
			Model model,
			Appointment appointment) {
		appointmentRepository.save(appointment);
		model.addAttribute("appointments", appointmentRepository.findByUserId(appointment.getUser().getId()));
		return "appointmentViews/myAppointments";
	}
	
	@RequestMapping(path = "/showAppointmentsCompany", method = RequestMethod.GET)
	public String showMyAppointmentsCompany(Model model, @SessionAttribute Long companyId) {
		//Long id = request.getSession().getAttribute("userId", userToCheck.getId());
		model.addAttribute("appointments", appointmentRepository.findByCompanyId(companyId));
		return "appointmentViews/myAppointmentsCompany";
	}
	
	@RequestMapping(path = "/showAppointments", method = RequestMethod.GET)
	public String showMyAppointments(Model model, @SessionAttribute Long userId) {
		//Long id = request.getSession().getAttribute("userId", userToCheck.getId());
		model.addAttribute("appointments", appointmentRepository.findByUserId(userId));
		return "appointmentViews/myAppointments";
	}
}
