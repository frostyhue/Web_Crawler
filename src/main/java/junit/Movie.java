package junit;

import org.json.simple.JSONObject;

import java.util.List;

public class Movie extends JSONBase {

    private String title;
    private String director;
    private String category;
    private List<String> writers;
    private List<String> stars;

    public Movie(String t, String g, String f, String y, String d, String c, List<String> w, List<String> s) {
        super(g, f, y);
        this.title = t;
        this.director = d;
        this.category = c;
        this.writers = w;
        this.stars = s;
    }

    public String getDirector() {
        return director;
    }

    public String getCategory() {
        return category;
    }

    public List<String> getWriters() {
        return writers;
    }

    public List<String> getStars() {
        return stars;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public JSONObject getJSONFile() {
        JSONObject obj = new JSONObject();
        obj.put("title", this.title);
        obj.put("genre", super.genre);
        obj.put("format", super.format);
        obj.put("year", super.year);
        obj.put("director", this.director);
        obj.put("category", this.category);
        obj.put("writers", this.writers);
        obj.put("stars", this.stars);
        return obj;
    }
}
