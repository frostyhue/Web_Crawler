package junit;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Spider class that is the body of the project, where it gathers the data that is found from the SpiderLegs and makes it into a JSON file for the corresponding type.
 */
public class Spider {
    private int MAX_PAGES_TO_SEARCH;
    private Set<String> pagesVisited = new HashSet<String>();
    private List<String> pagesToVisit = new LinkedList<String>();

    /**
     * Spider class constructor that accepts the max amount of pages searched and doesn't allow them to be set if the criterion are not met
     * @param maxPages
     */
    public Spider(int maxPages) {
        if (maxPages > 10){
            throw new IllegalArgumentException("Max pages limit allowed exceeded, limit is 10 you tried: " + maxPages + "!");
        }
        if (maxPages < 0){
            throw new IllegalArgumentException("Can not set max page limit to less than 0!");
        }
        this.pagesToVisit.add("https://testURL0.test");
        this.pagesToVisit.add("https://testURL1.test");
        this.pagesToVisit.add("https://testURL2.test");
        this.pagesToVisit.add("https://testURL3.test");
        MAX_PAGES_TO_SEARCH = maxPages;
    }

    /**
     * Return the max number of pages to search.
     * @return
     */
    public int getNrOfMaxPages(){
        return this.MAX_PAGES_TO_SEARCH;
    }

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
     * Return the JSON format of the Music objects.
     * @param genre
     * @param format
     * @param year
     * @param artist
     * @return
     */
    public Music getMusic(String genre, String format, String year, String artist)
    {
        Music m = new Music(genre,format, year, artist);
        return m;
    }

    /**
     * Return the JSON format of the Movie objects.
     * @param genre
     * @param format
     * @param year
     * @param director
     * @param writers
     * @param stars
     * @return
     */
    public Movie getMovie(String genre, String format, String year, String director, String writers, String stars){
        Movie m = new Movie(genre, format, year, director, stars, writers);
        return m;
    }

}
