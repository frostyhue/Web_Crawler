package junit;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Spider class that is the body of the project, where it gathers the data that is found from the SpiderLegs and makes it into a JSON file for the corresponding type.
 */
public class Spider {
    private int MAX_PAGES_TO_SEARCH = 50;
    private Set<String> pagesVisited = new HashSet<String>();
    private List<String> pagesToVisit = new LinkedList<String>();
    private String urlFound = "";
    private int urlsChecked = 0;


    /**
     * Get the next url in the hashedSet to process.
     * @return
     */
    public String getNextURL(){
        String nextUrl;
        do{
            nextUrl = this.pagesToVisit.remove(0);
        } while(this.pagesVisited.contains(nextUrl));
        this.pagesVisited.add(nextUrl);
        return nextUrl;
    }

    /**
     * Search though the given url and links found in it for the given word. Max number of pages that can be visited is 50.
     * @param url
     * @param word
     */
    public String search(String url, String word){
        while(this.pagesVisited.size() < this.MAX_PAGES_TO_SEARCH){
            this.urlsChecked++;
            System.out.println(String.format("Url nr %s being checked", this.urlsChecked));
            String currentUrl;
            SpiderLeg leg = new SpiderLeg();
            if(this.pagesToVisit.isEmpty()){
                currentUrl = url;
                this.pagesVisited.add(url);
                System.out.println(String.format("URL %s has been added to Visited urls list", url));
            }
            else {
                currentUrl = this.getNextURL();
                System.out.println(String.format("Current URL is %s", currentUrl));
            }
            leg.crawl(currentUrl);
            boolean successfulResponse = leg.searchForWord(word);
            if (successfulResponse){
                this.urlFound = currentUrl;
                System.out.println(String.format("Word %s found at %s", word, currentUrl));
                break;
            }
            this.pagesToVisit.addAll(leg.getLinks());
        }
        return this.urlFound;
    }
}
