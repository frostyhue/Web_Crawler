package junit;

import static junitparams.JUnitParamsRunner.$;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.json.simple.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Test class to cover the code of Scrapper class.
 */
public class ScrapperTest {

    /**
     * Test method that checks if the object returned is a JSON.
     */
    @Test
    public void testScrapperReturnsJSON() {
        Scrapper scrapper = new Scrapper("http://i358097.hera.fhict.nl/", "movie", "J.R.R. Tolkien");
        try {
            assertTrue(scrapper.getResultAsJSON() instanceof JSONObject);
            System.out.println(scrapper.getResultAsJSON());
        } catch (Exception e) {e.printStackTrace();}
    }

    /**
     * Test method that checks for the proper url.
     */
    @Test
    public void testScrapperIfHasProperUrl(){
        Scrapper mockScrapper = mock(Scrapper.class);

        try{
            when(mockScrapper.getUrl()).thenReturn("http://i358097.hera.fhict.nl/details.php?id=203");
        } catch (Exception e) {e.printStackTrace();}

        assertEquals(mockScrapper.getUrl(), "http://i358097.hera.fhict.nl/details.php?id=203");

    }
}
