/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.migal.home.za;

import lombok.extern.log4j.Log4j;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mockito;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.client.RestTemplate;
import za.co.migal.home.exceptions.MovieException;
import za.co.migal.home.model.Movie;
import za.co.migal.home.za.beanconfig.OmdbapiUrls;
import za.co.migal.home.za.mongo.model.MovieEntity;
import za.co.migal.home.za.mongo.repository.MovieRepository;

/**
 *
 * @author migal
 */
@Log4j
@EnableConfigurationProperties
@EnableAutoConfiguration
public class MovieModuleImplTest {

  private MovieEntity movieEntityOwnWorld;
  private MovieEntity movieEntityOwnWorldCapitalTrue;
  private Movie movieOwnWorld;
  private MovieEntity notFoundOnOmdb;

  public MovieModuleImplTest() {
  }

  @BeforeClass
  public static void setUpClass() {

  }

  @AfterClass
  public static void tearDownClass() {
  }

  @Before
  public void setUp() {
    movieEntityOwnWorld = new MovieEntity();
    movieEntityOwnWorld.setActors("Jhonny Depp");
    movieEntityOwnWorld.setAwards("TheAwesomiticAward");
    movieEntityOwnWorld.setCountry("South Africa");
    movieEntityOwnWorld.setDirector("Tim Burton");
    movieEntityOwnWorld.setGenre("Adventure");
    movieEntityOwnWorld.setId(0);
    movieEntityOwnWorld.setImdbID("tt123456");
    movieEntityOwnWorld.setImdbRating("9");
    movieEntityOwnWorld.setImdbVotes("1");
    movieEntityOwnWorld.setLanguage("English");
    movieEntityOwnWorld.setMetascore("9");
    movieEntityOwnWorld.setPlot("Let your imagination run free");
    movieEntityOwnWorld.setPoster("imagine it");
    movieEntityOwnWorld.setRated("9");
    movieEntityOwnWorld.setReleased("2017-02-11");
    movieEntityOwnWorld.setResponse("true");
    
    movieEntityOwnWorldCapitalTrue = new MovieEntity();
    movieEntityOwnWorldCapitalTrue.setActors("Jhonny Depp");
    movieEntityOwnWorldCapitalTrue.setAwards("TheAwesomiticAward");
    movieEntityOwnWorldCapitalTrue.setCountry("South Africa");
    movieEntityOwnWorldCapitalTrue.setDirector("Tim Burton");
    movieEntityOwnWorldCapitalTrue.setGenre("Adventure");
    movieEntityOwnWorldCapitalTrue.setId(0);
    movieEntityOwnWorldCapitalTrue.setImdbID("tt123456");
    movieEntityOwnWorldCapitalTrue.setImdbRating("9");
    movieEntityOwnWorldCapitalTrue.setImdbVotes("1");
    movieEntityOwnWorldCapitalTrue.setLanguage("English");
    movieEntityOwnWorldCapitalTrue.setMetascore("9");
    movieEntityOwnWorldCapitalTrue.setPlot("Let your imagination run free");
    movieEntityOwnWorldCapitalTrue.setPoster("imagine it");
    movieEntityOwnWorldCapitalTrue.setRated("9");
    movieEntityOwnWorldCapitalTrue.setReleased("2017-02-11");
    movieEntityOwnWorldCapitalTrue.setResponse("TRUE");
    
    movieOwnWorld = new Movie();
    movieOwnWorld.setActors("Jhonny Depp");
    movieOwnWorld.setAwards("TheAwesomiticAward");
    movieOwnWorld.setCountry("South Africa");
    movieOwnWorld.setDirector("Tim Burton");
    movieOwnWorld.setGenre("Adventure");
    movieOwnWorld.setId(0);
    movieOwnWorld.setImdbID("tt123456");
    movieOwnWorld.setImdbRating("9");
    movieOwnWorld.setImdbVotes("1");
    movieOwnWorld.setLanguage("English");
    movieOwnWorld.setMetascore("9");
    movieOwnWorld.setPlot("Let your imagination run free");
    movieOwnWorld.setPoster("imagine it");
    movieOwnWorld.setRated("9");
    movieOwnWorld.setReleased("2017-02-11");
    movieOwnWorld.setResponse(true);
    
    notFoundOnOmdb=new MovieEntity();
    notFoundOnOmdb.setResponse("false");
    notFoundOnOmdb.setError("Not found");
    
  }

  @After
  public void tearDown() {
  }

  /**
   * Test of sayHello method, of class MovieModuleImpl.
   */
  @Test
  public void testSayHello() {
    log.info("sayHello");
    MovieModuleImpl instance = new MovieModuleImpl();
    String expResult = "Hello from South Africa";
    String result = instance.sayHello();
    assertEquals(expResult, result);
  }

  /**
   * Test of findMovieById method, of class MovieModuleImpl.
   */
  @Test
  public void testFindMovieById() throws Exception {
    log.info("findMovieById");
    MovieRepository movieRepository = Mockito.mock(MovieRepository.class);
    long id = 0;
    Mockito.when(movieRepository.findById(id)).thenReturn(movieEntityOwnWorld);
    MovieModuleImpl instance = new MovieModuleImpl();
    instance.setMovieMapper(new MovieMapper());
    instance.setMovieRepository(movieRepository);
    instance.setOmdbapiUrls(new OmdbapiUrls());
    Movie result = instance.findMovieById(id);
    Movie expResult = movieOwnWorld;
    assertEquals(expResult, result);
  }
  /**
   * Test of findMovieById method, of class MovieModuleImpl.
   */
  @Test(expected = MovieException.class)
  public void testFindMovieById_notFound() throws Exception {
    log.info("findMovieById");
    MovieRepository movieRepository = Mockito.mock(MovieRepository.class);
    long id = 0;
    Mockito.when(movieRepository.findById(id)).thenReturn(null);
    MovieModuleImpl instance = new MovieModuleImpl();
    instance.setMovieMapper(new MovieMapper());
    instance.setMovieRepository(movieRepository);
    instance.setOmdbapiUrls(new OmdbapiUrls());
    Movie result = instance.findMovieById(id);
    Movie expResult = movieOwnWorld;
    assertEquals(expResult, result);
  }

