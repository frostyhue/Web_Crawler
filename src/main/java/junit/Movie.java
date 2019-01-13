package junit;

public class Movie extends JSONBase {

    private String director;

    public Movie(String g, String f, String y, String d) {
        super(g, f, y);
        this.director = d;
    }

    public String getDirector() {
        return director;
    }
}
