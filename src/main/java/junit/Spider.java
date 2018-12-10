package junit;

public class Spider {
    private int MAX_PAGES_TO_SEARCH;

    public Spider(int maxPages) {
        if (maxPages > 10){
            throw new IllegalArgumentException("Max pages limit allowed exceeded, limit is 10 you tried: " + maxPages + "!");
        }
        MAX_PAGES_TO_SEARCH = maxPages;
    }

    public int getNrOfMaxPages(){
        return this.MAX_PAGES_TO_SEARCH;
    }

}
