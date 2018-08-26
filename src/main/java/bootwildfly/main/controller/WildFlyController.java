package bootwildfly.main.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WildFlyController {

	@Value("${spring.application.name}")
	private String appName;

	@GetMapping("/changelog")
	public String changelog(Model m) {

		m.addAttribute("appName", appName);
		return "changelog";
	}

	@GetMapping("/")
	public String home(Model m) {

		m.addAttribute("appName", appName);
		return "slash";
	}

}