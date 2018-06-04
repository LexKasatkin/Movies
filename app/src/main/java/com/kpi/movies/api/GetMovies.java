package com.kpi.movies.api;

/**
 * Created by lex on 04.06.18.
 */
import com.kpi.movies.models.Movies;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by lex on 02.02.18.
 */

public interface GetMovies {
    @GET("/3/movie/popular/")
    Call<Movies> getData(@Query("api_key") String resourceName);
}

//public interface getDetails {
//    @GET("/3/movie/")
//    Call<Course> getData(@Query("api_key") String resourceName, @Query("movie_id") int movie_id);
//}