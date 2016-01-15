package luque.david.mymoviesapp.models;

import java.util.List;

/**
 * Created by David on 10/1/16.
 */
public class MoviesWrapper {

    private Number page;

    private List<Movie> results;

    private Number total_pages;
    private Number total_results;

    public MoviesWrapper(List<Movie> results) {

        this.results = results;
    }

    public Number getPage() {

        return this.page;
    }

    public void setPage(Number page) {

        this.page = page;
    }

    public List<Movie> getResults() {

        return results;
    }

    public Number getTotal_pages() {

        return this.total_pages;
    }

    public void setTotal_pages(Number total_pages) {

        this.total_pages = total_pages;
    }

    public Number getTotal_results() {

        return this.total_results;
    }

    public void setTotal_results(Number total_results) {

        this.total_results = total_results;
    }

}
