package junit;

import org.junit.Test;

import static org.junit.Assert.*;

public class SpiderTest {

    @Test
    public void testSpiderMaxPagesToSearchIfExceedsLimit() {
        Spider testSpider = new Spider(5);
        assertEquals(5,testSpider.getNrOfMaxPages());
    }
}
