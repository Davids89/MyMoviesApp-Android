package luque.david.mymoviesapp.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Movie {

    @SerializedName("id")
    public String id;

    @SerializedName("title")
    public String title;

    @SerializedName("poster_path")
    private String posterPath;

    @SerializedName("adult")
    private Boolean adult;

    @SerializedName("overview")
    private String overview;

    @SerializedName("realese_date")
    private String releaseDate;

    @SerializedName("original_title")
    private String originalTitle;

    @SerializedName("original_language")
    private String originalLanguage;

    @SerializedName("vote_count")
    private Integer voteCount;

    @SerializedName("popular")
    private Boolean popular;

    @SerializedName("production_companies")
    private List<Object> productionCompanies = new ArrayList<Object>();

    @SerializedName("cast")
    private List<Object> cast = new ArrayList<Object>();

    @SerializedName("genre_ids")
    private List<Integer> genreIds = new ArrayList<Integer>();

    @SerializedName("additional_properties")
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Movie(String id,
                 String title,
                 String poster_path,
                 Boolean adult,
                 String overview,
                 String realease_date,
                 String original_title,
                 String original_language,
                 Integer vote_count,
                 Boolean popular,
                 List<Integer> genres_ids){
        this.title = title;
        this.id = id;
        this.posterPath = poster_path;
        this.adult = adult;
        this.overview = overview;
        this.releaseDate = realease_date;
        this.originalTitle = original_title;
        this.originalLanguage = original_language;
        this.voteCount = vote_count;
        this.popular = popular;
        this.genreIds = genres_ids;
    }
}