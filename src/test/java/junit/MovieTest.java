package junit;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class MovieTest {

    @Test
    public void testMovieIfConstructorSetsDirector(){
        Movie movieObj = new Movie("Fantasy", "Blu-ray", "2001", "Peter Jackson");

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
        Movie movieObj = new Movie("Fantasy", "Blu-ray", "2001", "Peter Jackson", "Movie", writersTest, starsTest);

        assertEquals("Fantasy", movieObj.getGenre());
        assertEquals("Blu-ray", movieObj.getFormat());
        assertEquals("2001", movieObj.getYear());
        assertEquals("Peter Jackson", movieObj.getDirector());
        assertEquals("Movie", movieObj.getCategory());
        assertEquals(writersTest, movieObj.getWriters());
        assertEquals(starsTest, movieObj.getStars());
    }
}
