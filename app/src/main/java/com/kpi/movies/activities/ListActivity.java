package com.kpi.movies.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.kpi.movies.models.Movies;
import com.kpi.movies.R;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
/**
 * Created by lex on 04.06.18.
 */

public class ListActivity {


    public class MainActivity extends AppCompatActivity {
        RecyclerView recyclerView;
        Movies movies;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_list);

            movies = new Movies();

            recyclerView = findViewById(R.id.posts_recycle_view);
            LinearLayoutManager layoutManager = new LinearLayoutManager(this);
            recyclerView.setLayoutManager(layoutManager);

            Timer myTimer = new Timer(); // Создаем таймер
            final Handler uiHandler = new Handler();
            myTimer.schedule(new TimerTask() { // Определяем задачу
                @Override
                public void run() {
                    uiHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            getData();
                        }
                    });
                };
            }, 0L, 15L * 1000); // интервал - 60000 миллисекунд, 0 миллисекунд до первого запуска.
        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            getMenuInflater().inflate(R.menu.main_menu, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            int id = item.getItemId();

            // Операции для выбранного пункта меню
            switch (id) {
                case R.id.refresh:
                    getData();
                    return true;
                default:
                    return super.onOptionsItemSelected(item);
            }
        }

        public void getData(){
            App.getApi().getData().enqueue(new Callback<Course>() {
                @Override
                public void onResponse(Call<Course> call, Response<Course> response) {
                    course.setStock(response.body().getStock());
                    RVAdapterCourse adapter = new RVAdapterCourse(course.getStock());
                    recyclerView.setAdapter(adapter);
                    recyclerView.getAdapter().notifyDataSetChanged();
                }

                @Override
                public void onFailure(Call<Course> call, Throwable t) {
                    Toast.makeText(MainActivity.this, "An error occurred during networking", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
