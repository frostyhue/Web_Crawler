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


}
