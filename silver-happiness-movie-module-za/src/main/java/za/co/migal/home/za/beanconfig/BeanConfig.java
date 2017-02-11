package za.co.migal.home.za.beanconfig;

import lombok.extern.log4j.Log4j;
import org.springframework.context.annotation.*;
import za.co.migal.home.za.MovieMapper;

/**
 *
 * @author migal
 */
@Configuration
@ComponentScan(basePackages = "za.co.migal.home")
@Conditional(SouthAfrica.class)
@Log4j
public class BeanConfig {
  /**
   * 
   * @return 
   */
  @Bean
  public MovieMapper movieMapper() {
    return new MovieMapper();
  }
}
