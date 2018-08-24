package bootwildfly.main;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloWildFlyController {

	@Value("${spring.application.name}")
	private String appName;

	@GetMapping("/")
	public String sayHello() {

		return "hello";
	}
}