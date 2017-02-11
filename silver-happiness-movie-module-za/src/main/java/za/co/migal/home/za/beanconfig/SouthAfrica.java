
package za.co.migal.home.za.beanconfig;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
/**
 * 
 * @author migal
 */
public class SouthAfrica implements Condition {

    public static final String COUNTRY_CODE = "ZA";

    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        String countryCode = conditionContext.getEnvironment().getProperty("country.code");
        return COUNTRY_CODE.equals(countryCode);
    }
}
