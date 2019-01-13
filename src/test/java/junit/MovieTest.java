package junit;

import org.json.simple.JSONObject;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MovieTest {

    @Test
    public void testMovieIfConstructorSetsDirector(){
        List<String> stars = new ArrayList<>();
        List<String> writers = new ArrayList<>();
        Movie movieObj = new Movie("Lord of The rings","Fantasy", "Blu-ray", "2001", "Peter Jackson", "Another Movie", stars, writers);

        assertEquals("Peter Jackson", movieObj.getDirector());
    }

    @Test
    public void testMovieIfConstructorSetsVariablesProperly(){
        List<String> writersTest = new ArrayList<>();
        writersTest.add("Peter");
        writersTest.add("George");
        List<String> starsTest = new ArrayList<>();
        starsTest.add("Kosta");
        starsTest.add("Zeus");
        Movie movieObj = new Movie("Bambi","Fantasy", "Blu-ray", "2001", "Peter Jackson", "Movie", writersTest, starsTest);

        assertEquals("Bambi", movieObj.getTitle());
        assertEquals("Fantasy", movieObj.getGenre());
        assertEquals("Blu-ray", movieObj.getFormat());
        assertEquals("2001", movieObj.getYear());
        assertEquals("Peter Jackson", movieObj.getDirector());
        assertEquals("Movie", movieObj.getCategory());
        assertEquals(writersTest, movieObj.getWriters());
        assertEquals(starsTest, movieObj.getStars());
    }

    @Test
    public void testJsonObjectsSize(){
        List<String> writersTest = new ArrayList<>();
        writersTest.add("Peter");
        writersTest.add("George");
        List<String> starsTest = new ArrayList<>();
        starsTest.add("Kosta");
        starsTest.add("Zeus");
        Movie movieObj = new Movie("Bambi","Fantasy", "Blu-ray", "2001", "Peter Jackson", "Movie", writersTest, starsTest);

        assertEquals(movieObj.getJSONFile().size(), 8);
    }

    /**
     * Mock test for Movie title attribute.
     */
    @Test
    public void testMovieTitle(){
        Movie mockMovie = mock(Movie.class);

        when(mockMovie.getTitle()).thenReturn("Lord of The Rings");

        assertEquals(mockMovie.getTitle(), "Lord of The Rings");

        when(mockMovie.getTitle()).thenReturn("Bambi");

        assertEquals(mockMovie.getTitle(), "Bambi");

        when(mockMovie.getTitle()).thenReturn("Snow White");

        assertEquals(mockMovie.getTitle(), "Snow White");
    }

    /**
     * Mock test for Movie stars attribute.
     */
    @Test
    public void testMovieStars(){
        Movie mockMovie = mock(Movie.class);

        List<String> testList = new ArrayList<>();
        testList.add("Frodo");
        testList.add("Zelda");

        when(mockMovie.getStars()).thenReturn(testList);

        assertEquals(mockMovie.getStars(), testList);

        testList = new ArrayList<>();
        testList.add("Ganon");
        testList.add("Kirito");

        when(mockMovie.getStars()).thenReturn(testList);

        assertEquals(mockMovie.getStars(), testList);

        testList = new ArrayList<>();
        testList.add("Link");
        testList.add("Koopa Troopa");

        when(mockMovie.getStars()).thenReturn(testList);

        assertEquals(mockMovie.getStars(), testList);
    }/**
     * Mock test for Movie getJSONFile size by default.
     */
    @Test
    public void testMovieJSONSizeDefault(){
        Movie mockMovie = mock(Movie.class);

        when(mockMovie.getFormat()).thenReturn("");
        when(mockMovie.getCategory()).thenReturn("");
        when(mockMovie.getYear()).thenReturn("");

        assertEquals(mockMovie.getJSONFile().size(), 3);

    }
}
