package junit;

import org.json.simple.JSONObject;

/**
 * Class that creates the Model of type Music into a JSON.
 */
public class Music extends JSONBase{
    private String artist;
    private String category;
    private String title;

    public Music(String t, String g, String f, String y, String a, String c) {
        super(g, f, y);
        this.title = t;
        this.artist = a;
        this.category = c;
    }

    /**
     * Method returning artist variable.
     * @return
     */
    public String getArtist(){
        return this.artist;
    }

    /**
     * Method returning category variable.
     * @return
     */
    public String getCategory(){
        return this.category;
    }

    /**
     * Method returning title variable.
     * @return
     */
    public String getTitle(){
        return this.title;
    }

    /**
     * Method that returns the JSON.
     * @return
     */
    @Override
    public JSONObject getJSONFile() {
        JSONObject obj = new JSONObject();
        obj.put("title", this.title);
        obj.put("artist", this.artist);
        obj.put("category", this.category);
        obj.put("genre", this.genre);
        obj.put("year", this.year);
        obj.put("format", this.format);
        return obj;
    }
}