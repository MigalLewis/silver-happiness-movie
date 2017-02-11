package za.co.migal.home.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.ApiOperation;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import za.co.migal.home.exceptions.MovieException;
import za.co.migal.home.model.Movie;
import za.co.migal.home.MovieModule;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author migal
 */
@RestController(value = "/rest/movie")
public class MovieController {

  @Autowired
  private MovieModule module;

  /**
   * 
   * @return 
   */
  @RequestMapping(method = RequestMethod.GET, value = "/hello")
  @ApiOperation(value = "Says hello.")
  public String hello() {
    return module.sayHello();
  }

  /**
   * 
   * @param imdbId
   * @return 
   */
  @RequestMapping(method = RequestMethod.GET, value = "/findMovieByImdbId/{imdbId}")
  @ApiOperation(value = "Finds movie using ImdbId")
  @ResponseBody
  public Movie findMovieByImdbId(@PathVariable String imdbId) {
    try {
      return module.findMovieByImdbId(imdbId);
    } catch (MovieException ex) {
      Logger.getLogger(MovieController.class.getName()).log(Level.SEVERE, null, ex);
      Movie movie = new Movie();
      movie.setResponse(false);
      return movie;
    }
  }
  
  /**
   * 
   * @param id
   * @return 
   */
  @RequestMapping(method = RequestMethod.GET, value = "/findMovieById/{id}")
  @ApiOperation(value = "Finds movie using Id")
  @ResponseBody
  public Movie findMovieById(@PathVariable long id) {

    try {
      return module.findMovieById(id);
    } catch (MovieException ex) {
      Logger.getLogger(MovieController.class.getName()).log(Level.SEVERE, null, ex);
      Movie movie = new Movie();
      movie.setResponse(false);
      return movie;
    }
  }

  
}
