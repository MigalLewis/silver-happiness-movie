/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.migal.home.za.mongo.model;

import java.util.Map;

/**
 *
 * @author migal
 */
public class OmdbUrlUtil {
  /**
   * 
   * @param url
   * @param params
   * @return 
   */
  public static String getOmdbUrl(String url,Map<String,String> params){
    String newUrl=url;
    for(String paramKey:params.keySet()){
      newUrl=newUrl.replace(paramKey, params.get(paramKey));
    }
    return newUrl;
  }
}
