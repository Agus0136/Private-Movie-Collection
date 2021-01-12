package gui.model;

import be.Movie;
import bll.BLLFacade;
import bll.IBLLFacade;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;

public class MovieModel {
    private static MovieModel MoviesSingleteon;
    private IBLLFacade bllFacade;

    private ObservableList<Movie> allMovies = FXCollections.observableArrayList();

    public MovieModel() throws IOException {
        bllFacade = new BLLFacade();
    }

    public static MovieModel getInstance() throws IOException {
        if (MoviesSingleteon == null)
        {
            MoviesSingleteon = new MovieModel();
        }
        return MoviesSingleteon;
    }
    public ObservableList<Movie> getAllMovies() {
        allMovies = FXCollections.observableArrayList();
        allMovies.addAll( bllFacade.getAllMovies());
        return allMovies;
    }

    public Movie createMovie(String name, String text, String selectedItem, int i, String text1) {
        Movie newMovie = bllFacade.createMovie(name, text, selectedItem, i, text1);
        allMovies.add(newMovie);
        return newMovie;
    }

    public Movie updateMovie(Movie movieToEdit, String name, String text, String selectedItem, int i, String text1) {
        return bllFacade.updateMovie(movieToEdit, name, text, selectedItem, i, text1);
    }

    public Movie deleteMovie(Movie movieToDelete)
    {
        return bllFacade.deleteMovie(movieToDelete);
    }
}
