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
    private static final String BASE_URL = "http://192.168.0.154:8080";


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

        Call<MoviesWrapper> call = apiService.getPopularMovies();

        Log.wtf("ListMoviesFragment", "No llega");

        call.enqueue(new Callback<MoviesWrapper>() {
            @Override
            public void onResponse(Response<MoviesWrapper> response, Retrofit retrofit) {
                Log.d("ListMoviesFragment", "GetMoviesFunction");
                Log.d("ListMoviesFragment", "GetMoviesFunction");
            }

            @Override
            public void onFailure(Throwable t) {
                Log.wtf("Error", t.toString());
            }
        });

    }

}
