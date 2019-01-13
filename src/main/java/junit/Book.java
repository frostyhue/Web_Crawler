package junit;

import org.json.simple.JSONObject;

public class Book extends JSONBase{
    private String title;
    private String category;
    private String genre;
    private String format;
    private String year;
    private String authors;
    private String publisher;
    private String isbn;


    public Book(String g, String f, String y, String title, String category, String authors, String publisher, String isbn)
    {
        super(g, f, y);
        this.title = title;
        this.category = category;
        this.authors = authors;
        this.publisher = publisher;
        this.isbn = isbn;
    }

    public String getTitle()
    {
        return this.title;
    }
}
