/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.migal.home.za.mongo.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import za.co.migal.home.za.mongo.model.MovieEntity;

/**
 *
 * @author migal
 */
public interface MovieRepository extends MongoRepository<MovieEntity, String>{
  /**
   * 
   * @param id
   * @return 
   */
  public MovieEntity findById(long id);
  /**
   * 
   * @param imdbID
   * @return 
   */
  public MovieEntity findByImdbID(String imdbID);
  /**
   * 
   * @param title
   * @return 
   */
  public List<MovieEntity> findByTitleContainingIgnoreCase(String title);
}
