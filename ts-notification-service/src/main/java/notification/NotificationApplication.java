package notification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import ustb.scce.plugin.zuul.trace.config.EnableZuulTraceConfig;

/**
 * @author fdse
 */
@SpringBootApplication
@EnableSwagger2
@EnableEurekaClient
@EnableZuulTraceConfig
public class NotificationApplication{
    public static void main(String[] args) {
        SpringApplication.run(NotificationApplication.class, args);
    }
}