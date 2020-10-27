package ustb.scce.microservice.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableCaching
@EnableEurekaClient
@EnableZuulProxy
@SpringBootApplication
public class ZuulTrainApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulTrainApplication.class, args);
    }

}
