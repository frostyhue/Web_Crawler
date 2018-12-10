package junit;

import org.junit.Test;

import static org.junit.Assert.*;

public class SpiderTest {

    @Test
    public void testSpiderMaxPagesToSearchIfExceedsLimit() {
        Spider testSpider = new Spider(5);
        assertEquals(5,testSpider.getNrOfMaxPages());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSpiderIfAllowsForMaxPagesLimitOf10ToBeExceeded() {
        Spider testSpider = new Spider(11);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSpiderIfNotAllowsForMaxPagesToBeLessThan0() {
        Spider testSpider = new Spider(-1);
    }
}
