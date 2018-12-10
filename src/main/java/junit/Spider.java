package junit;

public class Spider {
    private int MAX_PAGES_TO_SEARCH;

    public Spider(int maxPages) {
        MAX_PAGES_TO_SEARCH = maxPages;
    }

    public int getNrOfMaxPages(){
        return this.MAX_PAGES_TO_SEARCH;
    }
}
