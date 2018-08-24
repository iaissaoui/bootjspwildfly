package bootwildfly;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SpringSecurity extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		// http.authorizeRequests().anyRequest().permitAll().and().csrf().disable();
		// h2 console blank page issue
		// http.headers().frameOptions().disable();
		// alternatively "http.headers().frameOptions().sameOrigin();"
	}

}