  /**
   * Test of findMovieByImdbId method, of class MovieModuleImpl.
   */
  @Test
  public void testFindMovieByImdbId() throws Exception {
    log.info("findMovieByImdbId");
    MovieRepository movieRepository = Mockito.mock(MovieRepository.class);
    String imdbId = "tt123456";
    Mockito.when(movieRepository.findByImdbID(imdbId)).thenReturn(movieEntityOwnWorld);
    MovieModuleImpl instance = new MovieModuleImpl();
    instance.setMovieMapper(new MovieMapper());
    instance.setMovieRepository(movieRepository);
    instance.setOmdbapiUrls(new OmdbapiUrls());
    instance.setRestTemplate(new RestTemplate());
    Movie result = instance.findMovieByImdbId(imdbId);
    Movie expResult = movieOwnWorld;
    assertEquals(expResult, result);
  }
  /**
   * Test of findMovieByImdbId method, of class MovieModuleImpl.
   */
  @Test
  public void testFindMovieByImdbId_notFoundLocally() throws Exception {
    log.info("findMovieByImdbId");
    String imdbId = "tt123456";
    MovieRepository movieRepository = Mockito.mock(MovieRepository.class);
    RestTemplate restTemplate = Mockito.mock(RestTemplate.class);
    Mockito.when(movieRepository.findByImdbID(imdbId)).thenReturn(null);
    Mockito.when(restTemplate.getForObject("http://www.omdbapi.com/?i=tt123456&plot=short&r=json",MovieEntity.class)).thenReturn(movieEntityOwnWorld);
    MovieModuleImpl instance = new MovieModuleImpl();
    instance.setMovieMapper(new MovieMapper());
    instance.setMovieRepository(movieRepository);
    OmdbapiUrls omdbapiUrls=new OmdbapiUrls();
    omdbapiUrls.setImdb("http://www.omdbapi.com/?i=imdb&plot=short&r=json");
    instance.setOmdbapiUrls(omdbapiUrls);
    
    instance.setRestTemplate(restTemplate);
    Movie result = instance.findMovieByImdbId(imdbId);
    Movie expResult = movieOwnWorld;
    assertEquals(expResult, result);
  }
  /**
   * Test of findMovieByImdbId method, of class MovieModuleImpl.
   */
  @Test(expected = MovieException.class)
  public void testFindMovieByImdbId_notFound() throws Exception {
    log.info("findMovieByImdbId");
    String imdbId = "tt123456";
    MovieRepository movieRepository = Mockito.mock(MovieRepository.class);
    RestTemplate restTemplate = Mockito.mock(RestTemplate.class);
    Mockito.when(movieRepository.findByImdbID(imdbId)).thenReturn(null);
    Mockito.when(restTemplate.getForObject("http://www.omdbapi.com/?i=tt123456&plot=short&r=json",MovieEntity.class)).thenReturn(null);
    MovieModuleImpl instance = new MovieModuleImpl();
    instance.setMovieMapper(new MovieMapper());
    instance.setMovieRepository(movieRepository);
    OmdbapiUrls omdbapiUrls=new OmdbapiUrls();
    omdbapiUrls.setImdb("http://www.omdbapi.com/?i=imdb&plot=short&r=json");
    instance.setOmdbapiUrls(omdbapiUrls);
    
    instance.setRestTemplate(restTemplate);
    Movie result = instance.findMovieByImdbId(imdbId);
    Movie expResult = movieOwnWorld;
    assertEquals(expResult, result);
  }
  /**
   * Test of findMovieByImdbId method, of class MovieModuleImpl.
   */
  @Test
  public void testFindMovieByImdbId_notFoundWithResponse() throws Exception {
    log.info("findMovieByImdbId");
    String imdbId = "tt123456";
    MovieRepository movieRepository = Mockito.mock(MovieRepository.class);
    RestTemplate restTemplate = Mockito.mock(RestTemplate.class);
    Mockito.when(movieRepository.findByImdbID(imdbId)).thenReturn(null);
    Mockito.when(restTemplate.getForObject("http://www.omdbapi.com/?i=tt123456&plot=short&r=json",MovieEntity.class)).thenReturn(movieEntityOwnWorldCapitalTrue);
    MovieModuleImpl instance = new MovieModuleImpl();
    instance.setMovieMapper(new MovieMapper());
    instance.setMovieRepository(movieRepository);
    OmdbapiUrls omdbapiUrls=new OmdbapiUrls();
    omdbapiUrls.setImdb("http://www.omdbapi.com/?i=imdb&plot=short&r=json");
    instance.setOmdbapiUrls(omdbapiUrls);
    
    instance.setRestTemplate(restTemplate);
    Movie result = instance.findMovieByImdbId(imdbId);
    Movie expResult = movieOwnWorld;
    assertEquals(expResult, result);
  }

}
