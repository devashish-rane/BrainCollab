package com.deva.braincollab.MvnController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MainController {	
	
	@RequestMapping("/home")
	public String home(Model model) {
		return "home";
	}
	
}
