package com.trainticket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import ustb.scce.plugin.zuul.trace.config.EnableZuulTraceConfig;

/**
 * @author fdse
 */
@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true)
@EnableAsync
@IntegrationComponentScan
@EnableSwagger2
@EnableEurekaClient
@EnableZuulTraceConfig
public class PaymentApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymentApplication.class, args);
	}
}
