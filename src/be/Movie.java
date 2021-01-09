package be;

public class Movie {
    private int id;
    private String title;
    private String category;
    private float rating;
    private String location;
    private String lastView;

    public Movie(int id, String title, String category, float rating, String location, String lastView){
        this.id = id;
        this.title = title;
        this.category = category;
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

    public String getCategory(){
        return category;
    }

    public void setCategory(String category){
        this.category = category;
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

    public void setLocation(String location){ this.location = location; }

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