package junit;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Spider {
    private int MAX_PAGES_TO_SEARCH;
    public Set<String> pagesVisited = new HashSet<String>();
    public List<String> pagesToVisit = new LinkedList<String>();

    public Spider(int maxPages) {
        if (maxPages > 10){
            throw new IllegalArgumentException("Max pages limit allowed exceeded, limit is 10 you tried: " + maxPages + "!");
        }
        if (maxPages < 0){
            throw new IllegalArgumentException("Can not set max page limit to less than 0!");
        }
        MAX_PAGES_TO_SEARCH = maxPages;
    }

    public int getNrOfMaxPages(){
        return this.MAX_PAGES_TO_SEARCH;
    }

    public String getNextURL(){
        String nextUrl;
        do{
            nextUrl = this.pagesToVisit.remove(0);
        } while(this.pagesVisited.contains(nextUrl));
        this.pagesVisited.add(nextUrl);
        return nextUrl;
    }

}
