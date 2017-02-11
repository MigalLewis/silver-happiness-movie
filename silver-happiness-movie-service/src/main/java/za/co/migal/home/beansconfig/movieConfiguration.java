package za.co.migal.home.beansconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import za.co.migal.home.za.MovieMapper;
import za.co.migal.home.za.beanconfig.OmdbapiUrls;

/**
 * 
 * @author migal
 */
@Configuration
@ComponentScan(basePackages = "za.co.migal.home")
public class movieConfiguration {
  /**
   * 
   * @return 
   */
  @Bean
  public MovieMapper movieMapper() {
    return new MovieMapper();
  }
}
