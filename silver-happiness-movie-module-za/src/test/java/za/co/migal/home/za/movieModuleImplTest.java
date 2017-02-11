/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.migal.home.za;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import za.co.migal.home.model.Movie;

/**
 *
 * @author migal
 */
public class movieModuleImplTest {
  
  public movieModuleImplTest() {
  }
  
  @BeforeClass
  public static void setUpClass() {
  }
  
  @AfterClass
  public static void tearDownClass() {
  }
  
  @Before
  public void setUp() {
  }
  
  @After
  public void tearDown() {
  }

  /**
   * Test of sayHello method, of class movieModuleImpl.
   */
  @Test
  public void testSayHello() {
    System.out.println("sayHello");
    movieModuleImpl instance = new movieModuleImpl();
    String expResult = "Hello from South Africa";
    String result = instance.sayHello();
    assertEquals(expResult, result);
  }

  /**
   * Test of findMovieById method, of class movieModuleImpl.
   */
//  @Test
  public void testFindMovieById() throws Exception {
    System.out.println("findMovieById");
    long id = 0L;
    movieModuleImpl instance = new movieModuleImpl();
    Movie expResult = null;
    Movie result = instance.findMovieById(id);
    assertEquals(expResult, result);
  }

  /**
   * Test of findMovieByImdbId method, of class movieModuleImpl.
   */
//  @Test
  public void testFindMovieByImdbId() throws Exception {
    System.out.println("findMovieByImdbId");
    String imdbId = "";
    movieModuleImpl instance = new movieModuleImpl();
    Movie expResult = null;
    Movie result = instance.findMovieByImdbId(imdbId);
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }
  
}
