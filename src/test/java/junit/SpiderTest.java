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

    private static final Object[] setUrlAndWord(){
        return $(
                $("http://i358097.hera.fhict.nl/", "The Clean Coder: A Code of Conduct for Professional Programmers"),
                $("http://i358097.hera.fhict.nl/", "The Princess Bride"),
                $("http://i358097.hera.fhict.nl/", "No Fences")
        );
    }

    @Test
    @Parameters(method = "setUrlAndWord")
    public void testSearchReturnsAString(String url, String word){
        Spider spider = new Spider();

        assertTrue(spider.search(url,word) instanceof String);
    }
}
