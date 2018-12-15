package junit;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class SpiderTest {
    private static final String genreMovie = "akshon";
    private static final String yearMovie = "2000";
    private static final String formatMovie = "ple-bei";
    private static final String directorMovie = "sasho";
    private static final String starsMovie = "roman";
    private static final String writersMovie = "borko";
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
        // Add a url that should not be the first one..

        assertNotEquals(testObj.getNextURL(), "https://testURL2.test");
        assertNotEquals(testObj.getNextURL(), "https://testURL3.test");
        assertNotEquals(testObj.getNextURL(), "https://testURL4.test");
    }

    @Test
    public void testMockMovieGenre() {
        Movie m = mock(Movie.class);
        Spider sut = new Spider(10);

        when(m.getDirector()).thenReturn(directorMovie);
        when(m.getYear()).thenReturn(yearMovie);
        when(m.getFormat()).thenReturn(formatMovie);
        when(m.getGenre()).thenReturn(genreMovie);
        when(m.getStars()).thenReturn(starsMovie);
        when(m.getWriters()).thenReturn(writersMovie);


        sut.getMovie(m.getGenre(), m.getFormat(), m.getYear(), m.getDirector(), m.getWriters(), m.getStars());
        verify(m).getGenre();
    }
}
