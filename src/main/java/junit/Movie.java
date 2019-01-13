package junit;

public class Movie extends JSONBase {

    public String director;

    public Movie(String g, String f, String y, String d) {
        super(g, f, y);
        this.director = d;
    }
}
