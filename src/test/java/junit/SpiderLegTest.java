package junit;
import org.junit.Test;
import junit.SpiderLeg;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class SpiderLegTest {
    @Test
    public void testSpiderLegCrawlMethod()
    {
        SpiderLeg leg = new SpiderLeg();
        assertEquals(true, leg.crawl("https://www.google.com"));
    }
}
