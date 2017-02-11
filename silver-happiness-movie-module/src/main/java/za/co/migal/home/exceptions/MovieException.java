/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.migal.home.exceptions;

/**
 *
 * @author migal
 */
public class MovieException extends Exception{

  /**
   * 
   * @param message 
   */
  public MovieException(String message) {
    super(message);
  }

  /**
   * 
   * @param message
   * @param cause 
   */
  public MovieException(String message, Throwable cause) {
    super(message, cause);
  }
  
}
