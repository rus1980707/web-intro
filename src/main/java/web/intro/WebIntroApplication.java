package web.intro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "web.intro")
public class WebIntroApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebIntroApplication.class, args);
	}

}
