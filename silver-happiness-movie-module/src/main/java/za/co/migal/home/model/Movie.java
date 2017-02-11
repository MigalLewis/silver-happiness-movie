/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.migal.home.model;

import lombok.Data;

/**
 *
 * @author migal
 */
@Data
public class Movie {
  private long id;
  private String imdbID;
  private String title;
  private int year;
  private String rated;
  private String released;//Could be date
  private String runtime;
  private String genre;//Could be list
  private String director;
  private String writer;//Could be list
  private String actors;//Could be list
  private String plot;
  private String language;//Could be list
  private String country;//Could be list
  private String awards;//Could be list
  private String poster;//Could be image
  private String metascore;
  private String imdbRating;
  private String imdbVotes;
  private String type;//could be enum
  private boolean response;
}
