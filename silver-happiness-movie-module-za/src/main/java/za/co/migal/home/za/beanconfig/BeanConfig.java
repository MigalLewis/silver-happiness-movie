package za.co.migal.home.za.beanconfig;

import lombok.extern.log4j.Log4j;
import org.springframework.context.annotation.*;

/**
 *
 * @author migal
 */
@Configuration
@ComponentScan(basePackages = "za.co.migal.home")
@Conditional(SouthAfrica.class)
@Log4j
public class BeanConfig {

}
