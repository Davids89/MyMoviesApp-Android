package luque.david.mymoviesapp.API;

import java.util.List;

import luque.david.mymoviesapp.models.Movie;
import luque.david.mymoviesapp.models.MoviesWrapper;
import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by David on 9/1/16.
 */
public interface MyApiEndPointsInterface {

    @GET("/popularMovies")
    Call<MoviesWrapper> getPopularMovies();

    @GET("/movie/{id}")
    Call<Movie> getMovie(@Path("id") int id);
}
