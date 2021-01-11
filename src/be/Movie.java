package be;

import java.util.ArrayList;
import java.util.List;

public class Movie {

    private int id;
    private String title;

    private List<Category> allCategories;

    private float rating;
    private String location;
    private String lastView;

    public Movie(int id, String title, List Category, float rating, String location, String lastView){
        this.id = id;
        this.title = title;

        allCategories = new ArrayList<>();
        this.allCategories = Category;

        this.rating = rating;
        this.location = location;
        this.lastView = lastView;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public List<Category> getCategory() {
        return allCategories;
    }

    public void setAllCategories(List<Category> allCategories) {
        this.allCategories = allCategories;
    }

    public float getRating(){
        return rating;
    }

    public void setRating(float rating){
        this.rating = rating;
    }

    public String getLocation(){
        return location;
    }

    public void setLocation(String location){
        this.location = location;
    }

    public String getLastView(){
        return lastView;
    }

    public void setLastView(String lastView){
        this.lastView = lastView;
    }

    @Override
    public String toString() {
        return getTitle();
    }
}
