package luque.david.mymoviesapp.API;

import java.util.List;

import luque.david.mymoviesapp.models.Movie;
import luque.david.mymoviesapp.models.MoviesWrapper;
import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by David on 9/1/16.
 */
public interface MyApiEndPointsInterface {

    @GET("/movie/{id}")
    Call<Movie> getMovie(@Path("id") int id);

    @GET("movie/popular")
    Call<MoviesWrapper> getPopularMovies(
            @Query("api_key") String apiKey,
            @Query("language") String language
    );
}
