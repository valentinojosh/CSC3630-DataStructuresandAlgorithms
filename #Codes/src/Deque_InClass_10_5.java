import java.util.Deque;
import java.util.LinkedList;

public class Deque_InClass_10_5 {
    public static void main(String[] args) {
        Deque<DBBook> deqBooks = getMeTheBooks();
        showInStackOrder(deqBooks);
    }

    private static void showInStackOrder(Deque<DBBook> deqBooks) {
        int ct = 0;
        for(DBBook book : deqBooks){
            System.out.printf("\n ct:%s Item:%s", ct, book.getTitle());
            ct++;
        }
    }

    private static Deque<DBBook> getMeTheBooks() {
        Deque<DBBook> deqBooks = new LinkedList<>();
        deqBooks.push(new DBBook("Meow", "Me", "1999", "Taco"));
        deqBooks.push(new DBBook("Meow 2", "Me", "1999", "Taco"));
        deqBooks.push(new DBBook("Meow 3", "Me", "1999", "Taco"));

        return deqBooks;
    }
}
