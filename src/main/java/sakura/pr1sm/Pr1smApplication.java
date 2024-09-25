package sakura.pr1sm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("sakura.pr1sm")
public class Pr1smApplication {

    public static void main(String[] args) {
        SpringApplication.run(Pr1smApplication.class, args);
    }

}
