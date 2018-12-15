package junit;

public class Music extends JSONBase{
    String artist;

    public Music(String g, String f, String y, String a) {
        super(g, f, y);
        this.artist = a;
    }

    public String getArtist(){
        return this.artist;
    }
}
