package com.kpi.movies.activities;

/**
 * Created by lex on 04.06.18.
 */
import android.app.Application;

import com.kpi.movies.api.GetMovies;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class App extends Application {

    private static GetMovies getMoviesApi;
    private Retrofit retrofit;

    @Override
    public void onCreate() {
        super.onCreate();
        retrofit = new Retrofit.Builder()
                .baseUrl("http://com.kpi.movies.api.themoviedb.org")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        getMoviesApi = retrofit.create(GetMovies.class);
    }

    public static GetMovies getApi() {
        return getMoviesApi;
    }
}
