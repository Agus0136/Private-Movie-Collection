package be;

public class Movie {
    private int id;
    private String title;
    private int playTime;
    private String category;
    private float myRating;
    private String location;
    private String playCount;
    private String lastPlayed;

    public Movie(int id, String title, int playTime, String category, float myRating, String location, String playCount, String lastPlayed){
        this.id = id;
        this.title = title;
        this.playTime = playTime;
        this.category = category;
        this.myRating = myRating;
        this.location = location;
        this.playCount = playCount;
        this.lastPlayed = lastPlayed;
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

    public int getPlayTime(){
        return playTime;
    }

    public void setPlayTime(int playTime){
        this.playTime = playTime;
    }

    public String getCategory() { return category; }

    public void setCategory(String category) { this.category = category; }

    public float getMyRating(){
        return myRating;
    }

    public void setMyRating(float myRating){
        this.myRating = myRating;
    }

    public String getLocation(){
        return location;
    }

    public void setLocation(String location){
        this.location = location;
    }

    public String getPlayCount(){
        return playCount;
    }

    public void setPlayCount(String playCount){
        this.playCount = playCount;
    }

    public String getLastPlayed(){
        return lastPlayed;
    }

    public void setLastPlayed(String lastPlayed){
        this.lastPlayed = lastPlayed;
    }

    @Override
    public String toString() {
        return getTitle();
    }

    public String getPlaytimeString() {
        String minutesString;
        String secondString;
        int minutes = playTime / 60;
        if (minutes < 10) {
            minutesString = "0" + minutes;
        } else {
            minutesString = "" + minutes;
        }
        int seconds = playTime % 60;
        if (10 > seconds) {
            secondString = "0" + seconds;
        } else {
            secondString = "" + seconds;
        }
        return minutesString + ":" + secondString;
    }
}
