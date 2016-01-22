package luque.david.mymoviesapp.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.realm.RealmObject;
import io.realm.annotations.Required;

public class Movie extends RealmObject{

    @SerializedName("id")
    private String id;

    @SerializedName("title")
    @Required
    private String title;

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

    public Movie(){

    }

    public Movie(String id,
                 String title,
                 String poster_path,
                 Boolean adult,
                 String overview,
                 String realease_date,
                 String original_title,
                 String original_language,
                 Integer vote_count,
                 Boolean popular){
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
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public Boolean getAdult() {
        return adult;
    }

    public void setAdult(Boolean adult) {
        this.adult = adult;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public Integer getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(Integer voteCount) {
        this.voteCount = voteCount;
    }

    public Boolean getPopular() {
        return popular;
    }

    public void setPopular(Boolean popular) {
        this.popular = popular;
    }
}