package junit;

import org.json.simple.JSONObject;

import java.util.List;

/**
 * Class used to make the model of the Movie JSON.
 */
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

    /**
     * Method returning title variable.
     * @return
     */
    public String getTitle() {
        return title;
    }

    /**
     * Method returning director variable.
     * @return
     */
    public String getDirector() {
        return director;
    }

    /**
     * Method returning category variable.
     * @return
     */
    public String getCategory() {
        return category;
    }

    /**
     * Method returning writers variable.
     * @return
     */
    public List<String> getWriters() {
        return writers;
    }

    /**
     * Method returning stars variable.
     * @return
     */
    public List<String> getStars() {
        return stars;
    }

    /**
     * Method returning the JSON.
     * @return
     */
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
