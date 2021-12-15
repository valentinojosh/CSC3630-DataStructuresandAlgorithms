public class Book {
    private String title;
    private String author;
    private int milSold;

    public Book(String title, String author, int milSold) {
        this.title = title;
        this.author = author;
        this.milSold = milSold;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getMilSold() {
        return milSold;
    }

    public void setMilSold(int milSold) {
        this.milSold = milSold;
    }
}
