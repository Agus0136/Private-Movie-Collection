package gui.Controller;

import be.Movie;
import dal.DAO.MovieDAO;
import gui.model.MovieModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    private MovieModel movieModel;

    @FXML
    public TableColumn<Movie, String> movieStringTableColumn;

    private MovieDAO movieDAO = new MovieDAO();

    private int currentMovie = 0;

    private ObservableList<Movie> observableListMovie;
    //@FXML
    //private Label movieLabel;
    @FXML
    private TableView<Movie> IstMovies;
    @FXML
    private TableColumn<Movie, String> Title;
    @FXML
    private TableColumn<Movie, String> Category;
    @FXML
    private TableColumn<Movie, Integer> Time;
    @FXML
    private TableColumn<Movie, String> myRating;
    @FXML
    private TableColumn<Movie, Integer> playCount;
    @FXML
    private TableColumn<Movie, String> lastPlayed;

    @FXML
    private Button playButton;
    @FXML
    private Label playingMovieLabel;
    @FXML
    private Slider volume;

    private MediaPlayer mediaPlayer;

    public MainController() throws IOException {
        System.out.println( "Active" );
        movieModel = MovieModel.getInstance(); //singleton
        System.out.println( movieModel.getAllMovies() );
    }

    public void clickLoad(ActionEvent actionEvent) {
        //List<Movie> movies = movieDAO.getAllMovies();
        //IstMovies.getItems().clear();
        //IstMovies.getItems().addAll(movies);
    }

    public void refreshMovie(javafx.event.ActionEvent actionEvent) throws IOException {
        UpdataMovie();
    }

    public void UpdataMovie() {
        IstMovies.setItems( movieModel.getAllMovies() );
    }

    public void UpdataTable() {
        Title.setCellValueFactory( new PropertyValueFactory<>( "Title" ) );
        Category.setCellValueFactory( new PropertyValueFactory<>( "Category" ) );
        Time.setCellValueFactory( new PropertyValueFactory<>( "playtime" ) );
        myRating.setCellValueFactory( new PropertyValueFactory<>( "myRating" ) );
        playCount.setCellValueFactory( new PropertyValueFactory<>( "playCount" ) );
        lastPlayed.setCellValueFactory( new PropertyValueFactory<>( "lastPlayed" ) );
        IstMovies.setItems( movieModel.getAllMovies() );

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        UpdataTable();
    }


    private void play()
    {
        mediaPlayer = new MediaPlayer(
                new Media(
                        new File(
                                IstMovies.getItems().get(currentMovie).getLocation()).toURI().toString()
                )
        );
        mediaPlayer.play();
        playingMovieLabel.setText(IstMovies.getItems().get(currentMovie).getTitle() + " is Playing");
        mediaPlayer.setOnEndOfMedia(() -> {
            if (IstMovies.getSelectionModel().getSelectedIndex() != -1) {
                if (IstMovies.getItems().size() == currentMovie + 1) {
                    currentMovie = 0;
                }
                else {
                    currentMovie++;
                }
                play();
            }

        }) ;
    }

    public void playMovie(javafx.event.ActionEvent actionEvent) {
        if (mediaPlayer == null) {
            playButton.setText( "Stop" );
            play();

        } else {
            playingMovieLabel.setText( "None is Playing" );
            playButton.setText( "Play" );
            mediaPlayer.stop();
            mediaPlayer = null;
        }
    }

    public void backButton(javafx.event.ActionEvent actionEvent) {
        if (IstMovies.getSelectionModel().getSelectedIndex() != -1) {
            mediaPlayer.stop();
            if (currentMovie - 1 <= -1) {
                currentMovie = 0;
            } else {
                currentMovie--;
            }
            play();
        }

    }

    public void forwardButton(javafx.event.ActionEvent actionEvent) {
        if (IstMovies.getSelectionModel().getSelectedIndex() != -1) {
            mediaPlayer.stop();
            if (IstMovies.getItems().size() == currentMovie + 1) {
                currentMovie = 0;
            } else {
                currentMovie++;
            }
            play();
        }
    }

    public void setSound(MouseEvent mouseEvent) {
        if (mediaPlayer != null) {
            mediaPlayer.setVolume( volume.getValue() );
        }
    }

    public void newMovie(javafx.event.ActionEvent actionEvent) throws IOException {
        setUpScenes( false );
    }

    public void setExit(javafx.event.ActionEvent actionEvent) throws IOException {
        System.exit( 0 );
    }

    public void deleteMovie(javafx.event.ActionEvent actionEvent) {
        if (IstMovies.getSelectionModel().getSelectedIndex() != -1) {
            movieModel.deleteMovie( IstMovies.getSelectionModel().getSelectedItem() );
        }
        UpdataMovie();
    }


    public void updateMovie(javafx.event.ActionEvent actionEvent) {
        try {
            setUpScenes( true );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setUpScenes(boolean isEditing) throws IOException { // New/Edit movie scene
        Parent root2;
        FXMLLoader fxmlLoader = new FXMLLoader( getClass().getResource( "/gui/view/PopUpAddMovie.fxml" ) );
        root2 = (Parent) fxmlLoader.load();
        if (isEditing) {
            fxmlLoader.<PopUpAddMovieController>getController().setInfo( IstMovies.getSelectionModel().getSelectedItem() );
        }
        fxmlLoader.<PopUpAddMovieController>getController().setController( this );

        Stage stage = new Stage();
        stage.setScene( new Scene( root2 ) );
        stage.centerOnScreen();
        stage.show();
    }
}
