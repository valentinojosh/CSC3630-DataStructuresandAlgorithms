public class DBBook {
    private String title;
    private String  author;
    private String  year;
    private String genre;

    public DBBook(String title, String author, String year, String genre) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getYear() {
        return year;
    }

    public String getGenre() {
        return genre;
    }
}