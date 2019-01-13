package junit;

import org.junit.Test;



import static org.junit.Assert.assertEquals;

public class BookTest {

    @Test
    public void testGetTitle()
    {
        String title = "Some test title";
        Book book = new Book("Horror", "Audio", "1986", title, "Book", "Pesho i Gosho", "Pesho company", "1233123");
        assertEquals(title, book.getTitle());
    }

    @Test
    public void testBookJSONReturn()
    {
        Book book = new Book("Horror", "Audio", "1927", "ScaryMofo", "Book", "Pesho i Tosho", "Pesho i Kompaniq", "12973123");
        assertEquals("{\"year\":\"1927\",\"isbn\":\"12973123\",\"genre\":\"Horror\",\"format\":\"Audio\",\"publisher\":\"Pesho i Kompaniq\",\"title\":\"ScaryMofo\",\"category\":\"Book\",\"authors\":\"Pesho i Tosho\"}", book.getJSONFile().toJSONString());
    }
}
