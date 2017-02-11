package za.co.migal.home.beanconfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * 
 * @author migal
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

  @Value("${swagger.base}")
  private String base;
  @Value("${swagger.api.info.title}")
  private String title;
  @Value("${swagger.api.info.description}")
  private String description;
  @Value("${swagger.api.info.version}")
  private String version;
  @Value("${swagger.api.info.termsofservice.url}")
  private String termsOfServiceUrl;
  @Value("${swagger.api.info.contact.name}")
  private String contactName;
  @Value("${swagger.api.info.contact.url}")
  private String contactUrl;
  @Value("${swagger.api.info.contact.email}")
  private String contactEmail;

  /**
   * 
   * @return 
   */
  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.basePackage(base))
            .paths(PathSelectors.any())
            .build()
            .apiInfo(new ApiInfo(title,
                    description,
                    version,
                    termsOfServiceUrl,
                    new Contact(contactName, contactUrl, contactEmail), 
                    null,
                    null));
  }

}
