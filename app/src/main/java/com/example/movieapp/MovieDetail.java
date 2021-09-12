package com.example.movieapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.StrictMode;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MovieDetail extends AppCompatActivity {
    final OkHttpClient client = new OkHttpClient();

    String run(String url) throws IOException {
        Request request = new Request.Builder().url(url).build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }
    int movieId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        movieId =  getIntent().getIntExtra("movie_id", 0);

        ImageView postView = findViewById(R.id.poster);
        ImageView coverView = findViewById(R.id.cover);
        TextView titleView = findViewById(R.id.title);


        String response = null;
        try {
            response = run("https://api.themoviedb.org/3/movie/"+movieId+"?api_key=3fa9058382669f72dcb18fb405b7a831");
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Test  "+response);
        Toast.makeText(this, "Movie id "+movieId, Toast.LENGTH_LONG).show();
        MovieDetailsResponse mr = new Gson().fromJson(response, MovieDetailsResponse.class);

        Glide.with(this)
                .load("https://image.tmdb.org/t/p/w500"+mr.getPosterPath())
                .into(postView);
        Glide.with(this)
                .load("https://image.tmdb.org/t/p/w500"+mr.getBackdropPath())
                .into(coverView);

        titleView.setText(mr.getTitle());
    }
}