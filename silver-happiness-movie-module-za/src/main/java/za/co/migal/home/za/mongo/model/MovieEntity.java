/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.migal.home.za.mongo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import org.springframework.data.annotation.Id;

/**
 *
 * @author migal
 */
@Data
public class MovieEntity implements Serializable{
  @Id
  @JsonIgnore
  private long id;
  private String imdbID;
  @JsonProperty("Title")
  private String title;
  @JsonProperty("Year")
  private int year;
  @JsonProperty("Rated")
  private String rated;
  @JsonProperty("Released")
  private String released;//Could be date
  @JsonProperty("Runtime")
  private String runtime;
  @JsonProperty("Genre")
  private String genre;//Could be list
  @JsonProperty("Director")
  private String director;
  @JsonProperty("Writer")
  private String writer;//Could be list
  @JsonProperty("Actors")
  private String actors;//Could be list
  @JsonProperty("Plot")
  private String plot;
  @JsonProperty("Language")
  private String language;//Could be list
  @JsonProperty("Country")
  private String country;//Could be list
  @JsonProperty("Awards")
  private String awards;//Could be list
  @JsonProperty("Poster")
  private String poster;//Could be image
  @JsonProperty("Metascore")
  private String metascore;
  @JsonProperty("imdbRating")
  private String imdbRating;
  @JsonProperty("imdbVotes")
  private String imdbVotes;
  @JsonProperty("Type")
  private String type;//could be enum
  @JsonProperty("Response")
  private String response;
  private String error;

  public MovieEntity() {
    id = new Date().getTime()/1000; 
  }
}
