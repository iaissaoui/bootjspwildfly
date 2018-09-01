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

import bootwildfly.main.model.User;
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

		String firstline = "";

		try {

			File f = new File("/dsk0/file.txt");
			BufferedReader br = new BufferedReader(new FileReader(f));
			String line;

			int i = 0;

			while ((line = br.readLine()) != null) {
				if (i == 0) {
					firstline = line;
				}
				System.out.println(line);
				i++;
			}
			br.close();
		} catch (FileNotFoundException e) {
			// File not found
			e.printStackTrace();
		} catch (IOException e) {
			// Error when reading the file
			e.printStackTrace();
		}

		m.addAttribute("firstLine", firstline);

		ur.save(new User(0L, "fn0", "ln0"));
		ur.save(new User(1L, "fn1", "ln1"));
		ur.save(new User(2L, "fn2", "ln2"));

		List<User> lusr = ur.findByLnStartsWithIgnoreCase("l");

		m.addAttribute("User1", lusr.get(0).getLn());

		return "slash";
	}

}