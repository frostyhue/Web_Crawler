package junit;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


public abstract class JSONBase {
    String genre;
    String format;
    String year;

    public JSONBase(String g, String f, String y){
        this.year = y;
        this.genre = g;
        this.format = f;
    }

    public String getYear(){
        return this.year;
    }

    public String getFormat(){
        return this.format;
    }

    public String getGenre(){
        return this.genre;
    }

    public JSONObject getJSONFile(){
        JSONObject obj = new JSONObject();
        obj.put("genre", this.genre);
        obj.put("year", this.year);
        obj.put("format", this.format);

        return obj;
    }
}
