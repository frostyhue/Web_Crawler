package junit;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static junitparams.JUnitParamsRunner.$;

/**
 * Spider test class covering every testable aspect of the class.
 */
@RunWith(JUnitParamsRunner.class)
public class SpiderTest {

    private static String testUrl = "http://i358097.hera.fhict.nl/";

    /**
     * Test method to check if the search() method from Spider object returns a string.
     * @return
     */
    private static final Object[] setUrlAndWord(){
        return $(
                $(testUrl, "The Clean Coder: A Code of Conduct for Professional Programmers"),
                $(testUrl, "The Princess Bride"),
                $(testUrl, "No Fences")
        );
    }

    /**
     * Test method to check if the search() method from Spider object returns the expected link.
     * @return
     */
    private static final Object[] setUrlAndWordWithResult(){
        return $(
                $(testUrl, "The Clean Coder: A Code of Conduct for Professional Programmers", "http://i358097.hera.fhict.nl/details.php?id=104"),
                $(testUrl, "The Princess Bride", "http://i358097.hera.fhict.nl/details.php?id=204"),
                $(testUrl, "No Fences", "http://i358097.hera.fhict.nl/details.php?id=303"),
                $(testUrl, "The Clean Coder: A Code of Conduct for Professional Programmers", "http://i358097.hera.fhict.nl/details.php?id=104"),
                $(testUrl, "J.R.R. Tolkien", "http://i358097.hera.fhict.nl/details.php?id=203")
                );
    }

    /**
     * Parameterised test method that checks if the url returned is of type string.
     * @param url
     * @param word
     */
    @Test
    @Parameters(method = "setUrlAndWord")
    public void testSearchReturnsAString(String url, String word){
        Spider spider = new Spider();

        assertTrue(spider.search(url,word) instanceof String);
    }

    /**
     * Parameterised test method that cheks if the search method returns the correct link.
     * @param url
     * @param word
     * @param result
     */
    @Test
    @Parameters(method = "setUrlAndWordWithResult")
    public void testSearchReturnsProperLink(String url, String word, String result){
        Spider spider = new Spider();

        assertEquals(result, spider.search(url,word));
    }

}
