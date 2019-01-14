package junit;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * Base class for the model classes.
 */
public abstract class JSONBase {
    String genre;
    String format;
    String year;

    public JSONBase(String g, String f, String y){
        this.year = y;
        this.genre = g;
        this.format = f;
    }

    /**
     * Method returning year value.
     * @return
     */
    public String getYear(){
        return this.year;
    }
    /**
     * Method returning format value.
     * @return
     */
    public String getFormat(){
        return this.format;
    }

    /**
     * Method returning genre value.
     * @return
     */
    public String getGenre(){
        return this.genre;
    }
    /**
     * Method returning the JSON.
     * @return
     */
    public JSONObject getJSONFile(){
        JSONObject obj = new JSONObject();
        obj.put("genre", this.genre);
        obj.put("year", this.year);
        obj.put("format", this.format);

        return obj;
    }
}
