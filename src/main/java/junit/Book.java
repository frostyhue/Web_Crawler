package junit;

import org.json.simple.JSONObject;

import java.util.List;

/**
 * Class covering Book model.
 */
public class Book extends JSONBase{
    private String title;
    private String category;
    private List<String> authors;
    private String publisher;
    private String isbn;


    public Book(String g, String f, String y, String title, String category, List<String> authors, String publisher, String isbn)
    {
        super(g, f, y);
        this.title = title;
        this.category = category;
        this.authors = authors;
        this.publisher = publisher;
        this.isbn = isbn;
    }

    /**
     * Method returning title variable.
     * @return
     */
    public String getTitle()
    {
        return this.title;
    }
    /**
     * Method returning the JSON.
     * @return
     */
    @Override
    public JSONObject getJSONFile() {
        JSONObject obj = new JSONObject();
        obj.put("title", this.title);
        obj.put("category", this.category);
        obj.put("genre", super.genre);
        obj.put("format", super.format);
        obj.put("year", super.year);
        obj.put("authors", this.authors);
        obj.put("publisher", this.publisher);
        obj.put("isbn", this.isbn);

        return obj;
    }
}
