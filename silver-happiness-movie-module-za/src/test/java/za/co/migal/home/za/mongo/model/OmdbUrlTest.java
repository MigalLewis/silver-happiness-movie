/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.migal.home.za.mongo.model;

import java.util.HashMap;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import za.co.migal.home.za.mongo.util.OmdbUrlUtil;

/**
 *
 * @author migal
 */
public class OmdbUrlTest {
  
  public OmdbUrlTest() {
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
   * Test of getOmdbUrl method, of class OmdbUrlUtil.
   */
  @Test
  public void testGetOmdbUrl() {
    System.out.println("getOmdbUrl");
    Map<String, String> params = new HashMap<>();
    params.put("imdb", "12345");
    String expResult = "http://www.omdbapi.com/?i=12345&plot=short&r=json";
    String result = OmdbUrlUtil.getOmdbUrl("http://www.omdbapi.com/?i=imdb&plot=short&r=json",params);
    assertEquals(expResult, result);
  }
  /**
   * Test of getOmdbUrl method, of class OmdbUrlUtil.
   */
  @Test
  public void testGetOmdbUrl_notEquals() {
    System.out.println("getOmdbUrl");
    Map<String, String> params = new HashMap<>();
    params.put("imdb", "12345");
    String expResult = "http://www.omdbapi.com/?i=6789&plot=short&r=json";
    String result = OmdbUrlUtil.getOmdbUrl("http://www.omdbapi.com/?i=imdb&plot=short&r=json",params);
    assertNotEquals(expResult, result);
  }
  /**
   * Test of getOmdbUrl method, of class OmdbUrlUtil.
   */
  @Test
  public void testGetOmdbUrl_notEquals2() {
    System.out.println("getOmdbUrl");
    Map<String, String> params = new HashMap<>();
    params.put("imdb2", "12345");
    String expResult = "http://www.omdbapi.com/?i=12345&plot=short&r=json";
    String result = OmdbUrlUtil.getOmdbUrl("http://www.omdbapi.com/?i=imdb&plot=short&r=json",params);
    assertNotEquals(expResult, result);
  }
  
}
