package za.co.migal.home.za;

import java.util.HashMap;
import java.util.Map;
import za.co.migal.home.za.beanconfig.OmdbapiUrls;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import za.co.migal.home.exceptions.MovieException;
import za.co.migal.home.model.Movie;
import za.co.migal.home.za.mongo.model.MovieEntity;
import za.co.migal.home.za.mongo.util.OmdbUrlUtil;
import za.co.migal.home.za.mongo.repository.MovieRepository;
import za.co.migal.home.MovieModule;

/**
 *
 * @author migal
 */
@Component
@Log4j
public class MovieModuleImpl implements MovieModule {

  private OmdbapiUrls omdbapiUrls;
  private MovieRepository movieRepository;
  private MovieMapper movieMapper;
  private RestTemplate restTemplate;

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
    Map<String, String> params = new HashMap<>();
    params.put("imdb", imdbId);
    String url = OmdbUrlUtil.getOmdbUrl(omdbapiUrls.getImdb(), params);
    log.debug("rest endpoint : " + url);
    movieEntity = restTemplate.getForObject(url, MovieEntity.class);
    log.debug("movieEntity : " + movieEntity);
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
    if (movieEntity != null && "true".equalsIgnoreCase(movieEntity.getResponse())) {
      movie.setResponse(true);
      movieMapper.mapMovie(movie, movieEntity);
      return true;
    }
    return false;
  }

  @Autowired
  public void setOmdbapiUrls(OmdbapiUrls omdbapiUrls) {
    this.omdbapiUrls = omdbapiUrls;
  }

  @Autowired
  public void setMovieRepository(MovieRepository movieRepository) {
    this.movieRepository = movieRepository;
  }

  @Autowired
  public void setMovieMapper(MovieMapper movieMapper) {
    this.movieMapper = movieMapper;
  }
  @Autowired
  public void setRestTemplate(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

}
