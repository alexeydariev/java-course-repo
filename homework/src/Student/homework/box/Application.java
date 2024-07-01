package Student.homework.box;

public class Application {
    public static void main(String[] args) {



        //Journal journal = new Journal(new Journal().setName("1"), 14, "vogue", "huita");

        Book book = new Book(new Book(), 44, "hz", "ebanat", 1488);
        Book anotherBook = new Book(new Book(),23, "kod shora", "govnomes", 1994);

        //book.setTitle(anotherBook.getTitle());
        Box firstBox = new Box(book);
        Box secondBox = new Box(book);
        //secondBox.setContent(book);
        System.out.println(firstBox);
        System.out.println(secondBox);

        System.out.println(firstBox.getClass());
    }
}
