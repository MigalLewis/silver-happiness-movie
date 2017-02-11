package za.co.migal.home.za;

import java.util.HashMap;
import java.util.Map;
import za.co.migal.home.za.beanconfig.OmdbapiUrls;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import za.co.migal.home.movieModule;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import za.co.migal.home.exceptions.MovieException;
import za.co.migal.home.model.Movie;
import za.co.migal.home.za.mongo.model.MovieEntity;
import za.co.migal.home.za.mongo.model.OmdbUrlUtil;
import za.co.migal.home.za.mongo.repository.MovieRepository;

/**
 * 
 * @author migal
 */
@Component
@Log4j
public class movieModuleImpl implements movieModule {

  @Autowired
  private OmdbapiUrls omdbapiUrls;

  @Autowired
  private MovieRepository movieRepository;

  @Autowired
  private MovieMapper movieMapper;

  @Override
  public String sayHello() {
    return "Hello from South Africa";
  }

  @Override
  public Movie findMovieById(long id) throws MovieException {
    Movie movie = new Movie();
    MovieEntity movieEntity = movieRepository.findById(id);
    if (foundMovie(movie, movieEntity)) {
      return movie;
    }
    throw new MovieException("Movie not found with id : " + id);
  }

  @Override
  public Movie findMovieByImdbId(String imdbId) throws MovieException {
    Movie movie = new Movie();
    MovieEntity movieEntity = movieRepository.findByImdbID(imdbId);
    if (foundMovie(movie, movieEntity)) {
      return movie;
    }
    RestTemplate restTemplate = new RestTemplate();
    Map<String,String> params =new HashMap<>();
    params.put("imdb", imdbId);
    String url=OmdbUrlUtil.getOmdbUrl(omdbapiUrls.getImdb(), params);
    log.debug("rest endpoint : "+url);
    movieEntity = restTemplate.getForObject(url, MovieEntity.class);
    log.debug("movieEntity : "+movieEntity);
    if (foundMovie(movie, movieEntity)) {
      movieRepository.save(movieEntity);
      return movie;
    }
    throw new MovieException("Movie not found with imdbId : " + imdbId);
  }
  /**
   * 
   * @param movie
   * @param movieEntity
   * @return 
   */
  private boolean foundMovie(Movie movie, MovieEntity movieEntity) {
    if (movieEntity != null&&movieEntity.getResponse().equalsIgnoreCase("true")) {
      movie.setResponse(true);
      movieMapper.mapMovie(movie, movieEntity);
      return true;
    }
    return false;
  }
}
