package junit;

public class Movie extends JSONBase {

    String director;
    String writers;
    String stars;


    public Movie(String g, String f, String y,String d,String s,String w) {
        super(g, f, y);
        this.director = d;
        this.writers = w;
        this.stars = s;

    }

    public String getDirector(){
        return this.director;
    }

    public String getStars(){
        return this.stars;
    }

    public String getWriters(){
        return this.writers;
    }
}
