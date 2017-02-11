/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.migal.home.za.beanconfig;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import za.co.migal.home.za.MovieMapper;

/**
 *
 * @author migal
 */
public class BeanConfigTest {
  
  public BeanConfigTest() {
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
   * Test of movieMapper method, of class BeanConfig.
   */
  @Test
  public void testMovieMapper() {
    System.out.println("movieMapper");
    BeanConfig instance = new BeanConfig();
    MovieMapper result = instance.movieMapper();
    assertNotNull(result);
  }
  
}
