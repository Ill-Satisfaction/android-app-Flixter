package com.example.flixster.adapters;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.flixster.MovieDetailsActivity;
import com.example.flixster.R;
import com.example.flixster.models.Movie;

import org.parceler.Parcels;
import org.w3c.dom.Text;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder>{

    private static final int POPULAR = 9090;
    private static final int NOT_POPULAR = 5050;
    private static final double POPULARITY_THRESHHOLD = 7.3;

    Context context;
    List<Movie> movies;

    public MovieAdapter(Context context, List<Movie> movies) {
        this.context = context;
        this.movies = movies;
    }

    // inflates layout from XML -> returns holder
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d("MovieAdapter", "onCreateViewHolder");
        View movieView = LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false);
        if (viewType==POPULAR)
            movieView = LayoutInflater.from(context).inflate(R.layout.item_popular_movie, parent, false);

        return new ViewHolder(movieView);
    }

    // populate data into view through holder
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d("MovieAdapter", "onBindViewHolder "+position);
        // get movie at position
        Movie movie = movies.get(position);
        // bind movie data into holder
        holder.bind(movie);
    }

    @Override
    public int getItemViewType(int position) {
        if(movies.get(position).getVoteAverage()>POPULARITY_THRESHHOLD)
            return POPULAR;
        return NOT_POPULAR;
    }

    // returns total count of items in list
    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView tvTitle;
        TextView tvOverview;
        ImageView ivPoster;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvOverview = itemView.findViewById(R.id.tvOverview);
            ivPoster = itemView.findViewById(R.id.ivPoster);
        }

        public void bind(Movie movie) {
            tvTitle.setText(movie.getTitle());
            tvOverview.setText(movie.getOverview());
            Glide.with(context).load(movie.getPosterPath(context)).into(ivPoster);
        }

        @Override
        public void onClick(View view) {
            // get position + ensure validity
            int position = getAdapterPosition();
            if (position != RecyclerView.NO_POSITION) {
                // get movie at position
                Movie movie = movies.get(position);
                // create intent to display moviedetails activity
                Intent intent = new Intent(context, MovieDetailsActivity.class);
                // pass movie as an extra (serialized via Parcels.wrap())
                intent.putExtra(Movie.class.getSimpleName(), Parcels.wrap(movie));
                // show activity
                context.startActivity(intent);
            }
        }

    }

}
