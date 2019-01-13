package junit;

import org.json.simple.JSONObject;

public class Music extends JSONBase{
    String artist;
    String category;

    public Music(String g, String f, String y, String a, String c) {
        super(g, f, y);
        this.artist = a;
        this.category = c;
    }

    public String getArtist(){
        return this.artist;
    }

    @Override
    public JSONObject getJSONFile() {
        JSONObject obj = new JSONObject();
        obj.put("artist", this.artist);
        obj.put("category", this.category);
        obj.put("genre", this.genre);
        obj.put("year", this.year);
        obj.put("format", this.format);
        return obj;
    }
}
