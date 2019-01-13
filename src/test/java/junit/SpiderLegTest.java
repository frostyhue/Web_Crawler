package junit;
import org.junit.Test;
import junit.SpiderLeg;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class SpiderLegTest {
    /**
     * This test tests direct output of the method crawl.
     */
    @Test
    public void testSpiderLegCrawlMethod()
    {
        SpiderLeg leg = new SpiderLeg();
        assertEquals(true, leg.crawl("https://www.google.com"));
    }

    /**
     * This test tests direct input of the method crawl. If the url isn't https or
     * does not contain that in it, the test will fail, because the url is not correct.
     */
    @Test
    public void testSpiderLegCrawlDirectInput()
    {
        SpiderLeg leg = new SpiderLeg();
        String url = "https://www.google.com";
        assertEquals(true, leg.crawl(url));
    }

    @Test
    public void testSearchForWord()
    {
        SpiderLeg leg = new SpiderLeg();
        String url = "https://www.google.com";
        leg.crawl(url);
        assertEquals(true, leg.searchForWord("Google"));
    }
}
