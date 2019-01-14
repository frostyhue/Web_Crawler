package junit;

import org.junit.Test;


import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
/**
 * Test class testing Book class.
 */
public class BookTest {
    /**
     * Test method that checks if title is returned.
     */
    @Test
    public void testGetTitle()
    {
        List<String> authors = new ArrayList<>();
        authors.add("Pesho");
        authors.add("Gosho");
        String title = "Some test title";
        junit.Book book = new junit.Book("Horror", "Audio", "1986", title, "Book", authors, "Pesho company", "1233123");
        assertEquals(title, book.getTitle());
    }

    /**
     * Test method to check if JSON is returned.
     */
    @Test
    public void testBookJSONReturn()
    {
        List<String> authors = new ArrayList<>();
        authors.add("Pesho");
        authors.add("Tosho");
        junit.Book book = new junit.Book("Horror", "Audio", "1927", "ScaryMofo", "Book", authors, "Pesho i Kompaniq", "12973123");
        assertEquals("{\"year\":\"1927\",\"isbn\":\"12973123\",\"genre\":\"Horror\",\"format\":\"Audio\",\"publisher\":\"Pesho i Kompaniq\",\"title\":\"ScaryMofo\",\"category\":\"Book\",\"authors\":[\"Pesho\",\"Tosho\"]}", book.getJSONFile().toJSONString());
    }

    /**
     * Mock test to check if instance of obj is of type Book.
     */
    private Book mockBook = mock(Book.class);
    @Test
    public void testMockBook()
    {
        assertTrue(mockBook instanceof Book);
    }
}
