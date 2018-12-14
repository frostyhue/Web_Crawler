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

public class SpiderLeg {
    private static final String USER_AGENT =
            "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.1 (KHTML, like Gecko) Chrome/13.0.782.112 Safari/535.1";
    private List<String> links = new LinkedList<String>();
    private Document htmlDocument;
    private String url;
    public SpiderLeg()
    {
    }

    public boolean crawl(String url)
    {

        try{
            Connection connection = Jsoup.connect(url).userAgent(USER_AGENT);
            Document htmlDoc = connection.get();
            this.htmlDocument = htmlDoc;
            if(connection.response().statusCode() == 200)
            {
                System.out.println("\n**Visiting** Received web page at " + url);
            }
            if(!connection.response().contentType().contains("text/html"))
            {
                System.out.println("**Failure** Retrieved something other than HTML");
                return false;
            }

            Elements linksOnPage = htmlDocument.select("a[href]");
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
}
