package luque.david.mymoviesapp.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.RealmQuery;
import io.realm.RealmResults;
import luque.david.mymoviesapp.API.MyApiEndPointsInterface;
import luque.david.mymoviesapp.MainActivity;
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
    Realm realm;


    public ListMoviesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.fragment_list_movies, container, false);

        declareRealm();

        retrofitConnection();

        getMoviesFunction();

        return rootview;
    }

    @Override
    public void onResume() {
        super.onResume();

    }

    public void retrofitConnection(){

        Gson gson = new GsonBuilder()
                .setExclusionStrategies(new ExclusionStrategy() {
                    @Override
                    public boolean shouldSkipField(FieldAttributes f) {
                        return f.getDeclaringClass().equals(RealmObject.class);
                    }

                    @Override
                    public boolean shouldSkipClass(Class<?> clazz) {
                        return false;
                    }
                })
                .create();

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
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

                Movie mMovie = new Movie();

                for(Movie movie: response.body().getResults()){

                    realm.beginTransaction();

                    RealmQuery<Movie> movieQuery = realm.where(Movie.class);

                    movieQuery.equalTo("id", movie.getId());

                    RealmResults<Movie> result = movieQuery.findAll();

                    if(result.size() == 0){
                        mMovie.setTitle(movie.getTitle());
                        mMovie.setId(movie.getId());
                        mMovie.setPosterPath(movie.getPosterPath());
                        mMovie.setAdult(movie.getAdult());
                        mMovie.setOverview(movie.getOverview());
                        mMovie.setReleaseDate(movie.getReleaseDate());
                        mMovie.setOriginalTitle(movie.getOriginalTitle());
                        mMovie.setOriginalLanguage(movie.getOriginalLanguage());
                        mMovie.setVoteCount(movie.getVoteCount());
                        mMovie.setPopular(movie.getPopular());
                    }

                    realm.commitTransaction();

                }
            }

            @Override
            public void onFailure(Throwable t) {
                Log.wtf("Error", t.toString());
            }
        });

    }

    public void declareRealm(){
        realm = Realm.getInstance(getActivity());
    }

}
