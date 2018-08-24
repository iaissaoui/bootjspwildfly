package bootwildfly;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWildFlyController {

	@RequestMapping("/")
	public String sayHello() {

		return "hello";
	}
}