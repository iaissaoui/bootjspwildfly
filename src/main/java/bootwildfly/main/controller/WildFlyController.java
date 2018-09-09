package bootwildfly.main.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import bootwildfly.main.model.AppUser;
import bootwildfly.main.repo.UserRepository;

@Controller
public class WildFlyController {

	@Autowired
	UserRepository ur;

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
 
		ur.save(new AppUser(0L, "fn0", "ln0"));
		ur.save(new AppUser(1L, "fn1", "ln1")); 
		ur.save(new AppUser(2L, "fn2", "ln2"));
 
		List<AppUser> lusr = ur.findByLnStartsWithIgnoreCase("l");

		m.addAttribute("User1", lusr.get(0).getLn());

		return "slash";
	}

}