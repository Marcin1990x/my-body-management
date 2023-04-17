package pl.koneckimarcin.mybodymanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class MyBodyManagementApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(MyBodyManagementApplication.class, args);
	}

}
