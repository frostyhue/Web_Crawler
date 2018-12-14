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

    @Test
    public void testIfNextURLReturnsURL() {
        Spider testObj = new Spider(10);

        assertEquals(testObj.getNextURL(), "https://testURL0.test");
        assertEquals(testObj.getNextURL(), "https://testURL1.test");
        assertEquals(testObj.getNextURL(), "https://testURL2.test");
        assertEquals(testObj.getNextURL(), "https://testURL3.test");
    }

    @Test
    public void testIfgetNextURLReturnsURLNotEqualsTest() {
        Spider testObj = new Spider(10);
        // Add a url that should not be the first one.

        assertNotEquals(testObj.getNextURL(), "https://testURL2.test");
        assertNotEquals(testObj.getNextURL(), "https://testURL3.test");
        assertNotEquals(testObj.getNextURL(), "https://testURL4.test");
    }
}
