package it.sky.dp.samplespringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"it.sky.dp.samplespringboot"})
public class SampleSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SampleSpringBootApplication.class, args);
    }
}
