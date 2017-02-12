/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.migal.home.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import gherkin.deps.com.google.gson.Gson;
import java.io.FileReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;
import za.co.migal.home.exceptions.MovieException;
import za.co.migal.home.model.Movie;
import za.co.migal.home.za.mongo.model.MovieEntity;
import za.co.migal.home.za.mongo.repository.MovieRepository;

/**
 *
 * @author migal
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class MovieControllerTest {

  @Autowired
  private WebApplicationContext context;

  private MockMvc mvc;
  private MovieEntity movieEntityOwnWorld;
  private Movie movieOwnWorld;
  private MovieEntity legoBatman;
  private MovieEntity batmanVsSuperman;
  private List<MovieEntity> batmanMovies;
  private MovieEntity notFoundOnOmdb;
  private Movie errorMovie;
  private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
          MediaType.APPLICATION_JSON.getSubtype(),
          Charset.forName("utf8"));

  @MockBean
  private MovieRepository movieRepository;
  
  @MockBean
  private RestTemplate restTemplate;

  public MovieControllerTest() {
  }

  @BeforeClass
  public static void setUpClass() {
  }

  @AfterClass
  public static void tearDownClass() {
  }

  @Before
  public void setUp() {
    this.mvc = MockMvcBuilders.webAppContextSetup(this.context).build();

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
    
    legoBatman = new MovieEntity();
    legoBatman.setActors("Jenny Slate, Will Arnett, Ralph Fiennes, Zach Galifianakis");
    legoBatman.setAwards("N/A");
    legoBatman.setCountry("USA, Denmark");
    legoBatman.setDirector("Chris McKay");
    legoBatman.setGenre("Animation, Action, Adventure");
    legoBatman.setId(0);
    legoBatman.setImdbID("tt4116284");
    legoBatman.setImdbRating("N/A");
    legoBatman.setImdbVotes("N/A");
    legoBatman.setLanguage("English");
    legoBatman.setMetascore("N/A");
    legoBatman.setPlot("Bruce Wayne must not only deal with the criminals of Gotham City, but also the responsibility of raising a boy he adopted.");
    legoBatman.setPoster("https://images-na.ssl-images-amazon.com/images/M/MV5BMTcyNTEyOTY0M15BMl5BanBnXkFtZTgwOTAyNzU3MDI@._V1_SX300.jpg");
    legoBatman.setRated("PG");
    legoBatman.setReleased("10 Feb 2017");
    legoBatman.setResponse("true");
    legoBatman.setTitle("The Lego Batman Movie");
    legoBatman.setYear(0);
    legoBatman.setRuntime("104 min");
    legoBatman.setWriter(null);
    legoBatman.setType(null);
    
    batmanVsSuperman = new MovieEntity();
    batmanVsSuperman.setActors("Ben Affleck, Henry Cavill, Amy Adams, Jesse Eisenberg");
    batmanVsSuperman.setAwards("3 wins & 14 nominations.");
    batmanVsSuperman.setCountry("USA");
    batmanVsSuperman.setDirector("Zack Snyder");
    batmanVsSuperman.setGenre("Action, Adventure, Sci-Fi");
    batmanVsSuperman.setId(1486803942);
    batmanVsSuperman.setImdbID("tt2975590");
    batmanVsSuperman.setImdbRating("6.7");
    batmanVsSuperman.setImdbVotes("438,291");
    batmanVsSuperman.setLanguage("English");
    batmanVsSuperman.setMetascore("44");
    batmanVsSuperman.setPlot("Fearing that the actions of Superman are left unchecked, Batman takes on the Man of Steel, while the world wrestles with what kind of a hero it really needs.");
    batmanVsSuperman.setPoster("https://images-na.ssl-images-amazon.com/images/M/MV5BYThjYzcyYzItNTVjNy00NDk0LTgwMWQtYjMwNmNlNWJhMzMyXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SX300.jpg");
    batmanVsSuperman.setRated("PG-13");
    batmanVsSuperman.setReleased("25 Mar 2016");
    batmanVsSuperman.setResponse("true");
    batmanVsSuperman.setTitle("Batman v Superman: Dawn of Justice");
    batmanVsSuperman.setYear(0);
    batmanVsSuperman.setRuntime("151 min");
    batmanVsSuperman.setWriter(null);
    batmanVsSuperman.setType(null);
    
    batmanMovies=new ArrayList<>();
    batmanMovies.add(legoBatman);
    batmanMovies.add(batmanVsSuperman);

    notFoundOnOmdb = new MovieEntity();
    notFoundOnOmdb.setResponse("false");
    notFoundOnOmdb.setError("Not found");

    errorMovie = new Movie();
    errorMovie.setResponse(false);
  }

  @After
  public void tearDown() {
  }

  /**
   * Test of hello method, of class MovieController.
   */
  @Test
  public void testHello() throws Exception {
    this.mvc.perform(get("/hello")).andExpect(status().isOk())
            .andExpect(content().string("Hello from South Africa"));
  }

  /**
   * Test of findMovieByImdbId method, of class MovieController.
   */
  @Test
  public void testFindMovieByImdbId() throws Exception {
    when(movieRepository.findByImdbID("tt4116284")).thenReturn(legoBatman);
    Gson gson = new Gson();
    Movie movie = gson.fromJson(new FileReader(MovieControllerTest.class.getClassLoader().getResource("LegoBatman_output_valid.json").getFile()), Movie.class);
    String expected = gson.toJson(movie);
    this.mvc.perform(get("/findMovieByImdbId/tt4116284")).
            andExpect(status().isOk()).
            andExpect(content().contentType(contentType)).
            andExpect(content().json(expected));

  }

  /**
   * Test of findMovieByImdbId method, of class MovieController.
   */
  @Test
  public void testFindMovieByImdbId_notFound() throws Exception {
    when(movieRepository.findByImdbID("tt123456")).thenReturn(null);
    when(restTemplate.getForObject("http://www.omdbapi.com/?i=tt123456&plot=short&r=json",MovieEntity.class)).thenReturn(notFoundOnOmdb);
    Gson gson = new Gson();
    String error = gson.toJson(errorMovie);
    this.mvc.perform(get("/findMovieByImdbId/tt123456")).
            andExpect(status().isOk()).
            andExpect(content().contentType(contentType)).
            andExpect(content().json(error));

  }

  /**
   * Test of findMovieById method, of class MovieController.
   */
  @Test
  public void testFindMovieById() throws Exception {
    when(movieRepository.findById(0)).thenReturn(legoBatman);
    Gson gson = new Gson();
    Movie movie = gson.fromJson(new FileReader(MovieControllerTest.class.getClassLoader().getResource("LegoBatman_output_valid.json").getFile()), Movie.class);
    String expected = gson.toJson(movie);
    this.mvc.perform(get("/findMovieById/0")).andExpect(status().isOk()).
            andExpect(content().contentType(contentType)).
            andExpect(content().json(expected));
  }

  /**
   * Test of findMovieById method, of class MovieController.
   */
  @Test
  public void testFindMovieById_notFound() throws Exception {
    when(movieRepository.findById(1)).thenReturn(null);
    Gson gson = new Gson();
    String error = gson.toJson(errorMovie);

    this.mvc.perform(get("/findMovieById/1")).andExpect(status().isOk()).
            andExpect(content().contentType(contentType)).
            andExpect(content().json(error));
  }

  /**
   * Test of findMovieByTitle method, of class MovieController.
   */
  @Test
  public void testFindMovieByTitle() throws Exception{
    when(movieRepository.findByTitleContainingIgnoreCase("batman")).thenReturn(batmanMovies);
    Gson gson = new Gson();
    Movie[] movie = gson.fromJson(new FileReader(MovieControllerTest.class.getClassLoader().getResource("batman.json").getFile()), Movie[].class);
    String expected = gson.toJson(movie);
    this.mvc.perform(get("/findMovieByTitle/batman")).andExpect(status().isOk()).
            andExpect(content().contentType(contentType)).
            andExpect(content().json(expected));
  }

}
