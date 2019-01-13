package junit;

import org.junit.Test;



import static org.junit.Assert.assertEquals;

public class BookTest {

    @Test
    public void testGetTitle()
    {
        String title = "Some test title";
        Book book = new Book(title);
        assertEquals(title, book.getTitle());
    }
}
