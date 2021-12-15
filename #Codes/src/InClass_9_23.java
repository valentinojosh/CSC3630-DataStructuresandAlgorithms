import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class InClass_9_23 {
    public static void main(String[] args) {
        Stack<String> books = new Stack<>();
        books.push("Lord of the Rings");
        books.push("Old Yeller");
        books.push("Mutiny on the Bounty");
        books.push("Harry Potter");
        String b = books.pop();
        System.out.printf("\n B:%s", b);
        for ( String book : books ){
            System.out.printf("\n B:%s", book);
        }
        System.out.printf("\n --------------");
        System.out.println( books );
        System.out.printf("\n ---DQ -----------");
        Deque<String> DBBooks = new ArrayDeque<>();
        DBBooks.push("The Abbey");
        DBBooks.push("Das Boat");
        DBBooks.push("The Cook");
        for( String b2 : DBBooks ){
            System.out.printf("\n DBook:%s ", b2 );
        }
        System.out.printf("\n ----------- DeQue of Books ");
        Deque<DBBook>  bStack = getMeTheBooks();
        showMeTheStack( bStack  );
    }

    private static void showMeTheStack(Deque<DBBook> bStack) {
        for( DBBook dBook : bStack ){
            System.out.printf("\n T:%s A:%s Y:%s",
                    dBook.getTitle(), dBook.getAuthor(), dBook.getYear());
        }
    }

    private static Deque<DBBook> getMeTheBooks() {
        Deque<DBBook> DBStack = new ArrayDeque<>();
        //DBBook(String title, String author, int year, String genre)
        DBStack.push( new DBBook( "Abbey", "Art Jones", "1990",
                "Fantasy"));
        DBStack.push( new DBBook( "The Baker", "Bart Jones", "1901",
                "Fantasy"));
        DBStack.push( new DBBook( "The Cake", "Cathy Jones", "1921",
                "Fantasy"));
        return DBStack;
    }
}
