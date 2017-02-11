package za.co.migal.home.beanconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 
 * @author migal
 */
@Configuration
@ComponentScan(basePackages = "za.co.migal.home")
public class MovieConfiguration {
  /**
   * 
   * @return 
   */
  @Bean
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }
}
