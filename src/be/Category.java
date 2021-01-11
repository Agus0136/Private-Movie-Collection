package be;

import java.util.ArrayList;
import java.util.List;

public class Category {

    private int id;
    private String name;

    private List<Movie> allMovies;

    public Category(int id, String name){
        this.id = id;
        this.name = name;
        allMovies = new ArrayList<>();
    }

    public void removeMovieFromCategory(int movieId){
        for(Movie movie : allMovies){
            if(movie.getId() == movieId){
                allMovies.remove(movie);
                break;
            }
        }
    }

    public int getId(){
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
