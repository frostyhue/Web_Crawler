package junit;
import org.json.simple.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.Connection;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Document;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Class that is used to return JSON format string by checking the provided website for the needed information to create it.
 */
public class Scrapper {

    private String url;
    private String type;
    private Spider spider;

    /**
     * Method that goes through the format of the webpage and creates a obj of the type specified.
     * @param url
     * @param type
     * @param word
     */
    public Scrapper(String url, String type, String word){
        spider = new Spider();
        this.url = spider.search(url, word);
        this.type = type;

    }

    /**
     * Method returning the url.
     * @return
     */
    public String getUrl(){
        return this.url;
    }

    /**
     * Method that returns JSON based on the type specified, using the model classes and Spider class.
     * @return
     * @throws Exception
     */
    public JSONObject getResultAsJSON() throws Exception{
        Document doc = Jsoup.connect(this.url).get();

        //common variables
        String title = doc.select("div.media-details h1").text();

        ArrayList<String> data = new ArrayList<>();

        Elements table = doc.select("div.media-details table td");
        for (Element entry: table){
            data.add(entry.text());
        }
        String cat = data.get(0);
        String genre = data.get(1);
        String format = data.get(2);
        String year = data.get(3);


            if(this.type == "movie"){
                //variables
                String director = data.get(4);
                List<String> writers = new ArrayList<>();

                String[] writersArray = data.get(5).split(", ");
                writers = Arrays.asList(writersArray);

                List<String> stars = new ArrayList<>();

                String[] starsArray = data.get(6).split(", ");
                stars = Arrays.asList(starsArray);
                Movie m = new Movie(title, genre, format, year, director, cat, writers, stars);

                return m.getJSONFile();
            } else if(this.type == "book"){
                //variables
                List<String> authors = new ArrayList<>();

                String[] authorsArray = data.get(4).split(", ");
                authors = Arrays.asList(authorsArray);

                String publisher = data.get(5);
                String isbn = data.get(6);

                junit.Book b = new junit.Book(genre, format, year, title, cat, authors, publisher, isbn);
            } else if (this.type == "music") {
                String artist = data.get(4);
                Music m = new Music(title, genre, format,year, artist, cat);
                return m.getJSONFile();
            }
        return null;
    }
}
