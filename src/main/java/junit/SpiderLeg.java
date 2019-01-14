package junit;

import org.jsoup.Jsoup;
import org.jsoup.Connection;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Document;

import javax.sound.sampled.SourceDataLine;
import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

/**
 * Class that handles the search of the key word on the web-page to gather the data needed and return it to the Spider body so that it converts it into a corresponding JSON.
 */
public class SpiderLeg {
    private static final String USER_AGENT =
            "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.1 (KHTML, like Gecko) Chrome/13.0.782.112 Safari/535.1";
    private List<String> links = new LinkedList<String>();
    private Document doc;
    private String url;

    public SpiderLeg()
    {
    }

    /**
     * Method that searches the website and links inside of it for the key word.
     * @param url
     * @return
     */
    public boolean crawl(String url)
    {

        try{
            Connection connection = Jsoup.connect(url).userAgent(USER_AGENT);
            Document htmlDoc = connection.get();
            this.doc = htmlDoc;
            if(doc == null)
            {return false;}
            else {
                if (connection.response().statusCode() == 200) {
                    System.out.println("\nCrawling site... Working on: " + url);
                }
                if (!connection.response().contentType().contains("text/html")) {
                    System.out.println("\nError... Did not retrieve HTML.");
                    return false;
                }
            }

            Elements linksOnPage = doc.select("a[href]");
            System.out.println("Found (" + linksOnPage.size() + ") links");
            for(Element link : linksOnPage)
            {
                this.links.add(link.absUrl("href"));
            }
            return true;
        }
        catch(IOException e)
        {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * The method that checks for the wanted word inside of the links.
     * @param w
     * @return
     */
    public boolean searchForWord(String w)
    {
        if(doc == null)
        {
            System.out.println("HTML Document is empty. Please use crawl() to fill in the document before searching for a word.");
            return false;
        }

        System.out.println("Searching for " + w );
        String text = doc.body().text();
        return text.toLowerCase().contains(w.toLowerCase());
    }

    /**
     * Method returning the links.
     * @return
     */
    public List<String> getLinks() {
        return this.links;
    }
}
