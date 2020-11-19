package user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import ustb.scce.plugin.zuul.trace.config.EnableZuulTraceConfig;

/**
 * @author fdse
 */
@SpringBootApplication
@EnableEurekaClient
@EnableZuulTraceConfig
public class UserApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }
}
