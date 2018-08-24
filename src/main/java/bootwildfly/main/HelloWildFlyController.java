package bootwildfly;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloWildFlyController {

	@GetMapping("/")
	public String sayHello() {

		return "hello";
	}
}