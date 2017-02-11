/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.migal.home;

import za.co.migal.home.exceptions.MovieException;
import za.co.migal.home.model.Movie;
/**
 * 
 * @author migal
 */
public interface MovieModule {
  /**
   * 
   * @return 
   */
  public String sayHello();
  /**
   * 
   * @param id
   * @return
   * @throws MovieException 
   */
  public Movie findMovieById(long id) throws MovieException;
  /**
   * 
   * @param imdbId
   * @return
   * @throws MovieException 
   */
  public Movie findMovieByImdbId(String imdbId) throws MovieException;
}
