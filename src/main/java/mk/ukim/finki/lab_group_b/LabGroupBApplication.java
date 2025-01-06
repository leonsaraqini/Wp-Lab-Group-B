package mk.ukim.finki.lab_group_b;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class LabGroupBApplication {

    public static void main(String[] args) {
        SpringApplication.run(LabGroupBApplication.class, args);
    }

}
