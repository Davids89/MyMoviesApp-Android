package luque.david.mymoviesapp.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import luque.david.mymoviesapp.API.MyApiEndPointsInterface;
import luque.david.mymoviesapp.R;
import luque.david.mymoviesapp.models.Movie;
import luque.david.mymoviesapp.models.MoviesWrapper;
import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListMoviesFragment extends Fragment {

    Retrofit retrofit;
    MyApiEndPointsInterface apiService;
    private static final String BASE_URL = "http://api.themoviedb.org/3/";
    private static final String API_KEY = "7c45e91d96f141e78609a00969329847";


    public ListMoviesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.fragment_list_movies, container, false);

        retrofitConnection();

        getMoviesFunction();

        return rootview;
    }

    @Override
    public void onResume() {
        super.onResume();

    }

    public void retrofitConnection(){
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiService = retrofit.create(MyApiEndPointsInterface.class);
    }

    public void getMoviesFunction(){

        final List<Movie> moviesFromApi = new ArrayList<>();

        Call<MoviesWrapper> call = apiService.getPopularMovies(API_KEY, "es");

        Log.wtf("ListMoviesFragment", "No llega");

        call.enqueue(new Callback<MoviesWrapper>() {
            @Override
            public void onResponse(Response<MoviesWrapper> response, Retrofit retrofit) {

                for(Movie movie: response.body().getResults()){
                    Log.wtf("Name of movie", movie.getTitle());
                }
            }

            @Override
            public void onFailure(Throwable t) {
                Log.wtf("Error", t.toString());
            }
        });

    }

}
