package be;

public class Movie {
    private int id;

    private String name;
    private float rating;

    private String filelink;
    private String lastview;

    public Movie(int id, String name, float rating, String filelink, String lastview){
        this.id = id;
        this.name = name;
        this.rating = rating;
        this.filelink = filelink;
        this.lastview = lastview;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public float getRating(){
        return rating;
    }

    public void setRating(float rating){
        this.rating = rating;
    }

    public String getFilelink(){
        return filelink;
    }

    public void setFilelink(String filelink){
        this.filelink = filelink;
    }

    public String getLastview(){
        return lastview;
    }

    public void setLastview(String lastview){
        this.lastview = lastview;
    }

    @Override
    public String toString() {
        return getName();
    }
}
