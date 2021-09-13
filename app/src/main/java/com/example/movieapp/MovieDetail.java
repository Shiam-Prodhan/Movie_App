package com.example.movieapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

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
        setContentView(R.layout.detail_design);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        movieId =  getIntent().getIntExtra("movie_id", 0);

        ImageView postView = findViewById(R.id.poster);
        ImageView coverView = findViewById(R.id.cover);
        TextView titleView = findViewById(R.id.title);
        TextView ratingView =  findViewById(R.id.rating);
        TextView descView = findViewById(R.id.description);
        RatingBar ratingBar = findViewById(R.id.ratingBar);
;

        String response = null;
        try {
            response = run("https://api.themoviedb.org/3/movie/"+movieId+"?api_key=3fa9058382669f72dcb18fb405b7a831");
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Test  "+response);
        MovieDetailsResponse mr = new Gson().fromJson(response, MovieDetailsResponse.class);

        Glide.with(this)
                .load("https://image.tmdb.org/t/p/w500"+mr.getPosterPath())
                .into(postView);
        Glide.with(this)
                .load("https://image.tmdb.org/t/p/w500"+mr.getBackdropPath())
                .into(coverView);

        titleView.setText(mr.getTitle());
        ratingView.setText(Double.toString(mr.getVoteAverage()));
        descView.setText(mr.getOverview());
        ratingBar.setRating((float)mr.getVoteAverage()/2);


        String response1 = null;
        try {
            response1 = run("https://api.themoviedb.org/3/movie/"+movieId+"/credits?api_key=3fa9058382669f72dcb18fb405b7a831");
        } catch (IOException e) {
            e.printStackTrace();
        }

        CastResponse mr1 = new Gson().fromJson(response1, CastResponse.class);

        RecyclerView castRecyclerView = findViewById(R.id.RecycleCast);
        castRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));
        castRecyclerView.setAdapter(new MyAdapter(mr1.getCast()));

    }
    public class MyAdapter extends RecyclerView.Adapter<MovieDetail.MyViewHolder> {

        List<Cast> castList;


        public MyAdapter(List<Cast> castList) {
            this.castList = castList;
        }

        @Override
        public MovieDetail.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            View mItemView = LayoutInflater.from(MovieDetail.this)
                    .inflate(R.layout.cast, parent, false);
            return new MyViewHolder(mItemView);
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            holder.name.setText(castList.get(position).getOriginalName());
            Glide.with(MovieDetail.this)
                    .load("https://image.tmdb.org/t/p/w500"+castList.get(position).getProfilePath())
                    .into(holder.flag);

        }


        @Override
        public int getItemCount() {
            return castList.size();

        }
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView flag;
        TextView name;



        public MyViewHolder(View itemView) {
            super(itemView);
            flag = itemView.findViewById(R.id.photo);
            name=itemView.findViewById(R.id.name);

        }
    }
}