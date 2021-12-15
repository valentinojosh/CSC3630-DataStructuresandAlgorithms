import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class InClassBook_9_23 {
    public static void main(String[] args) {
        Stack<String> books = new Stack<>();
        books.push("Lord of the Rings");
        books.push("Old Yeller");
        books.push("Mutiny on the Bounty");
        books.push("Harry Potter");
        String b = books.pop();
        System.out.printf("\n B:%s", b);

        System.out.printf("\n B:%s", b);
        for ( String book : books ){
            System.out.printf("\n B:%s", book);
        }
        System.out.printf("\n --------------");
        System.out.println( books );
        System.out.printf("----DQ----");
        Deque<String> DQBooks = new ArrayDeque<>();
        DQBooks.push("The Abbey");
        DQBooks.push("Das Boat");
        DQBooks.push("The Cook");
        for(String b2 : DQBooks){
            System.out.printf("\n DQBook: %s", b2);
        }
        //Stack doesn't preserve stack over by iterating over it, but Deque does
        System.out.printf("\n -----------DeQue of Books-----------");

        //So essentially it is better to use a deque to create a stack rather than an actual stack
        Deque<DBBook> bookStack = getMeTheBooks();
        showMeTheStack(bookStack);
    }

    private static void showMeTheStack(Deque<DBBook> bookStack) {
        for( DBBook dBook : bookStack ){
            System.out.printf("\n T:%s A:%s Y:%s",
                    dBook.getTitle(), dBook.getAuthor(), dBook.getYear());
        }
    }

    private static Deque<DBBook> getMeTheBooks() {
        Deque<DBBook> DQStack = new ArrayDeque<>();
        DQStack.push(new DBBook("Abbey", "Art Jones", "1998", "Fantasy"));
        DQStack.push( new DBBook( "The Baker", "Bart Jones", "1901",
                "Fantasy"));
        DQStack.push( new DBBook( "The Cake", "Cathy Jones", "1921",
                "Fantasy"));
        return DQStack;
    }



//    public String pop() throws IllegalAccessException {
//        String item = null;
//        if (top > 0){
//            item = items[--top];
//        } else{
//            //System.out.printf("\n Oh oh gotta go problems");
//            throw new IllegalAccessException("Too many pops");
//        }
//        return item;
//    }
//
//    private void increaseSize(){
//
//    }
}
