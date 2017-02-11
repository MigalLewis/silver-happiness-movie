/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.migal.home.za;

import za.co.migal.home.model.Movie;
import za.co.migal.home.za.mongo.model.MovieEntity;

/**
 *
 * @author migal
 */
public class MovieMapper {
  /**
   * 
   * @param movie
   * @param movieEntity 
   */
  public void mapMovie(Movie movie,MovieEntity movieEntity){
    movie.setId(movieEntity.getId());
    movie.setActors(movieEntity.getActors());
    movie.setAwards(movieEntity.getAwards());
    movie.setCountry(movieEntity.getCountry());
    movie.setDirector(movieEntity.getDirector());
    movie.setGenre(movieEntity.getGenre());
    movie.setImdbID(movieEntity.getImdbID());
    movie.setImdbRating(movieEntity.getImdbRating());
    movie.setImdbVotes(movieEntity.getImdbVotes());
    movie.setLanguage(movieEntity.getLanguage());
    movie.setMetascore(movieEntity.getMetascore());
    movie.setPlot(movieEntity.getPlot());
    movie.setPoster(movieEntity.getPoster());
    movie.setRated(movieEntity.getRated());
    movie.setReleased(movieEntity.getReleased());
    movie.setRuntime(movieEntity.getRuntime());
    movie.setTitle(movieEntity.getTitle());
  }
}
