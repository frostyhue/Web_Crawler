package junit;

import org.junit.Test;
import static org.junit.Assert.*;

public class MovieTest {

    @Test
    public void testMovieIfConstructorSetsDirector(){
        Movie movieObj = new Movie("Fantasy", "Blu-ray", "2001", "Peter Jackson");

        assertEquals("Peter Jackson", movieObj.getDirector());
    }
}
