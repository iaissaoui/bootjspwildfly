package bootwildfly.main.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

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

		String firstline = "";

//		try {
//			File f = new File("/dsk0/file.txt");
//			FileOutputStream is = new FileOutputStream(f);
//			OutputStreamWriter osw = new OutputStreamWriter(is);
//			Writer w = new BufferedWriter(osw);
//			w.write("Hello World!");
//			w.close();
//		} catch (IOException e) {
//			System.err.println("Problem writing to the file statsTest.txt");
//		}

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

		return "slash";
	}

}