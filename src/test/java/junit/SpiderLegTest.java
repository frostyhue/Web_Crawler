package junit;
import junitparams.JUnitParamsRunner;
import org.junit.Test;
import junit.SpiderLeg;
import org.junit.runner.RunWith;
import junitparams.Parameters;

import java.util.Random;

import static junitparams.JUnitParamsRunner.$;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.*;

/**
 * Test class checking the accuracy of the SpiderLeg class methods.
 */
@RunWith(JUnitParamsRunner.class)
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

    /**
     * Test method checking if searchForWork() returns true if word is found.
     */
    @Test
    public void testSearchForWord()
    {
        SpiderLeg leg = new SpiderLeg();
        String url = "https://www.google.com";
        leg.crawl(url);
        assertEquals(true, leg.searchForWord("Google"));
    }

    private static final Object[] getWord()
    {
        return $("Google", "Bone");
    }

    /**
     * Parameterised test method checking for saved links.
     * @param word
     */
    @Test
    @Parameters(method = "getWord")
    public void checkParametersForGetLinks(String word)
    {
        SpiderLeg leg = new SpiderLeg();
        String url = "https://www.google.com";
        leg.crawl(url);
        assertEquals(true, leg.searchForWord(word));
    }

    /**
     * Test method checking for instance of SpiderLeg.
     */
    public SpiderLeg mockLeg = mock(SpiderLeg.class);
    @Test
    public void testSpiderLegMock()
    {
        assertTrue(mockLeg instanceof SpiderLeg);
    }
}
