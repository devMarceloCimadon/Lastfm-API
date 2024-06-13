package proj.api.lastfm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class LastfmApplication {

	public static void main(String[] args) {
		SpringApplication.run(LastfmApplication.class, args);
	}

}
