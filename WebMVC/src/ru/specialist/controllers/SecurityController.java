package ru.specialist.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ru.specialist.DAO.Course;
import ru.specialist.DAO.User;
import ru.specialist.DAO.UserRepository;
import ru.specialist.model.RegFormVM;

@Controller
@RequestMapping("/security")
public class SecurityController {
	
	private UserRepository userRepository;
	@Autowired
	public void setContactService(UserRepository userRepository) {
		this.userRepository= userRepository;
	}
	
	@RequestMapping("/loginfail")
	public String loginFail(Model uiModel) {
		System.out.println("login failed");
		return "courses/list";
	}
	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String regForm(Model uiModel) {
		return "security/registration";
	}
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String regSave(RegFormVM r, BindingResult bindingResult,
				Model uiModel) {
		if (bindingResult.hasErrors() || 
				(!r.getPassword().equals(r.getConfirm()))) {
			uiModel.addAttribute("r", r);
			return "security/registration";
		}
		userRepository.save(new User(r.getUsername(), r.getPassword()));
		return "redirect:/courses/";
	}

}
