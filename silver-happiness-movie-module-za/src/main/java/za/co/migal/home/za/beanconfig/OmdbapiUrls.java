/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.migal.home.za.beanconfig;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 *
 * @author migal
 */
@Component
@ConfigurationProperties("omdb.url.rest")
@Data
public class OmdbapiUrls {

  private String imdb;
}
