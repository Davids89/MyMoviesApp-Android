package luque.david.mymoviesapp.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by David on 10/1/16.
 */
public class MoviesWrapper {

    @SerializedName("results")
    private List<Movie> results;

    public MoviesWrapper(List<Movie> results) {

        this.results = results;
    }

    public List<Movie> getResults() {
        return results;
    }
}
