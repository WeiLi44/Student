package sg.edu.iss.club.student.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.edu.iss.club.student.model.User;

@Controller
@RequestMapping("/main")
public class MainController {

	@RequestMapping("/login")
	public String getLoginPage(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "login";
	}

	@RequestMapping("/authenticate")
	public String authenticate(@ModelAttribute("user") User user, HttpSession session) {
		if (user.getUsername().equalsIgnoreCase("dilbert")) {
			session.setAttribute("uss", user);
			return "home";
		}
		else
			return "index";
	}

}
