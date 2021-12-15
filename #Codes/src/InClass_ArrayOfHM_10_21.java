import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class InClass_ArrayOfHM_10_21 {
    public static void main(String[] args) {
        ArrayList<Book> books = getMeTheData();

        HashMap< String, ArrayList<Book>> byAuthor = arrangeTheBooks(books);
        String theAuthor = "Asimov";
        showMeTheBooksFor(theAuthor, byAuthor);
    }

    private static void showMeTheBooksFor(String theAuthor, HashMap<String, ArrayList<Book>> byAuthor) {
        if(!byAuthor.containsKey(theAuthor)){
            System.out.printf("\n Sorry noo books for %s", theAuthor);
        }
        else{
            ArrayList<Book> theList = byAuthor.get(theAuthor);
            for(Book b: theList){
                System.out.printf("\n Author:%s Book:%s Sales:%s", b.getAuthor(), b.getTitle(), b.getMilSold());
            }
        }
    }

    private static HashMap<String, ArrayList<Book>> arrangeTheBooks(ArrayList<Book> books) {
        HashMap< String, ArrayList<Book>> byAuthor = new HashMap<>();
        for (Book b : books){
            if(!byAuthor.containsKey(b.getAuthor())){
                String author = b.getAuthor();
                ArrayList<Book> theList = new ArrayList<>();
                theList.add(b);
                byAuthor.put(author, theList);
            }else{
                ArrayList<Book> theList = byAuthor.get(b.getAuthor());
                theList.add(b);
                byAuthor.put(b.getAuthor(), theList);
            }
        }
        return byAuthor;
    }

    private static ArrayList<Book> getMeTheData() {
        ArrayList<Book> books = new ArrayList<>();
        books.add( new Book("The Fellowship of the Ring", "Tolkien", 1200 ));
        books.add( new Book("Return of the King", "Tolkien", 500 ));
        books.add( new Book("The Hobbit", "Tolkien", 900 ));
        books.add( new Book("The Two Towers", "Tolkien", 900 ));
        books.add( new Book("I Robot", "Asimov", 300 ));
        books.add( new Book("Foundation", "Asimov", 1300 ));
        books.add( new Book("Foundation and Empire", "Asimov", 1200 ));
        books.add( new Book("Foundation's Edge", "Asimov", 1200 ));
        return books;
    }
}
