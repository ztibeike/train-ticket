package ustb.scce.microservice.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableEurekaClient
@EnableZuulProxy
@SpringBootApplication
public class ZuulBasicApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulBasicApplication.class, args);
    }

}
